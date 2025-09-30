package com.imb2025.calificaciones.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.dto.InscripcionMateriaRequestDto;
import com.imb2025.calificaciones.entity.InscripcionMateria;
import com.imb2025.calificaciones.entity.Materia;
import com.imb2025.calificaciones.entity.PeriodoLectivo;
import com.imb2025.calificaciones.exception.ResourceNotFoundException;
import com.imb2025.calificaciones.entity.Alumno;
import com.imb2025.calificaciones.repository.AlumnoRepository;
import com.imb2025.calificaciones.repository.MateriaRepository;
import com.imb2025.calificaciones.repository.PeriodoLectivoRepository;
import com.imb2025.calificaciones.repository.InscripcionMateriaRepository;
import com.imb2025.calificaciones.service.IInscripcionMateriaService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class InscripcionMateriaServiceImpl implements IInscripcionMateriaService {

    @Autowired
    private InscripcionMateriaRepository repository;

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private MateriaRepository materiaRepository;

    @Autowired
    private PeriodoLectivoRepository periodoLectivoRepository;

    @Override
    public List<InscripcionMateria> findAll() {
        return repository.findAll();
    }

    @Override
    public InscripcionMateria findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Inscripción no encontrada con ID: " + id));
    }

    @Override
    public InscripcionMateria create(InscripcionMateria inscripcionMateria) {
        return repository.save(inscripcionMateria);
    }

    @Override
    public InscripcionMateria update(InscripcionMateria inscripcionMateria, Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("No se encontró Inscripción con ID: " + id);
        }
        inscripcionMateria.setId(id);
        return repository.save(inscripcionMateria);
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("No se puede eliminar, ID no existe: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public InscripcionMateria fromDto(InscripcionMateriaRequestDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("El DTO de Inscripción Materia no puede ser nulo");
        }

        Alumno alumno = alumnoRepository.findById(dto.getAlumnoId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Alumno no encontrado con ID: " + dto.getAlumnoId()));

        Materia materia = materiaRepository.findById(dto.getMateriaId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Materia no encontrada con ID: " + dto.getMateriaId()));

        PeriodoLectivo periodo = periodoLectivoRepository.findById(dto.getPeriodoLectivoId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Periodo Lectivo no encontrado con ID: " + dto.getPeriodoLectivoId()));

        InscripcionMateria inscripcion = new InscripcionMateria();
        inscripcion.setAlumno(alumno);
        inscripcion.setMateria(materia);
        inscripcion.setPeriodoLectivo(periodo);

        return inscripcion;
    }
}
