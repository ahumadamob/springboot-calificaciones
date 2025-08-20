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

import com.imb2025.calificaciones.dto.AsignacionDocenteRequestDto;
import com.imb2025.calificaciones.entity.AsignacionDocente;
import com.imb2025.calificaciones.service.IAsignacionDocenteService;

import org.springframework.beans.factory.annotation.Autowired;

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
    public ResponseEntity<AsignacionDocente> create(@RequestBody AsignacionDocenteRequestDto dto) throws Exception {
        AsignacionDocente asignacion = service.fromDto(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(asignacion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AsignacionDocente> update(@PathVariable Long id,
            @RequestBody AsignacionDocenteRequestDto dto) throws Exception {
        AsignacionDocente asignacion = service.fromDto(dto);
        return ResponseEntity.ok(service.update(asignacion, id));
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
