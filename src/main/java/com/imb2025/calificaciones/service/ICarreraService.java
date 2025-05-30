package com.imb2025.calificaciones.service;

import java.util.List;

import com.imb2025.calificaciones.entity.Carrera;

public interface ICarreraService {

	public List<Carrera>findAll();
	public Carrera findById(Long Id);
	public Carrera save (Carrera carrera);
	public void deleteById(Long id);

}
