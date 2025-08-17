package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.EvaluacionRequestDto;
import com.imb2025.calificaciones.entity.Evaluacion;
import java.util.List;

public interface IEvaluacionService {

    public List<Evaluacion> findAll();

    public Evaluacion create(Evaluacion evaluacion);

    public Evaluacion update(Evaluacion evaluacion, Long id) throws Exception;

    public Evaluacion findById(Long id);

    public void deleteById(Long id) throws Exception;

    public Evaluacion fromDto(EvaluacionRequestDto dto) throws Exception;
}
