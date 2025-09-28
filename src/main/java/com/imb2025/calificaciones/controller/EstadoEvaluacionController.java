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
import org.springframework.web.bind.annotation.RestController;

import com.imb2025.calificaciones.dto.EstadoEvaluacionRequestDto;
import com.imb2025.calificaciones.entity.EstadoEvaluacion;
import com.imb2025.calificaciones.service.IEstadoEvaluacionService;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RestController
@RequestMapping("/api/estadoevaluacion")
public class EstadoEvaluacionController {

    @Autowired
    private IEstadoEvaluacionService service;

    @GetMapping
    public ResponseEntity<List<EstadoEvaluacion>> getAll() {
        List<EstadoEvaluacion> estados = service.findAll();
        return estados.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(estados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoEvaluacion> getById(@PathVariable Long id) {
        EstadoEvaluacion estado = service.findById(id);
        return estado == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(estado);
    }

    @PostMapping
    public ResponseEntity<EstadoEvaluacion> create(@RequestBody EstadoEvaluacionRequestDto estadoEvaluacion) throws Exception {
        EstadoEvaluacion creado = service.create(service.fromDto(estadoEvaluacion));
        return ResponseEntity.ok(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoEvaluacion> update(@PathVariable Long id, @RequestBody EstadoEvaluacionRequestDto estadoEvaluacion) throws Exception {
        EstadoEvaluacion existente = service.findById(id);
        if (existente == null) {
            return ResponseEntity.badRequest().build();
        }
        EstadoEvaluacion actualizado = service.update(service.fromDto(estadoEvaluacion), id);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}
