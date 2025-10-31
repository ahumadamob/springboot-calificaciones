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

import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
import com.imb2025.calificaciones.dto.mapper.EstadoEvaluacionMapper;
import com.imb2025.calificaciones.dto.request.EstadoEvaluacionRequestDto;
import com.imb2025.calificaciones.dto.response.EstadoEvaluacionResponseDto;
import com.imb2025.calificaciones.entity.EstadoEvaluacion;
import com.imb2025.calificaciones.service.IEstadoEvaluacionService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/estadoevaluacion")
public class EstadoEvaluacionController {

    @Autowired
    private IEstadoEvaluacionService service;

    @Autowired
    private EstadoEvaluacionMapper mapper;

    @GetMapping
    public ResponseEntity<ApiResponseSuccessDto<List<EstadoEvaluacionResponseDto>>> getAll() {
        List<EstadoEvaluacion> estados = service.findAll();
        List<EstadoEvaluacionResponseDto> dtos = estados.stream().map(mapper::toResponse).collect(Collectors.toList());
        
        ApiResponseSuccessDto<List<EstadoEvaluacionResponseDto>> response = new ApiResponseSuccessDto<>(true, "Registros encontrados", dtos);
        
        return dtos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<EstadoEvaluacionResponseDto>> getById(@PathVariable Long id) {
        EstadoEvaluacion estado = service.findById(id);
        EstadoEvaluacionResponseDto dto = mapper.toResponse(estado);
        ApiResponseSuccessDto<EstadoEvaluacionResponseDto> response = new ApiResponseSuccessDto<>(true, "Registro encontrado", dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get")
	public ResponseEntity<ApiResponseSuccessDto<List<EstadoEvaluacionResponseDto>>> getByNombre(
			@RequestParam(required = true) String nombre) {
        List<EstadoEvaluacion> resultados = service.findByNombre(nombre);
		List<EstadoEvaluacionResponseDto> dtos = resultados.stream().map(mapper::toResponse).collect(Collectors.toList());
 		ApiResponseSuccessDto<List<EstadoEvaluacionResponseDto>> response = new ApiResponseSuccessDto<>(true, "Registros con el nombre "+ nombre +" encontrados con éxito", dtos);
        return dtos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(response);
    }
    
    @GetMapping("/count")
    public ResponseEntity<ApiResponseSuccessDto<HashMap<String, Long>>> countByDescripcion(
    		@RequestParam String descripcion) {
    	Long count = service.countByDescripcion(descripcion);
  		HashMap<String, Long> hash = new HashMap<>();
        hash.put("cantidad", count);
        ApiResponseSuccessDto<HashMap<String, Long>> response = new ApiResponseSuccessDto<>(true, "Conteo por descripción exitoso", hash);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponseSuccessDto<EstadoEvaluacionResponseDto>> create(@Valid @RequestBody EstadoEvaluacionRequestDto requestDto) {
        EstadoEvaluacion estadoEvaluacion = mapper.fromDto(requestDto);
        EstadoEvaluacion creado = service.create(estadoEvaluacion);
        EstadoEvaluacionResponseDto dto = mapper.toResponse(creado);
        ApiResponseSuccessDto<EstadoEvaluacionResponseDto> response = new ApiResponseSuccessDto<>(true, "Registro creado exitosamente", dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<EstadoEvaluacionResponseDto>> update(@PathVariable Long id, @Valid @RequestBody EstadoEvaluacionRequestDto requestDto) throws Exception {
        EstadoEvaluacion estadoEvaluacion = mapper.fromDto(requestDto);
        EstadoEvaluacion actualizado = service.update(estadoEvaluacion, id);
        EstadoEvaluacionResponseDto dto = mapper.toResponse(actualizado);
        ApiResponseSuccessDto<EstadoEvaluacionResponseDto> response = new ApiResponseSuccessDto<>(true, "Registro actualizado exitosamente", dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<Void>> delete(@PathVariable Long id) throws Exception {
        service.deleteById(id);
        ApiResponseSuccessDto<Void> response = new ApiResponseSuccessDto<>(true, "Registro eliminado exitosamente", null);
        return ResponseEntity.ok(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}
