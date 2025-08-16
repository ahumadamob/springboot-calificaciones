package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.EstadoEvaluacionRequestDto;
import com.imb2025.calificaciones.entity.EstadoEvaluacion;
import java.util.List;

public interface IEstadoEvaluacionService {

    public List<EstadoEvaluacion> findAll();

    public EstadoEvaluacion findById(Long id);

    public EstadoEvaluacion create(EstadoEvaluacionRequestDto dto);

    public EstadoEvaluacion update(Long id, EstadoEvaluacionRequestDto dto);

    public void deleteById(Long id);

    public EstadoEvaluacion fromDto(EstadoEvaluacionRequestDto dto);
}
