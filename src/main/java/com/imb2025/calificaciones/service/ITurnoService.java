package com.imb2025.calificaciones.service;

import java.util.List;

import com.imb2025.calificaciones.dto.TurnoRequestDTO;
import com.imb2025.calificaciones.entity.Turno;

public interface ITurnoService {
	
	List<Turno> findAll();
	
	Turno findById(Long id);
	
	Turno create(Turno turno);
	
	Turno update (Long id, Turno turno) throws Exception;
	
	void deleteById(Long id) throws Exception;
	
	public Turno mapFromDTO(TurnoRequestDTO turnoRequestDTO);

	boolean existsById(Long id); 	
	

}
