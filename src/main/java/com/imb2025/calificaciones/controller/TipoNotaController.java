package com.imb2025.calificaciones.controller;

import com.imb2025.calificaciones.entity.TipoNota;
import com.imb2025.calificaciones.service.ITipoNotaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tiponota")
public class TipoNotaController {

    @Autowired
    private ITipoNotaService tipoNotaService;

    // GET /tiponota - lista todos
    @GetMapping
    public List<TipoNota> getAll() {
        return tipoNotaService.findAll();
    }

    // GET /tiponota/{id} - buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<TipoNota> getById(@PathVariable Long id) {
        try {
            TipoNota tipoNota = tipoNotaService.findById(id);
            return ResponseEntity.ok(tipoNota);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


    // POST /tiponota - crear nuevo
    @PostMapping
    public TipoNota create(@RequestBody TipoNota tipoNota) {
        return tipoNotaService.save(tipoNota);
    }

    // PUT /tiponota/{id} - actualizar existente
    @PutMapping("/{id}")
    public ResponseEntity<TipoNota> update(@PathVariable Long id, @RequestBody TipoNota tipoNota) {
        TipoNota actualizado = tipoNotaService.update(id, tipoNota);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /tiponota/{id} - borrar por id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        tipoNotaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

