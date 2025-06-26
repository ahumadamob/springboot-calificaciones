package com.imb2025.calificaciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imb2025.calificaciones.entity.CalendarioMateria;
import com.imb2025.calificaciones.service.ICalendarioMateriaService;

@RestController
@RequestMapping("/api/calendario-materia")
public class CalendarioMateriaController {

	@Autowired
	private ICalendarioMateriaService calMatSer;
	
	
	@GetMapping
	public ResponseEntity<List<CalendarioMateria>> getAll (){
		List<CalendarioMateria> getAllCalMat = calMatSer.findAll();
		return ResponseEntity.ok(getAllCalMat);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CalendarioMateria> getById(@PathVariable Long id){
		CalendarioMateria getCalMat = calMatSer.findByID(id);
		return ResponseEntity.ok(getCalMat);
	}
	
	@PostMapping
	public ResponseEntity<CalendarioMateria> create(@RequestBody CalendarioMateria calendarioMateria){		
		CalendarioMateria createCalMat = calMatSer.save(calendarioMateria);
		return ResponseEntity.status(HttpStatus.CREATED).body(createCalMat);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CalendarioMateria> update(@PathVariable Long id, @RequestBody CalendarioMateria calendarioMateria){
		
		CalendarioMateria updateCalMat = calMatSer.update(id, calendarioMateria);
		
		return ResponseEntity.ok(updateCalMat);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		calMatSer.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
}






