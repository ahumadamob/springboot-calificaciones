package com.imb2025.calificaciones.controller;


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

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.imb2025.calificaciones.dto.ErrorMessage;
import com.imb2025.calificaciones.dto.ErrorResponseDto;
import com.imb2025.calificaciones.dto.ObservacionAlumnoRequestDto;
import com.imb2025.calificaciones.dto.SuccessResponseDto;
import com.imb2025.calificaciones.entity.ObservacionAlumno;
import com.imb2025.calificaciones.service.IObservacionAlumnoService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/observacionAlumno")
public class ObservacionAlumnoController {
	
	@Autowired
	private IObservacionAlumnoService observacionAlumnoService;
	
	@GetMapping
	public ResponseEntity<SuccessResponseDto<List<ObservacionAlumno>>> getAll(){
		List<ObservacionAlumno> lista = observacionAlumnoService.findAll();
		
		SuccessResponseDto<List<ObservacionAlumno>> response = new SuccessResponseDto<>();
		response.setTimestamp(LocalDateTime.now());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("observaciones obtenidas correctamente");
		response.setData(lista);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id, HttpServletRequest request) {
		
		Optional<ObservacionAlumno> observacionAlumno = observacionAlumnoService.findById(id);
		
		if (observacionAlumno.isPresent()) {
			
			SuccessResponseDto<ObservacionAlumno> response = new SuccessResponseDto<>();
			response.setTimestamp(LocalDateTime.now());
			response.setStatus(HttpStatus.OK.value());
			response.setMessage("observación obtenida correctamente por ID");
			response.setData(observacionAlumno.get());
			
			return ResponseEntity.ok(response);
			
		} else {
			
			ErrorResponseDto errorResponse = new ErrorResponseDto();
			errorResponse.setTimestamp(LocalDateTime.now());
			errorResponse.setStatus(HttpStatus.NO_CONTENT.value());
			errorResponse.setError("Not found");
			errorResponse.setMessages(Arrays.asList(
					new ErrorMessage("id", "Observación no encontrada con ID: " + id)
            ));
			errorResponse.setErrorCode("OBSERVACION_NOT_FOUND");
			errorResponse.setPath(request.getRequestURI());
			
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(errorResponse);
		}
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody ObservacionAlumnoRequestDto dto, HttpServletRequest request) {
		try {	
			
			ObservacionAlumno observacionAlumno = observacionAlumnoService.create(observacionAlumnoService.fromDTO(dto));
			
			SuccessResponseDto<ObservacionAlumno> response = new SuccessResponseDto<>();
			response.setTimestamp(LocalDateTime.now());
			response.setStatus(HttpStatus.CREATED.value());
			response.setMessage("observación creada correctamente");
			response.setData(observacionAlumno);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
			
		} catch (Exception e) {
			
			ErrorResponseDto errorResponse = new ErrorResponseDto();
			errorResponse.setTimestamp(LocalDateTime.now());
			errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
			errorResponse.setError("Bad Request");
			
			String errorMessage = e.getMessage();
			String field = "general";
			String errorCode = "CREATION_ERROR";
			
			if (errorMessage.contains("alumno no encontrado")) {
				field = "alumnoId";
				errorCode = "ALUMNO_NOT_FOUND";
			} else if (errorMessage.contains("docente no encontrado")) {
				field = "docenteId";
				errorCode = "DOCENTE_NOT_FOUND";
			}
			
			errorResponse.setMessages(Arrays.asList(
				new ErrorMessage(field, errorMessage)
			));
			errorResponse.setErrorCode(errorCode);
			errorResponse.setPath(request.getRequestURI());
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
			 
		}	
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody ObservacionAlumnoRequestDto dto, @PathVariable Long id, HttpServletRequest request) {
	try {	
			
			ObservacionAlumno observacionAlumno = observacionAlumnoService.update(id, observacionAlumnoService.fromDTO(dto));
			
			SuccessResponseDto<ObservacionAlumno> response = new SuccessResponseDto<>();
			response.setTimestamp(LocalDateTime.now());
			response.setStatus(HttpStatus.OK.value());
			response.setMessage("observación actualizada correctamente");
			response.setData(observacionAlumno);
			
			return ResponseEntity.ok(response);
			
		} catch (Exception e) {
			
			ErrorResponseDto errorResponse = new ErrorResponseDto();
			errorResponse.setTimestamp(LocalDateTime.now());
			errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
			errorResponse.setError("Not found");
			
			String errorMessage = e.getMessage();
			String field = "id";
			String errorCode = "UPDATE_ERROR";
			
			if (errorMessage.contains("la observación de alumno no existe")) {
				errorCode = "OBSERVACION_NOT_FOUND";
			} else if (errorMessage.contains("docente no encontrado")) {
				field = "docenteId";
				errorCode = "DOCENTE_NOT_FOUND";
			} else if (errorMessage.contains("alumno no encontrado")) {
				field = "alumnoId";
				errorCode = "ALUMNO_NOT_FOUND";
			}
			
			errorResponse.setMessages(Arrays.asList(
				new ErrorMessage(field, errorMessage)
			));
			errorResponse.setErrorCode(errorCode);
			errorResponse.setPath(request.getRequestURI());
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
			 
		}	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id, HttpServletRequest request) {
		try {
			observacionAlumnoService.deleteById(id);
			
			SuccessResponseDto<String> response = new SuccessResponseDto<>();
			response.setTimestamp(LocalDateTime.now());
			response.setStatus(HttpStatus.OK.value());
			response.setMessage("Observación eliminada exitosamente");
			response.setData("Observación con ID " + id + " eliminada correctamente");
			
			return ResponseEntity.ok(response);
			
		} catch (Exception e) {
			ErrorResponseDto errorResponse = new ErrorResponseDto();
			errorResponse.setTimestamp(LocalDateTime.now());
			errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
			errorResponse.setError("Not Found");
			errorResponse.setMessages(Arrays.asList(
				new ErrorMessage("id", e.getMessage())
			));
			errorResponse.setErrorCode("DELETE_ERROR");
			errorResponse.setPath(request.getRequestURI());
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
		}
	}
	
 

}
