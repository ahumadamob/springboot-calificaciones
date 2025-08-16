package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.TipoEvaluacionRequestDto;
import com.imb2025.calificaciones.entity.TipoEvaluacion;
import java.util.List;

public interface ITipoEvaluacionService {

    public List<TipoEvaluacion> findAll();

    public TipoEvaluacion findById(Long id);

    public TipoEvaluacion create(TipoEvaluacionRequestDto dto);

    public TipoEvaluacion update(Long id, TipoEvaluacionRequestDto dto);

    public void deleteById(Long id);

    public TipoEvaluacion fromDto(TipoEvaluacionRequestDto dto);
}

 
