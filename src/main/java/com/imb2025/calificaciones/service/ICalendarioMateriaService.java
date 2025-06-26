package com.imb2025.calificaciones.service;

import java.util.List;

import com.imb2025.calificaciones.entity.CalendarioMateria;

public interface ICalendarioMateriaService {
	
	List<CalendarioMateria> findAll();
	CalendarioMateria findByID(Long id);
	CalendarioMateria save(CalendarioMateria calendarioMateria);
	CalendarioMateria update(Long id, CalendarioMateria calendarioMateria);
	void delete(Long id);
	
}
