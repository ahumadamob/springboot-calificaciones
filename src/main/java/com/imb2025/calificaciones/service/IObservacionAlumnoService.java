package com.imb2025.calificaciones.service;

import java.util.List;
import java.util.Optional;

import com.imb2025.calificaciones.dto.ObservacionAlumnoRequestDTO;
import com.imb2025.calificaciones.entity.ObservacionAlumno;

 
public interface IObservacionAlumnoService {
	
	Optional<ObservacionAlumno> findById(Long id);
	List<ObservacionAlumno> findAll();
	ObservacionAlumno create(ObservacionAlumno observacionAlumno);
	ObservacionAlumno update(Long id, ObservacionAlumno observacionAlumno) throws Exception;
	void deleteById(Long id);
    ObservacionAlumno fromDTO(ObservacionAlumnoRequestDTO dto);
	
	

}
