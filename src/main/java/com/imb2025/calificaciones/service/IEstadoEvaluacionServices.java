package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.entity.EstadoEvaluacion;

import java.util.List;



public interface IEstadoEvaluacionServices {

    List<EstadoEvaluacion> getAll();

    EstadoEvaluacion save(EstadoEvaluacion estado);

    EstadoEvaluacion update(Long id, EstadoEvaluacion estadoActualizado);

    void delete(Long id);

    EstadoEvaluacion findById(Long id);
}
