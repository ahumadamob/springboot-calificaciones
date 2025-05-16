package com.imb2025.calificaciones.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.entities.Evaluacion;
import com.imb2025.calificaciones.repositories.EvaluacionRepository;

import java.util.List;

@Service
public class EvaluacionServiceImp {
	
	@Autowired
	private EvaluacionRepository evaluacionRepository;
	
	public List<Evaluacion> findAll(){
		return evaluacionRepository.findAll();
	}
	
	public Evaluacion findById(int id) {
		return evaluacionRepository.findById(id).orElse(null);
	}
	
	public Evaluacion save(Evaluacion evalucion) {
		return evaluacionRepository.save(evalucion);
	}
	
	public Evaluacion update(int id, Evaluacion evaluacion) {
		evaluacion.setId(id);
		return evaluacionRepository.save(evaluacion);
	
	}
	
	public void deleteById(int id) {
		evaluacionRepository.deleteById(id);
	}
}
