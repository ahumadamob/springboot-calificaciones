package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.PlanEstudioRequestDto;
import com.imb2025.calificaciones.entity.PlanEstudio;
import com.imb2025.calificaciones.exception.ResourceNotFoundException;

import java.util.List;

public interface IPlanEstudioService {

    List<PlanEstudio> findAll();

    PlanEstudio create(PlanEstudio planEstudio);

    PlanEstudio update(PlanEstudio planEstudio, Long id) throws ResourceNotFoundException, Exception;

    PlanEstudio findById(Long id) throws ResourceNotFoundException;

    boolean existsById(Long id);

    void deleteById(Long id) throws ResourceNotFoundException;

    PlanEstudio fromDto(PlanEstudioRequestDto dto) throws Exception;
}

