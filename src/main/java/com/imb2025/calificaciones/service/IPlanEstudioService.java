package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.PlanEstudioRequestDto;
import com.imb2025.calificaciones.entity.PlanEstudio;
import java.util.List;

public interface IPlanEstudioService {

    public List<PlanEstudio> findAll();

    public PlanEstudio create(PlanEstudio planEstudio);

    public PlanEstudio update(PlanEstudio planEstudio, Long id) throws Exception;

    public PlanEstudio findById(Long id);

    public void deleteById(Long id);

    public PlanEstudio fromDto(PlanEstudioRequestDto dto) throws Exception;
}
