package com.imb2025.calificaciones.service;

import java.util.List;

import com.imb2025.calificaciones.dto.JugadorRequestDTO;
import com.imb2025.calificaciones.entity.Jugador;

public interface IJugadorService {
	 public List<Jugador> findAll();
	 public Jugador findById(Long id); 
	 public Jugador create(Jugador jugador);
	 public Jugador update(Jugador jugador, Long id) throws Exception;
	 public void deleteById(Long id);
	 public Jugador mapFromDto(JugadorRequestDTO jugadorRequestDto)throws Exception;
}
