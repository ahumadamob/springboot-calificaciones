package com.imb2025.calificaciones.controller;


import java.util.List;
import java.util.stream.Collectors;

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

import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
import com.imb2025.calificaciones.dto.mapper.ObservacionAlumnoMapper;
import com.imb2025.calificaciones.dto.request.ObservacionAlumnoRequestDto;
import com.imb2025.calificaciones.dto.response.ObservacionAlumnoResponseDto;
import com.imb2025.calificaciones.entity.Alumno;
import com.imb2025.calificaciones.entity.Docente;
import com.imb2025.calificaciones.entity.ObservacionAlumno;
import com.imb2025.calificaciones.service.IObservacionAlumnoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/observacionAlumno")
public class ObservacionAlumnoController {
	
	@Autowired
	private IObservacionAlumnoService observacionAlumnoService;
	
	@Autowired
	private ObservacionAlumnoMapper mapper;
	 
	
	@GetMapping
	public ResponseEntity<ApiResponseSuccessDto<List<ObservacionAlumnoResponseDto>>> getAll(){
		List<ObservacionAlumno> observacion = observacionAlumnoService.findAll();
		
		List<ObservacionAlumnoResponseDto> lista = observacion.stream()
				.map(mapper::toResponseDto)
				.collect(Collectors.toList());
		
		ApiResponseSuccessDto<List<ObservacionAlumnoResponseDto>> response = new ApiResponseSuccessDto<>();
		response.setSuccess(true);
		response.setMessage("Observaciones obtenidas correctamente");
		response.setData(lista);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponseSuccessDto<ObservacionAlumnoResponseDto>> getById(@PathVariable Long id, HttpServletRequest request) {
		
            ObservacionAlumno observacionAlumno = observacionAlumnoService.findById(id);
            ObservacionAlumnoResponseDto responseDto = mapper.toResponseDto(observacionAlumno);
            ApiResponseSuccessDto<ObservacionAlumnoResponseDto> response = new ApiResponseSuccessDto<>();
            response.setSuccess(true);
            response.setMessage("Observación de alumno encontrada con exito");
            response.setData(responseDto);
			return ResponseEntity.ok(response);
	}
	
	@PostMapping
	public ResponseEntity<ApiResponseSuccessDto<ObservacionAlumnoResponseDto>> create(
	        @Valid @RequestBody ObservacionAlumnoRequestDto dto) {

	    ObservacionAlumno observacion = mapper.fromDto(dto);
	    ObservacionAlumno creada = observacionAlumnoService.create(observacion, dto.getAlumnoId(), dto.getDocenteId());
	    ObservacionAlumnoResponseDto responseDto = mapper.toResponseDto(creada);

	    ApiResponseSuccessDto<ObservacionAlumnoResponseDto> response = new ApiResponseSuccessDto<>();
	    response.setSuccess(true);
	    response.setMessage("Observación creada correctamente");
	    response.setData(responseDto);

	    return ResponseEntity.ok(response);
	}

	
	@PutMapping("/{id}")
	public ResponseEntity<ApiResponseSuccessDto<ObservacionAlumnoResponseDto>> update(
	        @Valid @RequestBody ObservacionAlumnoRequestDto dto,
	        @PathVariable Long id) throws Exception {

	    ObservacionAlumno observacion = mapper.fromDto(dto);
	    ObservacionAlumno observacionActualizada = observacionAlumnoService.update(observacion, id, dto.getAlumnoId(), dto.getDocenteId());
	    ObservacionAlumnoResponseDto responseDto = mapper.toResponseDto(observacionActualizada);

	    ApiResponseSuccessDto<ObservacionAlumnoResponseDto> response = new ApiResponseSuccessDto<>();
	    response.setSuccess(true);
	    response.setMessage("Observación actualizada correctamente");
	    response.setData(responseDto);

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
	
	@GetMapping("docenteId/{docente}")
	public ResponseEntity<ApiResponseSuccessDto<List<ObservacionAlumnoResponseDto>>> findByDocenteId(@PathVariable Docente docente){
		List<ObservacionAlumno> observacionByDocente = observacionAlumnoService.findByDocente(docente);
		
		List<ObservacionAlumnoResponseDto> lista = observacionByDocente.stream()
				.map(mapper::toResponseDto)
				.collect(Collectors.toList());
		
		ApiResponseSuccessDto<List<ObservacionAlumnoResponseDto>> response = new ApiResponseSuccessDto<>();
		response.setSuccess(true);
		response.setMessage("Observaciones obtenidas correctamente por ID de docente");
		response.setData(lista);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("countByAlumno/{alumno}")
	public ResponseEntity<?> countByAlumno(@PathVariable Alumno alumno){
		Long count = observacionAlumnoService.countByAlumno(alumno);
		
		ApiResponseSuccessDto<Long> response = new ApiResponseSuccessDto<>();
		response.setSuccess(true);
		response.setMessage("Numero de observaciones obtenidas correctamente por ID de alumno");
		response.setData(count);
		
		return ResponseEntity.ok(response);
	}
	
	
}
	
