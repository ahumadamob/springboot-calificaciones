package com.imb2025.calificaciones.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
import com.imb2025.calificaciones.dto.mapper.PeriodoLectivoMapper;
import com.imb2025.calificaciones.dto.request.PeriodoLectivoRequestDto;
import com.imb2025.calificaciones.dto.response.PeriodoLectivoResponseDto;
import com.imb2025.calificaciones.entity.PeriodoLectivo;
import com.imb2025.calificaciones.service.IPeriodoLectivoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/periodo-lectivo")
public class PeriodoLectivoController {
	
	@Autowired
	private IPeriodoLectivoService service;
	
	@Autowired
	private PeriodoLectivoMapper mapper;
	
	@GetMapping
    public ResponseEntity<ApiResponseSuccessDto<List<PeriodoLectivoResponseDto>>> getAll() {
		List<PeriodoLectivo> resultados = service.findAll();
		
		List<PeriodoLectivoResponseDto> periodos = resultados.stream().map(p -> mapper.toResponse(p)).toList();
		
        ApiResponseSuccessDto<List<PeriodoLectivoResponseDto>> response = 
        		new ApiResponseSuccessDto<List<PeriodoLectivoResponseDto>>(true, "Periodos Lectivos encontrados con éxito", periodos);
        return periodos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(response);
    }
	
	@GetMapping("/get/activos")
    public ResponseEntity<ApiResponseSuccessDto<List<PeriodoLectivoResponseDto>>> getAllByActivoTrue() {
		List<PeriodoLectivo> resultados = service.findByActivo(true);
		
		List<PeriodoLectivoResponseDto> periodos = resultados.stream().map(p -> mapper.toResponse(p)).toList();
		
        ApiResponseSuccessDto<List<PeriodoLectivoResponseDto>> response = 
        		new ApiResponseSuccessDto<List<PeriodoLectivoResponseDto>>(true, "Periodos Lectivos Activos encontrados con éxito", periodos);
        return periodos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(response);
    }
	
	@GetMapping("/get/inactivos")
    public ResponseEntity<ApiResponseSuccessDto<List<PeriodoLectivoResponseDto>>> getAllByActivoFalse() {
		List<PeriodoLectivo> resultados = service.findByActivo(true);
		
		List<PeriodoLectivoResponseDto> periodos = resultados.stream().map(p -> mapper.toResponse(p)).toList();
		
        ApiResponseSuccessDto<List<PeriodoLectivoResponseDto>> response = 
        		new ApiResponseSuccessDto<List<PeriodoLectivoResponseDto>>(true, "Periodos Lectivos Inactivos encontrados con éxito", periodos);
        return periodos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(response);
    }

	@GetMapping("/{id}")
	public ResponseEntity<ApiResponseSuccessDto<PeriodoLectivoResponseDto>> getById(@PathVariable Long id) {
		PeriodoLectivo resultado = service.findById(id);
		PeriodoLectivoResponseDto periodoLectivo = mapper.toResponse(resultado);
		ApiResponseSuccessDto<PeriodoLectivoResponseDto> response = new ApiResponseSuccessDto<PeriodoLectivoResponseDto>(true, "Periodo Lectivo encontrado con éxito", periodoLectivo); 
		return ResponseEntity.ok(response);
	}
        
	@GetMapping("/get")
	public ResponseEntity<ApiResponseSuccessDto<List<PeriodoLectivoResponseDto>>> getByNombre(
			@RequestParam(required = true) String nombre) {
        List<PeriodoLectivo> resultados = service.findAllByNombre(nombre);
        
		List<PeriodoLectivoResponseDto> periodos = resultados.stream().map(p -> mapper.toResponse(p)).toList();
        
 		ApiResponseSuccessDto<List<PeriodoLectivoResponseDto>> response = new ApiResponseSuccessDto<List<PeriodoLectivoResponseDto>>(true, "Periodos Lectivos con el nombre "+ nombre +" encontrados con éxito", periodos);
        return periodos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(response);
    }
    
    @GetMapping("/count")
    public ResponseEntity<ApiResponseSuccessDto<HashMap<String, Long>>> countByIncioAndFin(
    		@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate inicio, 
    		@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fin) {
    	Long count = service.countByFechaInicioAndFechaFin(inicio, fin);
  		HashMap<String, Long> hash = new HashMap<String, Long>();
        hash.put("cantidad", count);
        ApiResponseSuccessDto<HashMap<String, Long>> response = new ApiResponseSuccessDto<HashMap<String, Long>>(true, "", hash);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponseSuccessDto<PeriodoLectivoResponseDto>> create(
        @Valid @RequestBody PeriodoLectivoRequestDto periodoLectivo) throws Exception {
    	PeriodoLectivo resultado = service.create(
    			mapper.fromDto(periodoLectivo)
    			);
    	PeriodoLectivoResponseDto createdPeriodoLectivo = mapper.toResponse(resultado);
    	ApiResponseSuccessDto<PeriodoLectivoResponseDto> response = new ApiResponseSuccessDto<PeriodoLectivoResponseDto>(true, "Periodo Lectivo creado con éxito", createdPeriodoLectivo);
    	return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<PeriodoLectivoResponseDto>> updateById(@PathVariable Long id,
    	@Valid @RequestBody PeriodoLectivoRequestDto periodoLectivo) throws Exception {
    	PeriodoLectivo resultado = service.update(
    			mapper.fromDto(periodoLectivo),
    			id
    			);
    	PeriodoLectivoResponseDto updatedPeriodoLectivo = mapper.toResponse(resultado);
    	ApiResponseSuccessDto<PeriodoLectivoResponseDto> response = new ApiResponseSuccessDto<PeriodoLectivoResponseDto>(true, "Periodo Lectivo actualizado con éxito", updatedPeriodoLectivo);
    	return ResponseEntity.status(HttpStatus.CREATED).body(response);
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
