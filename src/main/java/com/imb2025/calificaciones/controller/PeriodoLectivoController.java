package com.imb2025.calificaciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imb2025.calificaciones.dto.PeriodoLectivoRequestDTO;
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
		return !periodos.isEmpty()? 
				ResponseEntity.ok(periodos) : 
					ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PeriodoLectivo> getById(@PathVariable Long id) {
		PeriodoLectivo periodoLectivo = service.findById(id);
		return service.existsById(id)? 
				ResponseEntity.ok(periodoLectivo) : 
					ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<PeriodoLectivo> create(@RequestBody PeriodoLectivoRequestDTO periodoLectivo) {
		PeriodoLectivo createdPeriodoLectivo = service.save(
					service.mapFromDTO(periodoLectivo)
				);
		return ResponseEntity.ok(createdPeriodoLectivo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PeriodoLectivo> updateById(@PathVariable Long id, 
			@RequestBody PeriodoLectivoRequestDTO periodoLectivo) throws Exception {
		PeriodoLectivo updatedPeriodoLectivo = service.update(
				id, 
				service.mapFromDTO(periodoLectivo)
				);
		return ResponseEntity.ok(updatedPeriodoLectivo);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) throws Exception {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ex) {
	  return ResponseEntity.badRequest().body(ex.getMessage());
	}
	
}
