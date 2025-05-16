package com.imb2025.calificaciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.imb2025.calificaciones.entity.Jugador;
import com.imb2025.calificaciones.service.IJugadorService;

@RestController
public class JugadorController {
	
	@Autowired
	private IJugadorService jugadorService;
	
	@GetMapping("/api/jugador")
	public List<Jugador>getAllJugadores(){
		return jugadorService.findAll();
	}
	
	@GetMapping("/api/jugador/{idalumno}")
	public Jugador getJugadorById(@PathVariable("idalumno") Long id){
		return jugadorService.findById(id);
	}
	
	@PostMapping("/api/jugador")
	public Jugador createJugador(@RequestBody Jugador jugador){
		return jugadorService.save(jugador);
	}
	
	@PutMapping("/api/jugador")
	public Jugador updateJugador(@RequestBody Jugador jugador){
		return jugadorService.save(jugador);
	}
	
	@DeleteMapping("/api/jugador/{idalumno}")
	public void deleteJugador(@PathVariable("idalumno") Long id){
		jugadorService.deleteById(id);
		
	}

}
