package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.entity.EstadoCursada;
import com.imb2025.calificaciones.repository.EstadoCursadaRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoCursadaServiceImp implements EstadoCursadaService {

    @Autowired
    private EstadoCursadaRepository repository;

    public List<EstadoCursada> findAll() {
        return repository.findAll();
    }

    public EstadoCursada findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public EstadoCursada save(EstadoCursada estadoCursada) {
        return repository.save(estadoCursada);
    }

    public EstadoCursada update(Long id, EstadoCursada estadoCursada) {
    	estadoCursada.setId(id);
        return repository.save(estadoCursada);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}