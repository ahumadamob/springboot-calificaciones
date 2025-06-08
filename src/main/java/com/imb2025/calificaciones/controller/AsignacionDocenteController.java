package com.imb2025.calificaciones.controller;

import com.imb2025.calificaciones.entity.AsignacionDocente;
import com.imb2025.calificaciones.dto.AsignacionDocenteRequestDTO;
import com.imb2025.calificaciones.service.IAsignacionDocenteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/asignacion-docente")
public class AsignacionDocenteController {

    @Autowired
    private IAsignacionDocenteService service;

    @GetMapping
    public ResponseEntity<List<AsignacionDocente>> getAll() {
        List<AsignacionDocente> asignaciones = service.findAll();
        return ResponseEntity.ok(asignaciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsignacionDocente> getById(@PathVariable Long id) {
        AsignacionDocente asignacionDocente = service.findById(id);
        if (asignacionDocente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(asignacionDocente);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody AsignacionDocenteRequestDTO dto) {
        try {
            AsignacionDocente createdAsignacionDocente = service.save(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdAsignacionDocente);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody AsignacionDocenteRequestDTO dto) {
        try {
            AsignacionDocente updatedAsignacionDocente = service.update(id, dto);
            if (updatedAsignacionDocente == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(updatedAsignacionDocente);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}