package com.imb2025.calificaciones.service;

import java.util.List;

import com.imb2025.calificaciones.dto.DocenteRequestDTO;
import com.imb2025.calificaciones.entity.Docente;

public interface IDocenteService {
	
			public List<Docente>findAll();
	
			public Docente findById(Long id);
	
			
	
			public void deleteById(Long id);

			public Docente mapFromDTO(DocenteRequestDTO docenteDTO);

			public Docente create(Docente docente);

			public Docente update(Long id, Docente docente) throws Exception;

}
