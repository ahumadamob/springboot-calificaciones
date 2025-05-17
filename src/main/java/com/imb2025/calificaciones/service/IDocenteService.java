package com.imb2025.calificaciones.service;

import java.util.List;

import com.imb2025.calificaciones.entity.Docente;

public interface IDocenteService {
	
			public List<Docente>findAll();
	
			public Docente findById(Long id);
	
			public Docente save(Docente  docente);
	
			public void deleteById(Long id);

}
