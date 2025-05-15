package com.imb2025.calificaciones.controller;

import java.util.List;
import java.util.Optional;

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

import com.imb2025.calificaciones.entity.ObservacionAlumno;
import com.imb2025.calificaciones.service.ObservacionAlumnoService;

@RestController
@RequestMapping("/api/v1/observacionAlumno")
public class ObservacionAlumnoController {
	
	@Autowired
	private ObservacionAlumnoService observacionAlumnoService;
	
	@GetMapping
	public ResponseEntity<List<ObservacionAlumno>> getAll(){
		List<ObservacionAlumno> lista = observacionAlumnoService.findAll();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<ObservacionAlumno>> getById(@PathVariable Long id) {
		Optional<ObservacionAlumno> observacionAlumno = observacionAlumnoService.findById(id);
		return ResponseEntity.ok(observacionAlumno);
	}
	
	@PostMapping
	public ResponseEntity<ObservacionAlumno> save(@RequestBody ObservacionAlumno nueva) {
		ObservacionAlumno observacionAlumno = observacionAlumnoService.save(nueva);
		return new ResponseEntity<>(observacionAlumno, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ObservacionAlumno> update(@RequestBody ObservacionAlumno editar, @PathVariable Long id) {
		ObservacionAlumno observacionAlumno = observacionAlumnoService.update(id, editar);
		return ResponseEntity.ok(observacionAlumno);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		observacionAlumnoService.deleteById(id);
		return ResponseEntity.ok("observación elminada correctamente");
		
	}

}
