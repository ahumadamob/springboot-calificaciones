package com.imb2025.calificaciones.service;

import java.util.List;

import com.imb2025.calificaciones.dto.MateriaRequestDTO;
import com.imb2025.calificaciones.entity.Materia;



public interface IMateriaService {

	public List<Materia> findAll();

	public Materia findById(Long id);

	public Materia create(Materia materia);

	public void deleteById(long id);
	
	public Materia update(Materia materia, Long id) throws Exception;
	public Materia mapFromDto(MateriaRequestDTO materiaRequestDto) throws Exception;

}