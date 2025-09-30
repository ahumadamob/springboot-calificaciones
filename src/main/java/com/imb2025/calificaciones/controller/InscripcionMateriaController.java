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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.imb2025.calificaciones.dto.InscripcionMateriaRequestDto;
import com.imb2025.calificaciones.entity.InscripcionMateria;
import com.imb2025.calificaciones.service.IInscripcionMateriaService;
@RestController
@RequestMapping("api/v1/inscripcion-materia")
public class InscripcionMateriaController {

    @Autowired
    private IInscripcionMateriaService inscripcionMateriaService;

    @GetMapping
    public ResponseEntity<List<InscripcionMateria>> getAll() {
        List<InscripcionMateria> inscripciones = inscripcionMateriaService.findAll();
        return inscripciones.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(inscripciones);
    }

    @GetMapping("/{idInscripcionMateria}")
    public ResponseEntity<InscripcionMateria> getById(@PathVariable("idInscripcionMateria") Long id) {
        InscripcionMateria inscripcion = inscripcionMateriaService.findById(id);
        return ResponseEntity.ok(inscripcion);
    }

    @PostMapping
    public ResponseEntity<InscripcionMateria> create(@RequestBody InscripcionMateriaRequestDto dto) {
        InscripcionMateria entity = inscripcionMateriaService.fromDto(dto);
        InscripcionMateria saved = inscripcionMateriaService.create(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{idInscripcionMateria}")
    public ResponseEntity<InscripcionMateria> update(@PathVariable Long id,
                                                     @RequestBody InscripcionMateriaRequestDto dto) {
        InscripcionMateria entity = inscripcionMateriaService.fromDto(dto);
        InscripcionMateria updated = inscripcionMateriaService.update(entity, id);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{idInscripcionMateria}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        inscripcionMateriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
