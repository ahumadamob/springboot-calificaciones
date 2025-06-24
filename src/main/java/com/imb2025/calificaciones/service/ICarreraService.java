package com.imb2025.calificaciones.service;

import java.util.List;

import com.imb2025.calificaciones.dto.CarreraRequestDTO;
import com.imb2025.calificaciones.entity.Carrera;

public interface ICarreraService {

	public List<Carrera>findAll();
	public Carrera findById(Long Id);
	public Carrera create(Carrera jugador);
	public void deleteById(Long id);
	public Carrera mapFromDto(CarreraRequestDTO jugadorRequestDto)throws Exception;
	public Carrera update(Carrera jugador, Long id) throws Exception;

}
