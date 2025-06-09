package com.imb2025.calificaciones.controller;

import com.imb2025.calificaciones.entity.EstadoEvaluacion;
import com.imb2025.calificaciones.service.jpa.EstadoEvaluacionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estadoevaluacion")
public class EstadoEvaluacionController {

    @Autowired
    private EstadoEvaluacionServiceImpl service;

    @GetMapping
    public ResponseEntity<List<EstadoEvaluacion>> getAll() {
        List<EstadoEvaluacion> estados = service.getAll();
        return ResponseEntity.ok(estados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoEvaluacion> getById(@PathVariable Long id) {
        EstadoEvaluacion estado = service.findById(id);
        if (estado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(estado);
    }

    @PostMapping
    public ResponseEntity<EstadoEvaluacion> create(@RequestBody EstadoEvaluacion estado) {
        EstadoEvaluacion creado = service.save(estado);
        return ResponseEntity.ok(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoEvaluacion> update(@PathVariable Long id, @RequestBody EstadoEvaluacion estado) {
        EstadoEvaluacion actualizado = service.update(id, estado);
        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
