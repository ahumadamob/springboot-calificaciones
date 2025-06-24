package com.imb2025.calificaciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.imb2025.calificaciones.dto.InscripcionMateriaRequestDTO;
import com.imb2025.calificaciones.entity.InscripcionMateria;
import com.imb2025.calificaciones.service.jpa.InscripcionMateriaServiceImp;

@RestController
@RequestMapping("api/v1/inscripcion-materia")
public class InscripcionMateriaController {
    
    @Autowired
    private InscripcionMateriaServiceImp inscripcionMateriaService;

    @GetMapping
    public ResponseEntity<List<InscripcionMateria>> getAll(){
        List<InscripcionMateria> inscripciones = inscripcionMateriaService.findAll();
        return ResponseEntity.ok(inscripciones);
    }

    @GetMapping("/{idInscripcionMateria}")
    public ResponseEntity<InscripcionMateria> getById(@PathVariable("idInscripcionMateria") Long id){
        InscripcionMateria inscripcionMateria = inscripcionMateriaService.findById(id);
        return ResponseEntity.ok(inscripcionMateria);
    }

    @PostMapping
    public ResponseEntity<InscripcionMateria> create(@RequestBody InscripcionMateriaRequestDTO dto) {
        try {

            InscripcionMateria entity = inscripcionMateriaService.mapFromDto(dto);


            InscripcionMateria saved = inscripcionMateriaService.create(entity);

            return ResponseEntity.status(HttpStatus.CREATED).body(saved);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{idInscripcionMateria}")
    public ResponseEntity<InscripcionMateria> update(
        @PathVariable("idInscripcionMateria") Long id,
        @RequestBody InscripcionMateriaRequestDTO dto) {

        try {
            InscripcionMateria entity = inscripcionMateriaService.mapFromDto(dto);
            InscripcionMateria updated = inscripcionMateriaService.update(id, entity);
            return ResponseEntity.ok(updated);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @DeleteMapping("/{idInscripcionMateria}")
    public ResponseEntity<Void> delete(@PathVariable("idInscripcionMateria") Long id){
        inscripcionMateriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
