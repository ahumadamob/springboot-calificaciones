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

    @Override
    public List<EstadoCursada> findAll() {
        return repository.findAll();
    }
    
    @Override
    public EstadoCursada findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public EstadoCursada save(EstadoCursada estadoCursada) {
        return repository.save(estadoCursada);
    }
    @Override
    public EstadoCursada update(Long id, EstadoCursada estadoCursada) {
    	estadoCursada.setId(id);
        return repository.save(estadoCursada);
    }
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}