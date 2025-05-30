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

import com.imb2025.calificaciones.entity.Cursada;
import com.imb2025.calificaciones.service.ICursadaService;

@RestController
public class CursadaController {

	@Autowired
	private ICursadaService cursadaService;
	
	@GetMapping("/api/cursada")
	public List<Cursada>getAllCursada() {
		return cursadaService.findAll();
		
	}
	
	@GetMapping("/api/cursada/{idalumno}")
	public Cursada getCursadaById(@PathVariable("idalumno") Long id){
		return cursadaService.findById(id);
	}
	
	@PostMapping("/api/cursada")
	public Cursada createCursada(@RequestBody Cursada cursada){
		return cursadaService.save(cursada);
	}
	
	@PutMapping("/api/cursada")
	public Cursada updateCursada(@RequestBody Cursada cursada){
		return cursadaService.save(cursada);
		
	}
	
	@DeleteMapping("/api/cursada/{idalumno}")
	public void deleteCursada(@PathVariable("idalumno") Long id){
		cursadaService.deleteById(id);
		
	}
	
}
