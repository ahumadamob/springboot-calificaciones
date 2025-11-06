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
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
import com.imb2025.calificaciones.dto.mapper.CarreraMapper;
import com.imb2025.calificaciones.dto.request.CarreraRequestDto;
import com.imb2025.calificaciones.dto.response.CarreraResponseDto;
import com.imb2025.calificaciones.entity.Carrera;
import com.imb2025.calificaciones.service.ICarreraService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/carrera")
public class CarreraController {
    
    @Autowired
    private ICarreraService carreraService;
    
    @GetMapping
    public ResponseEntity<List<CarreraResponseDto>> getAll() {
        List<Carrera> carreras = carreraService.findAll();
        if (carreras.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<CarreraResponseDto> responseDtos = carreras.stream()
            .map(CarreraMapper::toResponseDto)
            .collect(Collectors.toList());
        return ResponseEntity.ok(responseDtos);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<CarreraResponseDto>> getById(@PathVariable Long id) {
        Carrera carrera = carreraService.findById(id);
        CarreraResponseDto responseDto = CarreraMapper.toResponseDto(carrera);
        
        ApiResponseSuccessDto<CarreraResponseDto> response = new ApiResponseSuccessDto<>();
        response.setSuccess(true);
        response.setMessage("Carrera encontrada con éxito");
        response.setData(responseDto);
        return ResponseEntity.ok(response);
    }
    
    @PostMapping
    public ResponseEntity<ApiResponseSuccessDto<CarreraResponseDto>> create(@RequestBody @Valid CarreraRequestDto dto) {
        Carrera carrera = CarreraMapper.fromDto(dto);
        Carrera created = carreraService.create(carrera);
        CarreraResponseDto responseDto = CarreraMapper.toResponseDto(created);
        
        ApiResponseSuccessDto<CarreraResponseDto> response = new ApiResponseSuccessDto<>();
        response.setSuccess(true);
        response.setMessage("Carrera creada con éxito");
        response.setData(responseDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<CarreraResponseDto>> update(
            @PathVariable Long id, 
            @RequestBody @Valid CarreraRequestDto dto) throws Exception {
        Carrera existente = carreraService.findById(id);
        if (existente == null) {
            return ResponseEntity.badRequest().build();
        }
        Carrera carrera = CarreraMapper.fromDto(dto);
        Carrera updated = carreraService.update(carrera, id);
        CarreraResponseDto responseDto = CarreraMapper.toResponseDto(updated);
        
        ApiResponseSuccessDto<CarreraResponseDto> response = new ApiResponseSuccessDto<>();
        response.setSuccess(true);
        response.setMessage("Carrera actualizada con éxito");
        response.setData(responseDto);
        return ResponseEntity.ok(response);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            carreraService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
  
    @GetMapping("/buscar/nombre-exacto/{nombre}")
    public ResponseEntity<ApiResponseSuccessDto<List<CarreraResponseDto>>> buscarPorNombreExacto(@PathVariable String nombre) {
        List<Carrera> carreras = carreraService.buscarPorNombre(nombre);
        
        if (carreras.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        
        List<CarreraResponseDto> responseDtos = carreras.stream()
            .map(CarreraMapper::toResponseDto)
            .collect(Collectors.toList());
        
        ApiResponseSuccessDto<List<CarreraResponseDto>> response = new ApiResponseSuccessDto<>();
        response.setSuccess(true);
        response.setMessage("Carreras encontradas con nombre exacto");
        response.setData(responseDtos);
        
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/buscar/nombre/{fragmento}")
    public ResponseEntity<ApiResponseSuccessDto<List<CarreraResponseDto>>> buscarPorFragmentoNombre(@PathVariable String fragmento) {
        List<Carrera> carreras = carreraService.buscarPorFragmentoNombre(fragmento);
        
        if (carreras.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        
        List<CarreraResponseDto> responseDtos = carreras.stream()
            .map(CarreraMapper::toResponseDto)
            .collect(Collectors.toList());
        
        ApiResponseSuccessDto<List<CarreraResponseDto>> response = new ApiResponseSuccessDto<>();
        response.setSuccess(true);
        response.setMessage("Se encontraron " + carreras.size() + " carrera(s) que contienen '" + fragmento + "'");
        response.setData(responseDtos);
        
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/existe/{nombre}")
    public ResponseEntity<ApiResponseSuccessDto<Boolean>> existePorNombre(@PathVariable String nombre) {
        boolean existe = carreraService.existePorNombre(nombre);
        
        ApiResponseSuccessDto<Boolean> response = new ApiResponseSuccessDto<>();
        response.setSuccess(true);
        response.setMessage(existe 
            ? "La carrera '" + nombre + "' ya existe en el sistema" 
            : "La carrera '" + nombre + "' no existe en el sistema");
        response.setData(existe);
        
        return ResponseEntity.ok(response);
    }
}