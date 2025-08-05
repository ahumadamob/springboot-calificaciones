package com.imb2025.calificaciones.controller;

import com.imb2025.calificaciones.dto.AsistenciaRequestDTO;
import com.imb2025.calificaciones.entity.Asistencia;
import com.imb2025.calificaciones.service.IAsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asistencia")
public class AsistenciaController {

    @Autowired
    private IAsistenciaService asistenciaService;

    // GET - listar todas las asistencias
    @GetMapping
    public List<Asistencia> getAll() {
        return asistenciaService.findAll();
    }

    // GET - buscar una asistencia por ID
    @GetMapping("/{id}")
    public ResponseEntity<Asistencia> getById(@PathVariable Long id) {
        Asistencia asistencia = asistenciaService.findById(id);
        if (asistencia == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(asistencia);
    }

    // POST - crear nueva asistencia
    @PostMapping
    public ResponseEntity<?> create(@RequestBody AsistenciaRequestDTO dto) {
        try {
            Asistencia nueva = asistenciaService.save(dto);
            return ResponseEntity.ok(nueva);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // PUT - actualizar asistencia existente
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody AsistenciaRequestDTO dto) {
        try {
            Asistencia actualizada = asistenciaService.update(id, dto);
            return ResponseEntity.ok(actualizada);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // DELETE - eliminar una asistencia
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            asistenciaService.deleteById(id);
            return ResponseEntity.ok("Asistencia eliminada con éxito.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

