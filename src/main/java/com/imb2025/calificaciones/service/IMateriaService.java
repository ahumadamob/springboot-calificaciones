package com.imb2025.calificaciones.service;

import java.util.List;

import com.imb2025.calificaciones.entity.Materia;



public interface IMateriaService {

	public List<Materia> findAll();

	public Materia findById(Long id);

	public Materia save(Materia materia);

	public void deleteById(long id);

}