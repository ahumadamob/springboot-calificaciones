package com.imb2025.calificaciones.service;

import java.util.List;

import com.imb2025.calificaciones.dto.CalendarioMateriaRequestDTO;
import com.imb2025.calificaciones.entity.CalendarioMateria;

public interface ICalendarioMateriaService {
	
	List<CalendarioMateria> findAll();
	CalendarioMateria findByID(Long id);
	CalendarioMateria create(CalendarioMateria calendarioMateria);
	CalendarioMateria update(Long id, CalendarioMateria calendarioMateria) throws Exception;
	void delete(Long id);
	CalendarioMateria mapFromDto(CalendarioMateriaRequestDTO calMatDto)throws Exception;


}
