package com.imb2025.calificaciones.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.imb2025.calificaciones.entities.Evaluacion;
import com.imb2025.calificaciones.services.EvaluacionServiceImp;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;

@RestController
@RequestMapping("api/v1/evaluacion")
public class EvaluacionController {
	
	@Autowired
	private EvaluacionServiceImp evaluacionServiceImp;
	
	 
	@GetMapping
	public ResponseEntity<List<Evaluacion>> getAll(){
		List<Evaluacion> evaluaciones = evaluacionServiceImp.findAll();
		return ResponseEntity.ok(evaluaciones);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Evaluacion> gitById(@PathVariable int id){
		Evaluacion evaluacion=evaluacionServiceImp.findById(id);
		return ResponseEntity.ok(evaluacion);
		
	}
	
	@PostMapping
	public ResponseEntity<Evaluacion> create(@RequestBody Evaluacion evaluacion){
		Evaluacion eva=evaluacionServiceImp.save(evaluacion);
		return ResponseEntity.ok(eva);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Evaluacion> update(@PathVariable int id, @RequestBody Evaluacion newEvaluacion){
		try {
			Evaluacion evaluacion=evaluacionServiceImp.update(id, newEvaluacion);
			return ResponseEntity.ok(evaluacion);
			
		}catch (EntityNotFoundException entityNotFound) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable int id) {
		try {
			evaluacionServiceImp.deleteById(id);
			return ResponseEntity.noContent().build();
		}catch (EntityNotFoundException entityNotFound){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
	}
	
	
	

}
