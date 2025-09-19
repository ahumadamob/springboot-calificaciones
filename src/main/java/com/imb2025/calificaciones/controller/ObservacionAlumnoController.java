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

import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
import com.imb2025.calificaciones.dto.ObservacionAlumnoRequestDto;
import com.imb2025.calificaciones.entity.ObservacionAlumno;
import com.imb2025.calificaciones.service.IObservacionAlumnoService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/observacionAlumno")
public class ObservacionAlumnoController {
	
	@Autowired
	private IObservacionAlumnoService observacionAlumnoService;
	 
	
	@GetMapping
	public ResponseEntity<ApiResponseSuccessDto<List<ObservacionAlumno>>> getAll(){
		List<ObservacionAlumno> lista = observacionAlumnoService.findAll();
		
		ApiResponseSuccessDto<List<ObservacionAlumno>> response = new ApiResponseSuccessDto<>();
		response.setSuccess(true);
		response.setMessage("Observaciones obtenidas correctamente");
		response.setData(lista);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponseSuccessDto<ObservacionAlumno>> getById(@PathVariable Long id, HttpServletRequest request) {
		
            ObservacionAlumno observacionAlumno = observacionAlumnoService.findById(id);
            ApiResponseSuccessDto<ObservacionAlumno> response = new ApiResponseSuccessDto<>();
            response.setSuccess(true);
            response.setMessage("Observación de alumno encontrada con exito");
            response.setData(observacionAlumno);
			return ResponseEntity.ok(response);
	}
	
	@PostMapping
	public ResponseEntity<ApiResponseSuccessDto<ObservacionAlumno>> create(@RequestBody ObservacionAlumnoRequestDto dto, HttpServletRequest request) throws Exception {
			
            ObservacionAlumno observacionAlumno = observacionAlumnoService.create(observacionAlumnoService.fromDto(dto));
			
            ApiResponseSuccessDto<ObservacionAlumno> response = new ApiResponseSuccessDto<>();
            response.setSuccess(true);
			response.setMessage("Observación creada correctamente");
			response.setData(observacionAlumno);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
			
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ApiResponseSuccessDto<ObservacionAlumno>> update(@RequestBody ObservacionAlumnoRequestDto dto, @PathVariable Long id, HttpServletRequest request) throws Exception {
			
            ObservacionAlumno observacionAlumno = observacionAlumnoService.update(observacionAlumnoService.fromDto(dto), id);		
            ApiResponseSuccessDto<ObservacionAlumno> response = new ApiResponseSuccessDto<>();
            response.setSuccess(true);
			response.setMessage("Observación actualizada correctamente");
			response.setData(observacionAlumno);
			
			return ResponseEntity.ok(response);	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id, HttpServletRequest request) throws Exception {
		
			observacionAlumnoService.deleteById(id);
			
			ApiResponseSuccessDto<String> response = new ApiResponseSuccessDto<>();
			response.setSuccess(true);
			response.setMessage("Observación con ID: " + id + ", eliminada correctamente");
			
			return ResponseEntity.ok(response);
		
	}
}
	
