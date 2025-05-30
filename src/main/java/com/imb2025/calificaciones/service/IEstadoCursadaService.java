package com.imb2025.calificaciones.service;

import java.util.List;

import com.imb2025.calificaciones.entity.EstadoCursada;

public interface IEstadoCursadaService {

    EstadoCursada findById(Long id);

    List<EstadoCursada> findAll();

    EstadoCursada save(EstadoCursada estadoCursada);

    void deleteById(Long id);

}