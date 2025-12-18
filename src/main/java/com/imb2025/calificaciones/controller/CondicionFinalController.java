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
// Import corregido: se asume que moviste CondicionFinalRequestDto a este paquete
import com.imb2025.calificaciones.dto.request.CondicionFinalRequestDto; 
import com.imb2025.calificaciones.dto.response.CondicionFinalResponseDto; // Nuevo: DTO de respuesta
import com.imb2025.calificaciones.entity.CondicionFinal;
import com.imb2025.calificaciones.service.ICondicionFinalService;
import com.imb2025.calificaciones.mapper.CondicionFinalMapper; // Nuevo: Importar el Mapper

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors; // Nuevo: Para mapear listas

@RestController
@RequestMapping("/api/condicion-final")
public class CondicionFinalController {

    @Autowired
    private ICondicionFinalService service;

    @Autowired // Inyección del Mapper
    private CondicionFinalMapper mapper;

    @GetMapping
    public ResponseEntity<List<CondicionFinalResponseDto>> getAll() { // Devuelve lista de DTOs
        List<CondicionFinal> condiciones = service.findAll();
        if (condiciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        // Mapear de entidad a ResponseDto
        List<CondicionFinalResponseDto> dtos = condiciones.stream()
            .map(mapper::toResponseDto)
            .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CondicionFinalResponseDto> getById(@PathVariable Long id) { // Devuelve DTO
        CondicionFinal condicion = service.findById(id);
        // Mapear de entidad a ResponseDto
        return condicion == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(mapper.toResponseDto(condicion));
    }

    @PostMapping
    public ResponseEntity<CondicionFinalResponseDto> create(@RequestBody CondicionFinalRequestDto dto) throws Exception { // Recibe Request DTO, devuelve Response DTO
        // Reemplazar service.fromDto(dto) con mapper.toEntity(dto)
        CondicionFinal condicion = mapper.toEntity(dto);
        CondicionFinal created = service.create(condicion);
        // Devolver la entidad mapeada a ResponseDto
        return ResponseEntity.ok(mapper.toResponseDto(created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CondicionFinalResponseDto> update(@PathVariable Long id, @RequestBody CondicionFinalRequestDto dto) throws Exception { // Recibe Request DTO, devuelve Response DTO
        CondicionFinal existente = service.findById(id);
        if (existente == null) {
            return ResponseEntity.badRequest().build();
        }
        // Reemplazar service.fromDto(dto) con mapper.toEntity(dto)
        CondicionFinal condicion = mapper.toEntity(dto);
        CondicionFinal updated = service.update(condicion, id);
        // Devolver la entidad mapeada a ResponseDto
        return ResponseEntity.ok(mapper.toResponseDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            service.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // endpoint: buscar por nombre
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<CondicionFinalResponseDto>> getByNombre(@PathVariable String nombre) { // Devuelve lista de DTOs
        List<CondicionFinal> lista = service.findByNombre(nombre);
        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        // Mapear de entidad a ResponseDto
        List<CondicionFinalResponseDto> dtos = lista.stream()
            .map(mapper::toResponseDto)
            .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    // endpoint: contar por nombre
    @GetMapping("/count/{nombre}")
    public ResponseEntity<Long> countByNombre(@PathVariable String nombre) {
        Long cantidad = service.countByNombre(nombre);
        return ResponseEntity.ok(cantidad);
    }
    
    @GetMapping("/buscar")
	public ResponseEntity<ApiResponseSuccessDto<List<CondicionFinalResponseDto>>> getByDescripcionCorta(
			@RequestParam(required = true) String texto) throws Exception {
        List<CondicionFinal> resultados = service.findByDescripcionCorta(texto);

		List<CondicionFinalResponseDto> condiciones = resultados.stream().map(p -> mapper.toResponseDto(p)).toList();

 		ApiResponseSuccessDto<List<CondicionFinalResponseDto>> response = new ApiResponseSuccessDto<List<CondicionFinalResponseDto>>(true, "Condicion Final encontrados con éxito", condiciones);
 		  return ResponseEntity.ok(response);
    }
    

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}