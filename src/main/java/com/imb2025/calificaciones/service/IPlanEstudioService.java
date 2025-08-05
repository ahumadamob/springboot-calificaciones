package com.imb2025.calificaciones.service;

import java.util.List;
import java.util.Optional;

import com.imb2025.calificaciones.dto.EvaluacionRequestDto;
import com.imb2025.calificaciones.dto.PlanEstudioRequestDto;
import com.imb2025.calificaciones.entity.Evaluacion;
import com.imb2025.calificaciones.entity.PlanEstudio;

public interface IPlanEstudioService {
	
	List<PlanEstudio> findAll(); // Todos las evaluaciones GET ALL

	PlanEstudio findById(Long id); // Encontrar una Evaluacion por id GET ID

	PlanEstudio save(PlanEstudio planestudio); // Crear y guardar Evaluacion POST

	PlanEstudio update(Long id, PlanEstudio planestudio); // Actualizar Evaluacion PUT

	void deleteById(Long id); // Eliminar Evaluacion

	PlanEstudio convertToEntity(PlanEstudioRequestDto planestudioRequestDTO); // Convertir DTO a entidad
}



