package com.imb2025.calificaciones.service;

import java.util.List;

import com.imb2025.calificaciones.entity.EstadoCursada;

public interface EstadoCursadaService {

    EstadoCursada findById(Long id);

    List<EstadoCursada> findAll();

    EstadoCursada save(EstadoCursada estadoCursada);

    EstadoCursada update(Long id, EstadoCursada estadoCursada);

    void deleteById(Long id);

}