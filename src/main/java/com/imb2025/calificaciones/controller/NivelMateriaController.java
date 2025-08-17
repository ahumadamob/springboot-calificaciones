package com.imb2025.calificaciones.controller;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.imb2025.calificaciones.entity.NivelMateria;
import com.imb2025.calificaciones.service.INivelMateriaService;

@RestController
public class NivelMateriaController {
	
	 @Autowired
	    private INivelMateriaService nivelMateriaService;
	 
	 @GetMapping("/api/nivelmateria")
	 public List<NivelMateria> getAllNivelMateria() {
	        return nivelMateriaService.findAll();
	 }
	 
	 @GetMapping("/api/nivelmateria/{id}")
	 public NivelMateria getNivelMateriaById(@PathVariable("id")Long id) {
	        return nivelMateriaService.findById(id);  
	 }       
         @PostMapping("/api/nivelmateria")
         public NivelMateria createNivelMateria(@RequestBody NivelMateria nivelMateria){
                 return nivelMateriaService.create(nivelMateria);
         }
         @PutMapping("/api/nivelmateria")
         public NivelMateria updateNivelMateria(@RequestBody NivelMateria nivelMateria){
                 return nivelMateriaService.update(nivelMateria, nivelMateria.getId());
         }
	 @DeleteMapping("/api/nivelmateria/{id}")
	 public void deleteNivelMateria(@PathVariable("id")Long id) {
		 nivelMateriaService.deleteById(id);
	 }
}
