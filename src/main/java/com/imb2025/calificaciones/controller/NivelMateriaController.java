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
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;


import com.imb2025.calificaciones.entity.NivelMateria;
import com.imb2025.calificaciones.service.INivelMateriaService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
import com.imb2025.calificaciones.dto.request.NivelMateriaRequestDto;
import com.imb2025.calificaciones.dto.response.ErrorsDto;
import com.imb2025.calificaciones.dto.response.NivelMateriaResponseDto;
import com.imb2025.calificaciones.dto.mapper.NivelMateriaMapper;
import java.util.stream.Collectors;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import com.imb2025.calificaciones.exception.DuplicateResourceException;


@RestController
public class NivelMateriaController {
@Autowired
private INivelMateriaService nivelMateriaService;

@GetMapping("/api/nivelmateria")
public ResponseEntity<ApiResponseSuccessDto<List<NivelMateriaResponseDto>>> getAllNivelMateria() {
    List<NivelMateria> nivelMaterias = nivelMateriaService.findAll();
    
    List<NivelMateriaResponseDto> dtos = nivelMaterias.stream()
            .map(NivelMateriaMapper::toResponseDto)
            .collect(Collectors.toList());
    
    ApiResponseSuccessDto<List<NivelMateriaResponseDto>> response = new ApiResponseSuccessDto<>();
    response.setSuccess(true);
    response.setData(dtos);
    response.setMessage("Lista de NivelMateria");
    return ResponseEntity.ok(response);
}


@GetMapping("/api/nivelmateria/{id}")
public ResponseEntity<ApiResponseSuccessDto<NivelMateriaResponseDto>> getNivelMateriaById(@PathVariable Long id) {
    try {
        NivelMateria nivel = nivelMateriaService.findById(id); 

        if (nivel == null) {
            ApiResponseSuccessDto<NivelMateriaResponseDto> responseNotFound = new ApiResponseSuccessDto<>();
            responseNotFound.setSuccess(false);
            responseNotFound.setMessage("NivelMateria no encontrada con id: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseNotFound);
        }

        NivelMateriaResponseDto dto = NivelMateriaMapper.toResponseDto(nivel);
        
        ApiResponseSuccessDto<NivelMateriaResponseDto> response = new ApiResponseSuccessDto<>();
        response.setSuccess(true);
        response.setData(dto);
        response.setMessage("NivelMateria encontrada");
        return ResponseEntity.ok(response);
    } catch (Exception e) {
        ApiResponseSuccessDto<NivelMateriaResponseDto> responseError = new ApiResponseSuccessDto<>();
        responseError.setSuccess(false);
        responseError.setMessage("Error al obtener NivelMateria: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseError);
    }
}


@GetMapping("/count")
public ResponseEntity<Long> contar(@RequestParam(required = false) String nombre) {
    long cantidad = nivelMateriaService.countByNombre(nombre);
    return ResponseEntity.ok(cantidad);
    
}
@PostMapping("/api/nivelmateria")
public ResponseEntity<?> createNivelMateria(@RequestBody @Valid NivelMateriaRequestDto nivelDto, BindingResult bindingResult) {
    // 1) validaciones de campo acumuladas
    if (bindingResult.hasErrors()) {
        List<String> errors = bindingResult.getFieldErrors()
            .stream()
            .map(fe -> fe.getDefaultMessage())
            .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorsDto(errors));
    }

    try {
        NivelMateria nivel = NivelMateriaMapper.fromDto(nivelDto);
        NivelMateria created = nivelMateriaService.create(nivel);
        NivelMateriaResponseDto responseDto = NivelMateriaMapper.toResponseDto(created);
        ApiResponseSuccessDto<NivelMateriaResponseDto> response = new ApiResponseSuccessDto<>();
        response.setSuccess(true);
        response.setData(responseDto);
        response.setMessage("NivelMateria creada exitosamente");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    } catch (com.imb2025.calificaciones.exception.DuplicateResourceException dre) {
        // mensaje exacto pedido por la consigna
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorsDto(List.of("identificadorLegible duplicado")));
    } catch (Exception e) {
        ApiResponseSuccessDto<NivelMateriaResponseDto> responseError = new ApiResponseSuccessDto<>();
        responseError.setSuccess(false);
        responseError.setMessage("Error al crear NivelMateria: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseError);
    }
}
@PutMapping("/api/nivelmateria/{id}")
public ResponseEntity<ApiResponseSuccessDto<NivelMateriaResponseDto>> updateNivelMateria(@PathVariable Long id, @RequestBody @Valid NivelMateriaRequestDto nivelDto) {
    try {
        // Conversión dto -> entity usando el mapper (no debe hacerse por el service)
        NivelMateria nivel = NivelMateriaMapper.fromDto(nivelDto);

        // Llamamos al service para que actualice la entidad en la base
        NivelMateria updated = nivelMateriaService.update(nivel, id);

        // Convertimos la entidad actualizada a dto de respuesta
        NivelMateriaResponseDto responseDto = NivelMateriaMapper.toResponseDto(updated);

        ApiResponseSuccessDto<NivelMateriaResponseDto> response = new ApiResponseSuccessDto<>(true, "NivelMateria actualizada exitosamente", responseDto);
        return ResponseEntity.ok(response);
    } catch (Exception e) {
        ApiResponseSuccessDto<NivelMateriaResponseDto> response = new ApiResponseSuccessDto<>();
        response.setSuccess(false);
        response.setMessage("Error al actualizar: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}


@DeleteMapping("/api/nivelmateria/{id}")
public ResponseEntity<ApiResponseSuccessDto<Void>> deleteNivelMateria(@PathVariable Long id) {
    try {
        nivelMateriaService.deleteById(id);
        ApiResponseSuccessDto<Void> response = new ApiResponseSuccessDto<>();
        response.setSuccess(true);
        response.setMessage("NivelMateria eliminada correctamente");
        return ResponseEntity.ok(response);
    } catch (Exception e) {
    	ApiResponseSuccessDto<Void> response = new ApiResponseSuccessDto<>();
        response.setSuccess(false);
        response.setMessage("Error al eliminar: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
@GetMapping("/api/nivelmateria/activos")
public ResponseEntity<ApiResponseSuccessDto<List<NivelMateriaResponseDto>>> getNivelMateriaActivos() {
    List<NivelMateria> nivelMaterias = nivelMateriaService.findByActivoTrue();
    
    List<NivelMateriaResponseDto> dtos = nivelMaterias.stream()
            .map(NivelMateriaMapper::toResponseDto)
            .collect(Collectors.toList());
    
    ApiResponseSuccessDto<List<NivelMateriaResponseDto>> response = new ApiResponseSuccessDto<>();
    response.setSuccess(true);
    response.setData(dtos);
    response.setMessage("Lista de NivelMateria activos (activo = true)");
    return ResponseEntity.ok(response);
}

@GetMapping("/api/nivelmateria/inactivos")
public ResponseEntity<ApiResponseSuccessDto<List<NivelMateriaResponseDto>>> getNivelMateriaInactivos() {
    List<NivelMateria> nivelMaterias = nivelMateriaService.findByActivoFalse();
    
    List<NivelMateriaResponseDto> dtos = nivelMaterias.stream()
            .map(NivelMateriaMapper::toResponseDto)
            .collect(Collectors.toList());
    
    ApiResponseSuccessDto<List<NivelMateriaResponseDto>> response = new ApiResponseSuccessDto<>();
    response.setSuccess(true);
    response.setData(dtos);
    response.setMessage("Lista de NivelMateria inactivos (activo = false)");
    return ResponseEntity.ok(response);
}
}

