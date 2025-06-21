package com.imb2025.calificaciones.controller;

import com.imb2025.calificaciones.dto.EvaluacionRequestDTO;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.apache.coyote.Response;
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

import com.imb2025.calificaciones.entity.Evaluacion;
import com.imb2025.calificaciones.service.jpa.EvaluacionServiceImp;

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
	public ResponseEntity<Evaluacion> gitById(@PathVariable Long id){
		Evaluacion evaluacion=evaluacionServiceImp.findById(id);
		return ResponseEntity.ok(evaluacion);

	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody EvaluacionRequestDTO evaluacionRequestDTO){
		try {
			Evaluacion evaluacion=evaluacionServiceImp.save(evaluacionRequestDTO);
			return ResponseEntity.status(HttpStatus.CREATED).body(evaluacion);
		}catch (RuntimeException e){
			Map<String, Object> message=new HashMap<>();
			message.put("mensaje",e.getMessage());
			message.put("error", "Bad request");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id,
			@RequestBody EvaluacionRequestDTO newEvaluacionDTO){
		try {
			Evaluacion evaluacion=evaluacionServiceImp.update(id, newEvaluacionDTO);
			return ResponseEntity.status(HttpStatus.OK).body(evaluacion);
		}catch (RuntimeException e) {
			Map<String, Object> message=new HashMap<>();
			message.put("mensaje",e.getMessage());
			message.put("error", "Bad request");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
		}
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		try {
			evaluacionServiceImp.deleteById(id);
			return ResponseEntity.noContent().build();
		}catch (EntityNotFoundException entityNotFound){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
	}
	
	
	

}
