package com.imb2025.calificaciones.service.jpa;

import java.time.LocalDate;
import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.entity.InscripcionMateria;
import com.imb2025.calificaciones.enums.EstadoInscripcionMateria;
import com.imb2025.calificaciones.exception.ResourceNotFoundException;

import com.imb2025.calificaciones.repository.InscripcionMateriaRepository;
import com.imb2025.calificaciones.service.IInscripcionMateriaService;

@Service
public class InscripcionMateriaServiceImpl implements IInscripcionMateriaService {

    @Autowired
    private InscripcionMateriaRepository repository;

    @Override
    public List<InscripcionMateria> findAll() {
        return repository.findAll();
    }

    @Override
    public InscripcionMateria findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Entidad no encontrada con id " + id));
    }

    @Override
    public List<InscripcionMateria> findByAlumno_Id(Long idAlumno) {
        return repository.findByAlumno_Id(idAlumno);
    }

    @Override
    public long countByAlumno_Id(Long idAlumno) {
        return repository.countByAlumno_Id(idAlumno);
    }

    @Override
    public InscripcionMateria create(InscripcionMateria inscripcionMateria) throws BadRequestException {

        if (repository.findByIdentificadorLegibleIgnoreCase(inscripcionMateria.getIdentificadorLegible()).isPresent()) {
            throw new BadRequestException("identificadorLegible duplicado");
        }

        if (inscripcionMateria.getAlumno() == null || inscripcionMateria.getMateria() == null
                || inscripcionMateria.getPeriodoLectivo() == null) {
            throw new BadRequestException("Alumno, Materia o PeriodoLectivo no pueden ser nulos");
        }

        return repository.save(inscripcionMateria);
    }

    @Override
    public InscripcionMateria update(InscripcionMateria inscripcionMateria, Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Entidad no encontrada con id " + id);
        }
        inscripcionMateria.setId(id);
        return repository.save(inscripcionMateria);
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Entidad no encontrada con id " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public List<InscripcionMateria> findByInscriptoTrue() {
        return repository.findByInscriptoTrue();
    }

    @Override
    public List<InscripcionMateria> findByInscriptoFalse() {
        return repository.findByInscriptoFalse();
    }

    @Override
    public List<InscripcionMateria> findByFechaVigenciaGreaterThanEqual(LocalDate fecha) {
        return repository.findByFechaVigenciaGreaterThanEqual(fecha);
    }

    @Override
    public List<InscripcionMateria> findByFechaVigenciaLessThan(LocalDate fecha) {
        return repository.findByFechaVigenciaLessThan(fecha);
    }

    @Override
    public List<InscripcionMateria> findVigentes() {
        return repository.findByFechaVigenciaGreaterThanEqual(LocalDate.now());
    }

    @Override
    public List<InscripcionMateria> findVencidos() {
        return repository.findByFechaVigenciaLessThan(LocalDate.now());
    }

    @Override
    public long countActivos() {
        return repository.countByEstado(EstadoInscripcionMateria.ACTIVO);
    }

    @Override
    public long countInactivos() {
        return repository.countByEstado(EstadoInscripcionMateria.INACTIVO);
    }
}
