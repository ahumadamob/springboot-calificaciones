package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.entity.AsignacionDocente;
import com.imb2025.calificaciones.repository.AsignacionDocenteRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignacionDocenteService {

    @Autowired
    private AsignacionDocenteRepository repository;

    public List<AsignacionDocente> findAll() {
        return repository.findAll();
    }

    public AsignacionDocente findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public AsignacionDocente save(AsignacionDocente asignacionDocente) {
        return repository.save(asignacionDocente);
    }

    public AsignacionDocente update(Long id, AsignacionDocente asignacionDocente) {
        asignacionDocente.setId(id);
        return repository.save(asignacionDocente);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}