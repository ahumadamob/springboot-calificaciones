package com.imb2025.calificaciones.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.imb2025.calificaciones.dto.JugadorRequestDTO;
import com.imb2025.calificaciones.dto.ResponseDTO;
import com.imb2025.calificaciones.entity.Jugador;
import com.imb2025.calificaciones.service.IJugadorService;

@RestController
public class JugadorController {
	
	@Autowired
	private IJugadorService jugadorService;
	
	@GetMapping("/api/jugador")
	public ResponseDTO<List<Jugador>> getAllJugadores(){
		ResponseDTO res = new ResponseDTO();
		res.setStatusCode(200);
		res.setMessage("Listados de jugadores");
		res.setData(jugadorService.findAll());
		res.setDate(LocalDateTime.now());
		return res;
	}
	
	@GetMapping("/api/jugador/{idjugador}")
	public Jugador getJugadorById(@PathVariable("idjugador") Long id){
		return jugadorService.findById(id);
	}
	
	@PostMapping("/api/jugador")
	public Jugador createJugador(@RequestBody JugadorRequestDTO jugadorRequestDto){
		Jugador jugador = new Jugador();
		try {
			jugador = jugadorService.mapFromDto(jugadorRequestDto);
			jugador = jugadorService.create(jugador);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jugador;
	}
	
	@PutMapping("/api/jugador/{idjugador}")
	public Jugador updateJugador(@RequestBody JugadorRequestDTO jugadorRequestDto, @PathVariable("idjugador") Long id){
		Jugador jugador = new Jugador();
		try {
			jugador = jugadorService.mapFromDto(jugadorRequestDto);
			jugador = jugadorService.update(jugador, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jugador;
	}
	
	@DeleteMapping("/api/jugador/{idjugador}")
	public void deleteJugador(@PathVariable("idjugador") Long id){
		jugadorService.deleteById(id);
		
	}

}
