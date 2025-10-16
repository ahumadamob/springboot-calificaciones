package com.imb2025.calificaciones.controller;


import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
import com.imb2025.calificaciones.dto.mapper.EstadoCursadaMapper;
import com.imb2025.calificaciones.dto.request.EstadoCursadaRequestDto;
import com.imb2025.calificaciones.dto.response.EstadoCursadaResponseDto;


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

import com.imb2025.calificaciones.entity.EstadoCursada;
import com.imb2025.calificaciones.service.IEstadoCursadaService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/estadocursada")
public class EstadoCursadaController {

    @Autowired
    private IEstadoCursadaService service;


    @GetMapping
    public ResponseEntity<ApiResponseSuccessDto<List<EstadoCursadaResponseDto>>> getAll() {
        List<EstadoCursada> estados = service.findAll();
        List<EstadoCursadaResponseDto> estadoCursadaDtoList= new ArrayList<EstadoCursadaResponseDto>();
        EstadoCursadaMapper mapper = new EstadoCursadaMapper();
        for(EstadoCursada n : estados) {
        	estadoCursadaDtoList.add(mapper.toResponseDto(n));
        }
        ApiResponseSuccessDto<List<EstadoCursadaResponseDto>> response = new ApiResponseSuccessDto<>();
        response.setSuccess(true);
        response.setData(estadoCursadaDtoList);
        response.setMessage("Listado de Estados de Cursada");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto <EstadoCursada>> getEstadoCursadabyId(@PathVariable Long id) {
        EstadoCursada estado = service.findById(id);
        ApiResponseSuccessDto<EstadoCursada> response = new ApiResponseSuccessDto<>();
    	response.setMessage("Estado de la Materia fue encontrada con exito");
    	response.setData(estado);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/buscar")
    public ResponseEntity<ApiResponseSuccessDto<List<EstadoCursada>>> findByNombre(@RequestParam String nombre) {
        List<EstadoCursada> estados = service.findByNombreIgnoreCase(nombre);
        ApiResponseSuccessDto<List<EstadoCursada>> response = new ApiResponseSuccessDto<>(
            true,
            "Estados encontrados con nombre: " + nombre,
            estados
        );
        return estados.isEmpty()
            ? ResponseEntity.noContent().build()
            : ResponseEntity.ok(response);
    }

    @GetMapping("/contar")
    public ResponseEntity<ApiResponseSuccessDto<Long>> contarPorDescripcion(@RequestParam String descripcion) {
        long count = service.countByDescripcionIgnoreCase(descripcion);
        ApiResponseSuccessDto<Long> response = new ApiResponseSuccessDto<>(
            true,
            "Cantidad de estados con descripción: " + descripcion,
            count
        );
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponseSuccessDto<EstadoCursada>> create(
            @Valid @RequestBody EstadoCursadaRequestDto dto) throws Exception {
    	EstadoCursadaMapper mapper = new EstadoCursadaMapper();
        EstadoCursada estadoCursada = service.create(mapper.fromDto(dto));

        ApiResponseSuccessDto<EstadoCursada> response = new ApiResponseSuccessDto<EstadoCursada>(
            true,
            "Estado de cursada creado exitosamente",
            estadoCursada
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoCursada> update(@RequestBody EstadoCursadaRequestDto dto, @Valid @PathVariable Long id) throws Exception {
        EstadoCursadaMapper mapper = new EstadoCursadaMapper();
    	EstadoCursada existente = service.findById(id);
        if (existente == null) {
            return ResponseEntity.badRequest().build();
        }
        EstadoCursada estadoCursada = mapper.fromDto(dto);
        return ResponseEntity.ok(service.update(estadoCursada, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstadoCursada(@PathVariable Long id) {
        try {
            service.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
