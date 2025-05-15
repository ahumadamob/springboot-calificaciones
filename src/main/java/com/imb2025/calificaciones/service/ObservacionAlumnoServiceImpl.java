package com.imb2025.calificaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.entity.ObservacionAlumno;
import com.imb2025.calificaciones.repository.ObservacionAlumnoRepository;

@Service
public class ObservacionAlumnoServiceImpl implements ObservacionAlumnoService{
	
	@Autowired
	private ObservacionAlumnoRepository observacionAlumnoRepository;

	@Override
	public Optional<ObservacionAlumno> findById(Long id) {
		// TODO Auto-generated method stub
		return observacionAlumnoRepository.findById(id);
	}

	@Override
	public List<ObservacionAlumno> findAll() {
		// TODO Auto-generated method stub
		return observacionAlumnoRepository.findAll();
	}

	@Override
	public ObservacionAlumno save(ObservacionAlumno observacionAlumno) {
		// TODO Auto-generated method stub
		return observacionAlumnoRepository.save(observacionAlumno);
	}

	@Override
	public ObservacionAlumno update(Long id, ObservacionAlumno observacionAlumno) {
		observacionAlumno.setId(id);
		return observacionAlumnoRepository.save(observacionAlumno);
	}

	@Override
	public void deleteById(Long id) {
		observacionAlumnoRepository.deleteById(id);
		
	}

}
