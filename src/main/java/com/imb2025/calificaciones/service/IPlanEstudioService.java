package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.PlanEstudioRequestDto;
import com.imb2025.calificaciones.entity.PlanEstudio;
import java.util.List;

public interface IPlanEstudioService {

    public List<PlanEstudio> findAll();

    public PlanEstudio findById(Long id);

    public PlanEstudio create(PlanEstudioRequestDto dto);

    public PlanEstudio update(Long id, PlanEstudioRequestDto dto);

    public void deleteById(Long id);

    public PlanEstudio fromDto(PlanEstudioRequestDto dto);
}
