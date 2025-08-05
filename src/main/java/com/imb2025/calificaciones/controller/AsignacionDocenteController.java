package com.imb2025.calificaciones.controller;

import com.imb2025.calificaciones.entity.AsignacionDocente;
import com.imb2025.calificaciones.service.IAsignacionDocenteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/asignacion-docente")
public class AsignacionDocenteController {

    @Autowired
    private IAsignacionDocenteService service;

    @GetMapping
    public ResponseEntity<List<AsignacionDocente>> getAll() {
        List<AsignacionDocente> asignaciones = service.findAll();
        if (asignaciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(asignaciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsignacionDocente> getById(@PathVariable Long id) throws Exception {
        AsignacionDocente asignacionDocente = service.findById(id);
        if (asignacionDocente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(asignacionDocente);
    }

    @PostMapping
    public ResponseEntity<AsignacionDocente> create(@RequestBody AsignacionDocente asignacionDocente) {
        AsignacionDocente createdAsignacionDocente = service.create(asignacionDocente);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAsignacionDocente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AsignacionDocente> update(@PathVariable Long id,
            @RequestBody AsignacionDocente asignacionDocente) throws Exception {
        AsignacionDocente updatedAsignacionDocente = service.update(id, asignacionDocente);
        return ResponseEntity.ok(updatedAsignacionDocente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) throws Exception {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}