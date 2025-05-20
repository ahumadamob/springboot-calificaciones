package com.imb2025.calificaciones.service;

import java.util.List;
import com.imb2025.calificaciones.entity.Turno;

public interface TurnoService {
	
	List<Turno> findAll();
	
	Turno findById(Long id);
	
	Turno save(Turno turno);
	
	Turno update(Long id, Turno turno);
	
	void deleteById(Long id);
	

}
