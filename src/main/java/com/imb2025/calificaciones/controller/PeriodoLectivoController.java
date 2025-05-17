package com.imb2025.calificaciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imb2025.calificaciones.entity.PeriodoLectivo;
import com.imb2025.calificaciones.service.IPeriodoLectivoService;

@RestController
@RequestMapping("api/periodo-lectivo")
public class PeriodoLectivoController {
	
	@Autowired
	private IPeriodoLectivoService service;
	
	@GetMapping
	public ResponseEntity<List<PeriodoLectivo>> getAll() {
		List<PeriodoLectivo> periodos = service.findAll();
		return ResponseEntity.ok(periodos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PeriodoLectivo> getById(@PathVariable Long id) {
		PeriodoLectivo periodoLectivo = service.findById(id);
		return ResponseEntity.ok(periodoLectivo);
	}
	
	@PostMapping
	public ResponseEntity<PeriodoLectivo> create(@RequestBody PeriodoLectivo periodoLectivo) {
		PeriodoLectivo createdPeriodoLectivo = service.save(periodoLectivo);
		return ResponseEntity.ok(createdPeriodoLectivo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PeriodoLectivo> update(@PathVariable Long id, 
			@RequestBody PeriodoLectivo periodoLectivo) {
		PeriodoLectivo updatedPeriodoLectivo = service.update(id, periodoLectivo);
		return ResponseEntity.ok(updatedPeriodoLectivo);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
