package com.imb2025.calificaciones.service;

import java.util.List;
import java.util.Optional;

import com.imb2025.calificaciones.entity.PlanEstudio;

public interface IPlanEstudioService {
	
	List<PlanEstudio> findAll();
    Optional<PlanEstudio> findById(Long id);
    PlanEstudio save(PlanEstudio planEstudio);
    PlanEstudio update(Long id, PlanEstudio planEstudio);
    void deleteById(Long id);
	Optional<PlanEstudio> findById(int id);
}


