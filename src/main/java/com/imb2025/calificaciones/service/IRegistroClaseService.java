package com.imb2025.calificaciones.service;

import java.util.List;

import com.imb2025.calificaciones.dto.RegistroClaseDTO;
import com.imb2025.calificaciones.entity.RegistroClase;

public interface IRegistroClaseService {



	List<RegistroClase> obtenerTodosLosRegistros();

	RegistroClase obtenerRegistro(Long id);

	void registrarClase(RegistroClaseDTO registro);



	void eliminarRegistro(Long id);

	void validarIds(Long id, RegistroClaseDTO registroClaseDTO);
}
