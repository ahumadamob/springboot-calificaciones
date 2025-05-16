package com.imb2025.calificaciones.Services;

import java.util.List;

import com.imb2025.calificaciones.Entity.RegistroClase;

public interface IRegistroClaseService {
	


	List<RegistroClase> obtenerTodosLosRegistros();

	RegistroClase obtenerRegistro(Long id);

	void registrarClase(RegistroClase registro);

	

	void eliminarRegistro(Long id);
}
