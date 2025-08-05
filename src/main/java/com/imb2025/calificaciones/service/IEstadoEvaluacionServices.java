package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.EstadoEvaluacionRequestDTO;
import com.imb2025.calificaciones.entity.EstadoEvaluacion;

import java.util.List;

public interface IEstadoEvaluacionServices {

    List<EstadoEvaluacion> getAll();


    EstadoEvaluacion update(Long id, EstadoEvaluacion estadoEvaluacion);

    void delete(Long id);

    EstadoEvaluacion findById(Long id);

	EstadoEvaluacion save(EstadoEvaluacion estadoEvaluacion);
}
