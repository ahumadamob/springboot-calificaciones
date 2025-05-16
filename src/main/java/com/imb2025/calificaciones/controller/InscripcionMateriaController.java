package com.imb2025.calificaciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.imb2025.calificaciones.entity.InscripcionMateria;
import com.imb2025.calificaciones.service.InscripcionMateriaServiceImp;

@RestController
@RequestMapping("api/v1/inscripcion-materia")
public class InscripcionMateriaController {
    
    @Autowired
    private InscripcionMateriaServiceImp service;

    @GetMapping
    public ResponseEntity<List<InscripcionMateria>> getAll(){
        List<InscripcionMateria> inscripciones = service.findAll();
        return ResponseEntity.ok(inscripciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InscripcionMateria> getById(@PathVariable Long id){
        InscripcionMateria inscripcionMateria = service.findById(id);
        return ResponseEntity.ok(inscripcionMateria);
    }

    @PostMapping
    public ResponseEntity<InscripcionMateria> create(@RequestBody InscripcionMateria inscripcionMateria){
        InscripcionMateria createdInscripcionMateria = service.save(inscripcionMateria);
        return ResponseEntity.ok(createdInscripcionMateria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InscripcionMateria> update(@PathVariable Long id, @RequestBody InscripcionMateria inscripcionMateria){
        InscripcionMateria updatedInscripcionMateria = service.update(id, inscripcionMateria);
        return ResponseEntity.ok(updatedInscripcionMateria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
