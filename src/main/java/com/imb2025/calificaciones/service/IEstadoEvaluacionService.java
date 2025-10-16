package com.imb2025.calificaciones.service;

import java.util.List;

import com.imb2025.calificaciones.dto.EstadoEvaluacionRequestDto;
import com.imb2025.calificaciones.entity.EstadoEvaluacion;

public interface IEstadoEvaluacionService {

    public List<EstadoEvaluacion> findAll();

    public EstadoEvaluacion findById(Long id);

    public boolean existsById(Long id);

    public EstadoEvaluacion create(EstadoEvaluacion estadoEvaluacion);

    public EstadoEvaluacion update(EstadoEvaluacion estadoEvaluacion, Long id) throws Exception;

    public void deleteById(Long id) throws Exception;

    public EstadoEvaluacion fromDto(EstadoEvaluacionRequestDto dto) throws Exception;

    public List<EstadoEvaluacion> findByNombre(String nombre);

    public long countByDescripcion(String descripcion);
}
