package com.imb2025.calificaciones.service;

import java.util.List;
import java.util.Optional;

import com.imb2025.calificaciones.entity.TipoNota;

public interface ITipoNotaService {

	List<TipoNota> findAll();		//Devuelve una lista con todas las entidades TipoNota.
	
	TipoNota findById(Long id);		//Busca un TipoNota por su ID.
	
	TipoNota save(TipoNota tipoNota);		//Guarda una nueva entidad.

    TipoNota update(Long id, TipoNota tipoNota);		//Actualiza una entidad existente(por eso recibe el ID).

    void deleteById(Long id);		//Elimina la entidad con ese ID.
}
