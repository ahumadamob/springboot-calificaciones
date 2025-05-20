package com.imb2025.calificaciones.service;

import java.util.List;

import com.imb2025.calificaciones.entity.Evaluacion;

public interface IEvaluacionService {

	List<Evaluacion> findAll(); //Todos las evaluaciones GET ALL
	Evaluacion findById(int id); //Encontrar una Evaluacion por id GET ID
	Evaluacion save(Evaluacion evaluacion); //Crear y guardar Evaluacion POST
	Evaluacion update(int id, Evaluacion evaluacion); //Actualizar Evaluacion PUT
	void deleteById(int id);  //Eliminar Evaluacion
	
}
