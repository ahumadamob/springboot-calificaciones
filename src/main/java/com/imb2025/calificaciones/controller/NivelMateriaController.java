package com.imb2025.calificaciones.controller;
import java.util.List;

import com.imb2025.calificaciones.dto.ApiResponseDTO;
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


import com.imb2025.calificaciones.dto.NivelMateriaRequestDto;


@RestController
public class NivelMateriaController {
@Autowired
private INivelMateriaService nivelMateriaService;

@GetMapping("/api/nivelmateria")
public ResponseEntity<ApiResponseDTO<List<NivelMateria>>> getAllNivelMateria() {
    List<NivelMateria> nivelMaterias = nivelMateriaService.findAll();
    ApiResponseDTO<List<NivelMateria>> response = new ApiResponseDTO<>();
    response.setSuccess(true);
    response.setData(nivelMaterias);
    response.setMessage("Lista de NivelMateria");
    return ResponseEntity.ok(response);
}
@PostMapping("/api/nivelmateria")
public ResponseEntity<ApiResponseDTO<NivelMateria>> createNivelMateria(@RequestBody @Valid NivelMateriaRequestDto nivelDto) {
    NivelMateria nivel = new NivelMateria();
    nivel.setNombre(nivelDto.getNombre());
    nivel.setDescripcion(nivelDto.getDescripcion());

    NivelMateria created = nivelMateriaService.create(nivel);

    ApiResponseDTO<NivelMateria> response = new ApiResponseDTO<>();
    response.setSuccess(true);
    response.setData(created);
    response.setMessage("NivelMateria creada exitosamente");

    return ResponseEntity.status(HttpStatus.CREATED).body(response);
}

@PutMapping("/api/nivelmateria/{id}")
public ResponseEntity<ApiResponseDTO<NivelMateria>> updateNivelMateria(@PathVariable Long id, @RequestBody @Valid NivelMateriaRequestDto nivelDto) {
    try {
        NivelMateria nivel = nivelMateriaService.fromDto(nivelDto);
        NivelMateria updated = nivelMateriaService.update(nivel, id);
        ApiResponseDTO<NivelMateria> response = new ApiResponseDTO<NivelMateria>(true, updated, "NivelMateria actualizada exitosamente");
        return ResponseEntity.ok(response);
    } catch (Exception e) {
        ApiResponseDTO<NivelMateria> response = new ApiResponseDTO<NivelMateria>();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}

@DeleteMapping("/api/nivelmateria/{id}")
public ResponseEntity<ApiResponseDTO<Void>> deleteNivelMateria(@PathVariable Long id) {
    try {
        nivelMateriaService.deleteById(id);
        ApiResponseDTO<Void> response = new ApiResponseDTO<>();
        response.setSuccess(true);
        response.setMessage("NivelMateria eliminada correctamente");
        return ResponseEntity.ok(response);
    } catch (Exception e) {
        ApiResponseDTO<Void> response = new ApiResponseDTO<>();
        response.setSuccess(false);
        response.setMessage("Error al eliminar: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
}
