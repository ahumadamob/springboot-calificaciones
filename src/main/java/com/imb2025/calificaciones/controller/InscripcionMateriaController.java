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

import java.util.List;
import java.util.NoSuchElementException;

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
        return inscripciones.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(inscripciones);
    }

    @GetMapping("/{idInscripcionMateria}")
    public ResponseEntity<InscripcionMateria> getById(@PathVariable("idInscripcionMateria") Long id) {
        InscripcionMateria inscripcionMateria = inscripcionMateriaService.findById(id);
        return ResponseEntity.ok(inscripcionMateria);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody InscripcionMateriaRequestDto dto) {
        try {
            InscripcionMateria entity = inscripcionMateriaService.fromDto(dto);
            InscripcionMateria saved = inscripcionMateriaService.create(entity);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);

        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno al crear la inscripción.");
        }
    }

    @PutMapping("/{idInscripcionMateria}")
    public ResponseEntity<?> update(
            @PathVariable("idInscripcionMateria") Long id,
            @RequestBody InscripcionMateriaRequestDto dto) {

        try {
            InscripcionMateria entity = inscripcionMateriaService.fromDto(dto);
            InscripcionMateria updated = inscripcionMateriaService.update(entity, id);
            return ResponseEntity.ok(updated);

        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{idInscripcionMateria}")
    public ResponseEntity<Void> delete(@PathVariable("idInscripcionMateria") Long id) {
        try {
            inscripcionMateriaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
