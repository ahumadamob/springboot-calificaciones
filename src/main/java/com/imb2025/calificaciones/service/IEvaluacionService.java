package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.EvaluacionRequestDto;
import com.imb2025.calificaciones.entity.Evaluacion;
import java.util.List;

public interface IEvaluacionService {

    public List<Evaluacion> findAll();

    public Evaluacion findById(Long id);

    public Evaluacion create(EvaluacionRequestDto dto);

    public Evaluacion update(Long id, EvaluacionRequestDto dto);

    public void deleteById(Long id);

    public Evaluacion fromDto(EvaluacionRequestDto dto);
}

