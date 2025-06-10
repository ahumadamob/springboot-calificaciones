package com.imb2025.calificaciones.service;

import java.util.List;

import com.imb2025.calificaciones.dto.CalendarioMateriaRequestDTO;
import com.imb2025.calificaciones.entity.CalendarioMateria;

public interface ICalendarioMateriaService {
	
	List<CalendarioMateria> findAll();
	CalendarioMateria findByID(Long id);
	CalendarioMateria save(CalendarioMateriaRequestDTO calendarioMateriaDto);
	CalendarioMateria update(Long id, CalendarioMateriaRequestDTO calendarioMateriaDto);
	void delete(Long id);
	
}
