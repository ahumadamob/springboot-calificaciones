package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.TipoEvaluacionRequestDto;
import com.imb2025.calificaciones.entity.TipoEvaluacion;
import java.util.List;

public interface ITipoEvaluacionService {

    public List<TipoEvaluacion> findAll();

    public TipoEvaluacion create(TipoEvaluacion tipoEvaluacion);

    public TipoEvaluacion update(TipoEvaluacion tipoEvaluacion, Long id);

    public TipoEvaluacion findById(Long id);

    public void deleteById(Long id);

    public TipoEvaluacion fromDto(TipoEvaluacionRequestDto dto);
}
