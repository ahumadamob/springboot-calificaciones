package com.imb2025.calificaciones.service.jpa;

import com.imb2025.calificaciones.entity.AsignacionDocente;
import com.imb2025.calificaciones.entity.Docente;
import com.imb2025.calificaciones.entity.Materia;
import com.imb2025.calificaciones.entity.Comision;
import com.imb2025.calificaciones.entity.PeriodoLectivo;
import com.imb2025.calificaciones.repository.AsignacionDocenteRepository;
import com.imb2025.calificaciones.repository.DocenteRepository;
import com.imb2025.calificaciones.repository.MateriaRepository;
import com.imb2025.calificaciones.repository.ComisionRepository;
import com.imb2025.calificaciones.repository.PeriodoLectivoRepository;
import com.imb2025.calificaciones.service.IAsignacionDocenteService;
import com.imb2025.calificaciones.dto.AsignacionDocenteRequestDTO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AsignacionDocenteServiceImp implements IAsignacionDocenteService {

    @Autowired
    private AsignacionDocenteRepository repository;

    @Autowired
    private DocenteRepository docenteRepository;

    @Autowired
    private MateriaRepository materiaRepository;

    @Autowired
    private ComisionRepository comisionRepository;

    @Autowired
    private PeriodoLectivoRepository periodoLectivoRepository;

    @Override
    public List<AsignacionDocente> findAll() {
        return repository.findAll();
    }

    @Override
    public AsignacionDocente findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public AsignacionDocente save(AsignacionDocenteRequestDTO dto) {
        try {
            AsignacionDocente asignacionDocente = new AsignacionDocente();

            Optional<Docente> docente = docenteRepository.findById(dto.getDocenteId());
            if (!docente.isPresent()) {
                throw new RuntimeException("Docente no encontrado con ID: " + dto.getDocenteId());
            }
            asignacionDocente.setDocente(docente.get());

            Optional<Materia> materia = materiaRepository.findById(dto.getMateriaId());
            if (!materia.isPresent()) {
                throw new RuntimeException("Materia no encontrada con ID: " + dto.getMateriaId());
            }
            asignacionDocente.setMateria(materia.get());

            Optional<Comision> comision = comisionRepository.findById(dto.getComisionId());
            if (!comision.isPresent()) {
                throw new RuntimeException("Comisión no encontrada con ID: " + dto.getComisionId());
            }
            asignacionDocente.setComision(comision.get());

            Optional<PeriodoLectivo> periodoLectivo = periodoLectivoRepository.findById(dto.getPeriodoLectivoId());
            if (!periodoLectivo.isPresent()) {
                throw new RuntimeException("Período lectivo no encontrado con ID: " + dto.getPeriodoLectivoId());
            }
            asignacionDocente.setPeriodoLectivo(periodoLectivo.get());

            return repository.save(asignacionDocente);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar la asignación docente: " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public AsignacionDocente update(Long id, AsignacionDocenteRequestDTO dto) {
        try {
            AsignacionDocente existingAsignacion = findById(id);
            if (existingAsignacion == null) {
                throw new RuntimeException("Asignación docente no encontrada con ID: " + id);
            }

            Optional<Docente> docente = docenteRepository.findById(dto.getDocenteId());
            if (!docente.isPresent()) {
                throw new RuntimeException("Docente no encontrado con ID: " + dto.getDocenteId());
            }
            existingAsignacion.setDocente(docente.get());

            Optional<Materia> materia = materiaRepository.findById(dto.getMateriaId());
            if (!materia.isPresent()) {
                throw new RuntimeException("Materia no encontrada con ID: " + dto.getMateriaId());
            }
            existingAsignacion.setMateria(materia.get());

            Optional<Comision> comision = comisionRepository.findById(dto.getComisionId());
            if (!comision.isPresent()) {
                throw new RuntimeException("Comisión no encontrada con ID: " + dto.getComisionId());
            }
            existingAsignacion.setComision(comision.get());

            Optional<PeriodoLectivo> periodoLectivo = periodoLectivoRepository.findById(dto.getPeriodoLectivoId());
            if (!periodoLectivo.isPresent()) {
                throw new RuntimeException("Período lectivo no encontrado con ID: " + dto.getPeriodoLectivoId());
            }
            existingAsignacion.setPeriodoLectivo(periodoLectivo.get());

            return repository.save(existingAsignacion);
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar la asignación docente: " + e.getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Asignación docente no encontrada con ID: " + id);
        }
        repository.deleteById(id);
    }
}