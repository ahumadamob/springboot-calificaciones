package com.imb2025.calificaciones.controller;

import com.imb2025.calificaciones.entity.AsignacionDocente;
import com.imb2025.calificaciones.service.jpa.AsignacionDocenteServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/asignacion-docente")
public class AsignacionDocenteController {

    @Autowired
    private AsignacionDocenteServiceImp service;

    @GetMapping
    public ResponseEntity<List<AsignacionDocente>> getAll() {
        List<AsignacionDocente> asignaciones = service.findAll();
        return ResponseEntity.ok(asignaciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsignacionDocente> getById(@PathVariable Long id) {
        AsignacionDocente asignacionDocente = service.findById(id);
        return ResponseEntity.ok(asignacionDocente);
    }

    @PostMapping
    public ResponseEntity<AsignacionDocente> create(@RequestBody AsignacionDocente asignacionDocente) {
        AsignacionDocente createdAsignacionDocente = service.save(asignacionDocente);
        return ResponseEntity.ok(createdAsignacionDocente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AsignacionDocente> update(@PathVariable Long id,
            @RequestBody AsignacionDocente asignacionDocente) {
        AsignacionDocente updatedAsignacionDocente = service.update(id, asignacionDocente);
        return ResponseEntity.ok(updatedAsignacionDocente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}