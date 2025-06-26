package com.imb2025.calificaciones.service;

import java.util.List;

import com.imb2025.calificaciones.entity.RegistroClase;

public interface IRegistroClaseService {
	


	List<RegistroClase> obtenerTodosLosRegistros();

	RegistroClase obtenerRegistro(Long id);

	void registrarClase(RegistroClase registro);

	

	void eliminarRegistro(Long id);
}
