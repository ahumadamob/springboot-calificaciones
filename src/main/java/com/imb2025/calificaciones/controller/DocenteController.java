package com.imb2025.calificaciones.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.imb2025.calificaciones.dto.DocenteRequestDto;
import com.imb2025.calificaciones.entity.Docente;
import com.imb2025.calificaciones.service.IDocenteService;

@RestController
@RequestMapping("/api/docente")
public class DocenteController {

    @Autowired
    private IDocenteService docenteService;

    @GetMapping
    public ResponseEntity<List<Docente>> getAllDocente() {
        List<Docente> docentes = docenteService.findAll();
        return docentes.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(docentes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Docente> getDocenteById(@PathVariable Long id) {
        Docente docente = docenteService.findById(id);
        if (docente == null) {
            return ResponseEntity.notFound().build(); // si no lo encuentra devuelve 404
        }
        return ResponseEntity.ok(docente);
    }

    @PostMapping
    public ResponseEntity<Docente> crear(@RequestBody DocenteRequestDto dto) throws Exception {
        Docente docente = new Docente();
        docente = docenteService.fromDto(dto);
        return ResponseEntity.ok(docenteService.create(docente));
    }

    public ResponseEntity<Docente> actualizar(@PathVariable Long id, @RequestBody DocenteRequestDto dto)
            throws Exception {
        Docente existente = docenteService.findById(id);
        if (existente != null) {
            Docente docente = docenteService.fromDto(dto);
            return ResponseEntity.ok(docenteService.update(docente, id));
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocente(@PathVariable("id") Long id) {
        try {
            docenteService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
