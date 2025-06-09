package com.imb2025.calificaciones.service;

import java.util.List;
import java.util.Optional;

import com.imb2025.calificaciones.dto.ObservacionAlumnoRequestDTO;
import com.imb2025.calificaciones.entity.ObservacionAlumno;

 
public interface IObservacionAlumnoService {
	
	Optional<ObservacionAlumno> findById(Long id);
	List<ObservacionAlumno> findAll();
	ObservacionAlumno save(ObservacionAlumnoRequestDTO dto);
	ObservacionAlumno update(Long id, ObservacionAlumnoRequestDTO dto);
	void deleteById(Long id);
	
	

}
