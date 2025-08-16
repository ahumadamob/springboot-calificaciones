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

import com.imb2025.calificaciones.dto.RequisitoMateriaRequestDTO;
import com.imb2025.calificaciones.entity.RequisitoMateria;
import com.imb2025.calificaciones.service.RequisitoMateriaService;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/requisito-materia")
public class RequisitoMateriaController {

    @Autowired
    private RequisitoMateriaService service;

    @GetMapping
    public List<RequisitoMateria> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<RequisitoMateria> requisito = service.findById(id);
        if (requisito.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El requisito con ID " + id + " no existe.");
        }
        return ResponseEntity.ok(requisito.get());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid RequisitoMateriaRequestDTO dto) {
        try {
            RequisitoMateria nuevo = service.save(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al crear requisito: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid RequisitoMateriaRequestDTO dto) {
        Optional<RequisitoMateria> existente = service.findById(id);
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró un requisito con el ID " + id + " para actualizar.");
        }

        try {
            RequisitoMateria actualizado = service.update(id, dto);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al actualizar: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<RequisitoMateria> existente = service.findById(id);
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró el requisito con ID " + id + " para eliminar.");
        }

        service.deleteById(id);
        return ResponseEntity.ok("Requisito eliminado correctamente");
    }
}
