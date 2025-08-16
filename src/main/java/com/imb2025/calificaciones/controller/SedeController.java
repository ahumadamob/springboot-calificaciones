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

import com.imb2025.calificaciones.entity.Sede;
import com.imb2025.calificaciones.service.ISedeService;

/*Al anotarlo con @Rest va a poder interpretar que es un SERVICIO REST e interpretar que vengan
 * los objetos del tipo .json y asi nosotros poder serializarlos como otra cosa ya que aca no podemos 
 * utilizar .json, debemos utilizar objetos. */


@RestController //Aca vamos a realizar los métodos que van a representar un ENDPOINT
public class SedeController {

	@Autowired  
	private ISedeService sedeService;
	
	@GetMapping("/api/sede")
	public List<Sede>getAllSedes(){
		return sedeService.findAll();
	}
	
	@GetMapping("/api/sede/{idSede}")
	public Sede getSedeById(@PathVariable("idSede") Long id){
		return sedeService.findById(id);
	}
	
	@PostMapping("/api/sede")
	public Sede createSede(@RequestBody Sede sede){
		return sedeService.save(sede);
	}
	
	@PutMapping("/api/sede")
	public Sede updateSede(@RequestBody Sede sede){
		return sedeService.save(sede);
	}
	
	@DeleteMapping("/api/sede/{idSede}")
	public void deleteSede(@PathVariable("idSede") Long id){
		sedeService.deletedById(id);
	}
	
}
