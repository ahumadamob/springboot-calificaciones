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

import com.imb2025.calificaciones.entity.NivelMateria;
import com.imb2025.calificaciones.service.INivelMateriaService;

@RestController
public class NivelMateriaController {
	@Autowired
	private INivelMateriaService nivelmateriaService;
	
	@GetMapping("/api/nivelmateria")
	public List<NivelMateria>getAllNivelMateria(){
		
		return nivelmateriaService.findAll();	
	}
	
	@GetMapping("/api/nivelmateria/{id}")
	public NivelMateria getNivelMateriaById(@PathVariable("id") Long id) {
	    return nivelmateriaService.finById(id);
	}
	@PostMapping("/api/nivelmateria")
	public NivelMateria createNivelMateria(@RequestBody NivelMateria nivelmateria){
		return nivelmateriaService.save(nivelmateria);
		
	}
	
	@PutMapping ("/api/nivelmateria")
	public NivelMateria updateNivelMateria(@RequestBody NivelMateria nivelmateria){
		return nivelmateriaService.save(nivelmateria);
		
	}
	@DeleteMapping("/api/materia/{id}")
	public void deleteMateria(@PathVariable("id") Long id) {
	    nivelmateriaService.deleteById(id);
	}
}

	
	
	
	
	
	

