package com.imb2025.calificaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imb2025.calificaciones.entity.PlanEstudio;

import java.util.List;

public interface PlanEstudioRepository extends JpaRepository<PlanEstudio, Long> {
	
	List<PlanEstudio> findByNombreContainingIgnoreCase(String nombre);
    long countByCarrera_Id(Long carreraId);
    
    List<PlanEstudio> findByActivoTrue();
    List<PlanEstudio> findByActivoFalse();
}

