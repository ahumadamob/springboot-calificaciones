package com.imb2025.calificaciones.controller;


import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imb2025.calificaciones.dto.EstadoCursadaRequestDto;
import com.imb2025.calificaciones.entity.EstadoCursada;
import com.imb2025.calificaciones.service.IEstadoCursadaService;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("api/estadocursada")
public class EstadoCursadaController {

    @Autowired
    private IEstadoCursadaService service;


    @GetMapping
    public ResponseEntity<List<EstadoCursada>> getAll() {
        List<EstadoCursada> estados = service.findAll();
        return estados.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(estados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto <EstadoCursada>> getEstadoCursadabyId(@PathVariable Long id) {
        EstadoCursada estado = service.findById(id);
        ApiResponseSuccessDto<EstadoCursada> response = new ApiResponseSuccessDto<>();
    	response.setMessage("Estado de la Materia fue encontrada con exito");
    	response.setData(estado);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<EstadoCursada> create(@RequestBody EstadoCursadaRequestDto dto) throws Exception {
        EstadoCursada estadoCursada = service.fromDto(dto);
        return ResponseEntity.ok(service.create(estadoCursada));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoCursada> update(@RequestBody EstadoCursadaRequestDto dto, @PathVariable Long id) throws Exception {
        EstadoCursada existente = service.findById(id);
        if (existente == null) {
            return ResponseEntity.badRequest().build();
        }
        EstadoCursada estadoCursada = service.fromDto(dto);
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
