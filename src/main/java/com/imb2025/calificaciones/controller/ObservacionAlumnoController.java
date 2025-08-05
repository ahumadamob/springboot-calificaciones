package com.imb2025.calificaciones.controller;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imb2025.calificaciones.dto.ErrorMessage;
import com.imb2025.calificaciones.dto.ErrorResponseDto;
import com.imb2025.calificaciones.dto.ObservacionAlumnoRequestDTO;
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
        public ResponseEntity<?> create(@RequestBody ObservacionAlumnoRequestDTO dto) {
                ObservacionAlumno observacionAlumno = observacionAlumnoService.create(observacionAlumnoService.fromDTO(dto));

                SuccessResponseDto<ObservacionAlumno> response = new SuccessResponseDto<>();
                response.setTimestamp(LocalDateTime.now());
                response.setStatus(HttpStatus.CREATED.value());
                response.setMessage("observación creada correctamente");
                response.setData(observacionAlumno);

                return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }

        @PutMapping("/{id}")
        public ResponseEntity<?> update(@RequestBody ObservacionAlumnoRequestDTO dto, @PathVariable Long id) {
                ObservacionAlumno observacionAlumno = observacionAlumnoService.update(id, observacionAlumnoService.fromDTO(dto));

                SuccessResponseDto<ObservacionAlumno> response = new SuccessResponseDto<>();
                response.setTimestamp(LocalDateTime.now());
                response.setStatus(HttpStatus.OK.value());
                response.setMessage("observación actualizada correctamente");
                response.setData(observacionAlumno);

                return ResponseEntity.ok(response);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> delete(@PathVariable Long id) {
                observacionAlumnoService.deleteById(id);

                SuccessResponseDto<String> response = new SuccessResponseDto<>();
                response.setTimestamp(LocalDateTime.now());
                response.setStatus(HttpStatus.OK.value());
                response.setMessage("Observación eliminada exitosamente");
                response.setData("Observación con ID " + id + " eliminada correctamente");

                return ResponseEntity.ok(response);
        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<String> handleException(Exception ex) {
                return ResponseEntity.badRequest().body(ex.getMessage());
        }
	
 

}
