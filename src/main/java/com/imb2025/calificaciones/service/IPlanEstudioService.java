package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.request.PlanEstudioRequestDto;
import com.imb2025.calificaciones.entity.PlanEstudio;
import com.imb2025.calificaciones.exception.ResourceNotFoundException;


import java.util.List;

public interface IPlanEstudioService {

    List<PlanEstudio> findAll();

    PlanEstudio create(PlanEstudio planEstudio);

    PlanEstudio update(PlanEstudio planEstudio, Long id) throws ResourceNotFoundException, Exception;

    PlanEstudio findById(Long id) throws ResourceNotFoundException;

    void deleteById(Long id) throws ResourceNotFoundException;
    
    public List<PlanEstudio> findAllByNombre(String nombre);
    
    public long countByCarrera(Long carreraId);
    
    PlanEstudio fromDto(PlanEstudioRequestDto dto);

    
    
}

