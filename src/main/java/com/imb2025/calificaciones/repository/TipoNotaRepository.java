package com.imb2025.calificaciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imb2025.calificaciones.entity.TipoNota;

public interface TipoNotaRepository extends JpaRepository<TipoNota, Long> {
	
	public List<TipoNota>findByOrderByNombreAscDescripcion();
	public long countByNombre(String nombre);
	
}

