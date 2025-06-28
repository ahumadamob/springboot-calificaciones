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

import com.imb2025.calificaciones.dto.MateriaRequestDTO;
import com.imb2025.calificaciones.entity.Materia;
import com.imb2025.calificaciones.service.IMateriaService;





@RestController
public class MateriaController {
	
	@Autowired
	private IMateriaService materiaService;
	
	@GetMapping("/api/materia")
	public List<Materia>getAllMateria(){
		
		return materiaService.findAll();
		
	}
	
	@GetMapping("/api/materia/{id}")
	public Materia getMateriaById(@PathVariable("idalumno") Long id) {
	    return materiaService.findById(id);
	}

	
	@PostMapping("/api/materia")
	public Materia createMateria(@RequestBody MateriaRequestDTO materiaRequestDto){
		Materia materia = new Materia();
		try {
			materia = materiaService.mapFromDto(materiaRequestDto);
			materia = materiaService.create(materia);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return materia;
		
	}
	
	@PutMapping ("/api/materia/{id}")
	public Materia updateMateria(@RequestBody MateriaRequestDTO materiaRequestDto, @PathVariable("id") Long id){
		Materia materia = new Materia();
		try {
			materia = materiaService.mapFromDto(materiaRequestDto);
			materia = materiaService.update(materia,id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return materia;
	}
	@DeleteMapping("/api/materia/{idalumno}")
	public void deleteMateria(@PathVariable("idalumno") Long id) {
	    materiaService.deleteById(id); 

	
	}
}