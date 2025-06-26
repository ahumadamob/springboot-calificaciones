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
import org.springframework.web.server.ResponseStatusException;

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
		return ResponseEntity.ok(periodos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PeriodoLectivo> getById(@PathVariable Long id) {
		PeriodoLectivo periodoLectivo = service.findById(id);
		return ResponseEntity.ok(periodoLectivo);
	}
	
	@PostMapping
	public ResponseEntity<PeriodoLectivo> create(@RequestBody PeriodoLectivoRequestDTO periodoLectivo) {
		PeriodoLectivo createdPeriodoLectivo = service.save(
					service.RequestDTOToEntity(periodoLectivo)
				);
		return ResponseEntity.ok(createdPeriodoLectivo);
	}
	
	/**
	 * Se utiliza la excepcion {@code ResponseStatusException} para mostrar el error que tira {@code NullPointerException} cuando no haya una entidad ya existente con el id introducido.
	 */
	@PutMapping("/{id}")
	public ResponseEntity<PeriodoLectivo> update(@PathVariable Long id, 
			@RequestBody PeriodoLectivoRequestDTO periodoLectivo) {
		PeriodoLectivo updatedPeriodoLectivo;
		try {			
			updatedPeriodoLectivo = service.update(
					id, 
					service.RequestDTOToEntity(periodoLectivo)
					);
		} catch (NullPointerException e) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, 
					"No hay Periodo Lectivo con el id : " + Long.toString(id)
					);
		}
		return ResponseEntity.ok(updatedPeriodoLectivo);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
