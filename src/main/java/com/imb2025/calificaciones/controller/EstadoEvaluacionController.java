package com.imb2025.calificaciones.controller;

import com.imb2025.calificaciones.dto.EstadoEvaluacionRequestDTO;
import com.imb2025.calificaciones.entity.EstadoEvaluacion;
import com.imb2025.calificaciones.condicionfinal.exception.EntidadNoEncontradaException;
import com.imb2025.calificaciones.service.jpa.EstadoEvaluacionServiceImpl;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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
             ResponseEntity.notFound();
        }
        return ResponseEntity.ok(estado);
    }

    @PostMapping
    public ResponseEntity<EstadoEvaluacion> create(@RequestBody EstadoEvaluacion estadoEvaluacion) {
        try {
            EstadoEvaluacion creado = service.save(estadoEvaluacion);
            return ResponseEntity.ok(creado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoEvaluacion> update(@PathVariable Long id, @RequestBody EstadoEvaluacion estadoEvaluacion) {
        try {
            EstadoEvaluacion actualizado = service.update(id, estadoEvaluacion);
            return ResponseEntity.ok(actualizado);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
