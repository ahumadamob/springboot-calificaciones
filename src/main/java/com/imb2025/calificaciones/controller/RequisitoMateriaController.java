package com.imb2025.calificaciones.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imb2025.calificaciones.dto.RequisitoMateriaRequestDto;
import com.imb2025.calificaciones.entity.RequisitoMateria;
import com.imb2025.calificaciones.service.IRequisitoMateriaService;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/requisito-materia")
public class RequisitoMateriaController {

    @Autowired
    private IRequisitoMateriaService service;

    @GetMapping
    public List<RequisitoMateria> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        RequisitoMateria requisito = service.findById(id);
        if (requisito == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El requisito con ID " + id + " no existe.");
        }
        return ResponseEntity.ok(requisito);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid RequisitoMateriaRequestDto dto) {
        try {
            RequisitoMateria nuevo = service.create(service.fromDto(dto));
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al crear requisito: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid RequisitoMateriaRequestDto dto) {
        RequisitoMateria existente = service.findById(id);
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró un requisito con el ID " + id + " para actualizar.");
        }

        try {
            RequisitoMateria actualizado = service.update(service.fromDto(dto), id);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al actualizar: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        RequisitoMateria existente = service.findById(id);
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró el requisito con ID " + id + " para eliminar.");
        }

        try {
            service.deleteById(id);
            return ResponseEntity.ok("Requisito eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
