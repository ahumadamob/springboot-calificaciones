package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.EstadoEvaluacionRequestDto;
import com.imb2025.calificaciones.entity.EstadoEvaluacion;
import java.util.List;

public interface IEstadoEvaluacionService {

    public List<EstadoEvaluacion> findAll();

    public EstadoEvaluacion create(EstadoEvaluacion estadoEvaluacion);

    public EstadoEvaluacion update(EstadoEvaluacion estadoEvaluacion, Long id);

    public EstadoEvaluacion findById(Long id);

    public void deleteById(Long id);

    public EstadoEvaluacion fromDto(EstadoEvaluacionRequestDto dto) throws Exception;
}
