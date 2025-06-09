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
import java.util.HashMap;
import java.util.Map;

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
    public ResponseEntity<?> getById(@PathVariable Long id) {
        AsignacionDocente asignacionDocente = service.findById(id);
        if (asignacionDocente == null) {
            Map<String, Object> response = new HashMap<>();
            response.put("mensaje", "Asignación docente no encontrada");
            response.put("error", "Not Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        return ResponseEntity.ok(asignacionDocente);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody AsignacionDocenteRequestDTO dto) {
        try {
            AsignacionDocente createdAsignacionDocente = service.save(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdAsignacionDocente);
        } catch (RuntimeException e) {
            Map<String, Object> response = new HashMap<>();
            response.put("mensaje", e.getMessage());
            response.put("error", "Bad Request");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody AsignacionDocenteRequestDTO dto) {
        try {
            AsignacionDocente updatedAsignacionDocente = service.update(id, dto);
            if (updatedAsignacionDocente == null) {
                Map<String, Object> response = new HashMap<>();
                response.put("mensaje", "Asignación docente no encontrada");
                response.put("error", "Not Found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
            return ResponseEntity.ok(updatedAsignacionDocente);
        } catch (RuntimeException e) {
            Map<String, Object> response = new HashMap<>();
            response.put("mensaje", e.getMessage());
            response.put("error", "Bad Request");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            Map<String, Object> response = new HashMap<>();
            response.put("mensaje", e.getMessage());
            response.put("error", "Bad Request");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}