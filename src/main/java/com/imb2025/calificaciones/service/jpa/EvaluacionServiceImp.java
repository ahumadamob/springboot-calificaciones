package com.imb2025.calificaciones.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.entity.Evaluacion;
import com.imb2025.calificaciones.repository.EvaluacionRepository;
import com.imb2025.calificaciones.service.IEvaluacionService;

import java.util.List;

@Service
public class EvaluacionServiceImp implements IEvaluacionService{
	
	@Autowired
	private EvaluacionRepository evaluacionRepository;
	
	@Override
	public List<Evaluacion> findAll(){
		return evaluacionRepository.findAll();
	}
	
	@Override
	public Evaluacion findById(int id) {
		return evaluacionRepository.findById(id).orElse(null);
	}
	
	@Override
	public Evaluacion save(Evaluacion evalucion) {
		return evaluacionRepository.save(evalucion);
	}
	
	@Override
	public Evaluacion update(int id, Evaluacion evaluacion) {
		evaluacion.setId(id);
		return evaluacionRepository.save(evaluacion);
	
	}
	
	@Override
	public void deleteById(int id) {
		evaluacionRepository.deleteById(id);
	}
}
