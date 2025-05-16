package com.imb2025.calificaciones.controller;

import com.imb2025.calificaciones.entity.EstadoCursada;
import com.imb2025.calificaciones.service.EstadoCursadaServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/estadocursada")
public class EstadoCursadaController {

    @Autowired
    private EstadoCursadaServiceImp service;

    @GetMapping
    public ResponseEntity<List<EstadoCursada>> getAll() {
        List<EstadoCursada> asignaciones = service.findAll();
        return ResponseEntity.ok(asignaciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoCursada> getById(@PathVariable Long id) {
    	EstadoCursada estadoCursada = service.findById(id);
        return ResponseEntity.ok(estadoCursada);
    }

    @PostMapping
    public ResponseEntity<EstadoCursada> create(@RequestBody EstadoCursada estadoCursada) {
    	EstadoCursada createdEstadoCursada = service.save(estadoCursada);
        return ResponseEntity.ok(createdEstadoCursada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoCursada> update(@PathVariable Long id,
            @RequestBody EstadoCursada estadoCursada) {
    	EstadoCursada updatedEstadoCursada = service.update(id, estadoCursada);
        return ResponseEntity.ok(updatedEstadoCursada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}