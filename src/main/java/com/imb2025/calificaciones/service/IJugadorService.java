package com.imb2025.calificaciones.service;

import java.util.List;

import com.imb2025.calificaciones.entity.Jugador;

public interface IJugadorService {
	 public List<Jugador> findAll();
	 public Jugador findById(Long id); 
	 public Jugador save(Jugador jugador);
	 public void deleteById(Long id);
}
