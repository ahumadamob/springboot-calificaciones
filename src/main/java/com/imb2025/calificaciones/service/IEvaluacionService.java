package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.EvaluacionRequestDto;
import java.util.List;

import com.imb2025.calificaciones.entity.Evaluacion;

public interface IEvaluacionService {

	List<Evaluacion> findAll(); // Todos las evaluaciones GET ALL

	Evaluacion findById(Long id); // Encontrar una Evaluacion por id GET ID

	Evaluacion save(Evaluacion evaluacion); // Crear y guardar Evaluacion POST

	Evaluacion update(Long id, Evaluacion evaluacion); // Actualizar Evaluacion PUT

	void deleteById(Long id); // Eliminar Evaluacion

	Evaluacion convertToEntity(EvaluacionRequestDto evaluacionRequestDTO); // Convertir DTO a entidad
}
