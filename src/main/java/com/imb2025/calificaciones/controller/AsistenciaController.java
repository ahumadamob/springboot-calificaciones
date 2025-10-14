package com.imb2025.calificaciones.controller;


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

import com.imb2025.calificaciones.dto.AsistenciaRequestDto;
import com.imb2025.calificaciones.entity.Asistencia;
import com.imb2025.calificaciones.service.IAsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api/asistencia")
public class AsistenciaController {

    @Autowired
    private IAsistenciaService asistenciaService;

    // GET - listar todas las asistencias
    @GetMapping
    public ResponseEntity<List<Asistencia>> getAll() {
        List<Asistencia> asistencias = asistenciaService.findAll();
        return asistencias.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(asistencias);
    }

    // GET - buscar una asistencia por ID
    @GetMapping("/{id}")
    public ResponseEntity<Asistencia> getById(@PathVariable Long id) {
        Asistencia asistencia = asistenciaService.findById(id);
        return asistencia == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(asistencia);
    }

    // POST - crear nueva asistencia
    @PostMapping
    public ResponseEntity<Asistencia> create(@RequestBody AsistenciaRequestDto dto) throws Exception {
        Asistencia nueva = asistenciaService.create(dto);
        return ResponseEntity.status(201).body(nueva);
    }

    // PUT - actualizar asistencia existente
    @PutMapping("/{id}")
    public ResponseEntity<Asistencia> update(@PathVariable Long id, @RequestBody AsistenciaRequestDto dto) throws Exception {
        if (!asistenciaService.existsById(id)) {
            return ResponseEntity.badRequest().build();
        }
        Asistencia actualizada = asistenciaService.update(dto, id);
        return ResponseEntity.ok(actualizada);
    }

    // DELETE - eliminar una asistencia
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception {
        if (!asistenciaService.existsById(id)) {
            return ResponseEntity.badRequest().build();
        }
        asistenciaService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}

