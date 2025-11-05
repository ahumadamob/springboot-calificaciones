package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.request.TipoEvaluacionRequestDto;
import com.imb2025.calificaciones.entity.TipoEvaluacion;
import java.util.List;

public interface ITipoEvaluacionService {

    List<TipoEvaluacion> findAll();

    TipoEvaluacion create(TipoEvaluacion tipoEvaluacion);
    TipoEvaluacion update(TipoEvaluacion tipoEvaluacion, Long id);
    TipoEvaluacion findById(Long id);
    void deleteById(Long id);
    TipoEvaluacion fromDto(TipoEvaluacionRequestDto dto);

    List<TipoEvaluacion> buscarNombre(String q);
    long contarNombre(String q);
    
    TipoEvaluacion createFromDto(TipoEvaluacionRequestDto dto);
    TipoEvaluacion updateFromDto(Long id, TipoEvaluacionRequestDto dto);

}
