package com.imb2025.calificaciones.service.jpa;

import com.imb2025.calificaciones.entity.AsignacionDocente;
import com.imb2025.calificaciones.repository.AsignacionDocenteRepository;
import com.imb2025.calificaciones.service.IAsignacionDocenteService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AsignacionDocenteServiceImp implements IAsignacionDocenteService {

    @Autowired
    private AsignacionDocenteRepository repository;

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
    public AsignacionDocente save(AsignacionDocente asignacionDocente) {
        try {
            return repository.save(asignacionDocente);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar la asignación docente: " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public AsignacionDocente update(AsignacionDocente asignacionDocente) {
        try {
            AsignacionDocente existingAsignacion = findById(asignacionDocente.getId());
            if (existingAsignacion == null) {
                throw new RuntimeException("Asignación docente no encontrada con ID: " + asignacionDocente.getId());
            }

            existingAsignacion.setDocente(asignacionDocente.getDocente());
            existingAsignacion.setMateria(asignacionDocente.getMateria());
            existingAsignacion.setComision(asignacionDocente.getComision());
            existingAsignacion.setPeriodoLectivo(asignacionDocente.getPeriodoLectivo());

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