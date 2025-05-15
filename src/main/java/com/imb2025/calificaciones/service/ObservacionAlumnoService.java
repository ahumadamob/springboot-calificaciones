package com.imb2025.calificaciones.service;

import java.util.List;
import java.util.Optional;

import com.imb2025.calificaciones.entity.ObservacionAlumno;

 
public interface ObservacionAlumnoService {
	
	Optional<ObservacionAlumno> findById(Long id);
	List<ObservacionAlumno> findAll();
	ObservacionAlumno save(ObservacionAlumno observacionAlumno);
	ObservacionAlumno update(Long id, ObservacionAlumno observacionAlumno);
	void deleteById(Long id);
	
	

}
