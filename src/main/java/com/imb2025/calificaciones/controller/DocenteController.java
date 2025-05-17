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

import com.imb2025.calificaciones.entity.Docente;
import com.imb2025.calificaciones.service.IDocenteService;



@RestController
public class DocenteController {
	
	@Autowired
	private IDocenteService docenteService ;
	
	
	@GetMapping("/api/docente")
	public List<Docente>getAllDocente(){
		return docenteService.findAll();
		
		
	}
	
	
	@GetMapping("/api/docente/{idalumno}")
	public Docente getDocenteById(@PathVariable("idalumno") Long id){
		return docenteService.findById(null);
		
	}
	
	@PostMapping("/api/docente")
	
	public Docente createDocente(@RequestBody Docente docente){
		return docenteService.save(docente);
		
	}
	
	@PutMapping("/api/docente")
	public Docente updateDocente(@RequestBody Docente docente){
		return docenteService.save(docente);
		
	}
	
	@DeleteMapping("/api/docente/{idalumno}")
	public void deleteDocente(@PathVariable("idalumno") Long id){
		docenteService.deleteById(id);
		
	}

}
