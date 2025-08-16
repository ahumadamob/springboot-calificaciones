package com.imb2025.calificaciones.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imb2025.calificaciones.entity.TipoNota;
import com.imb2025.calificaciones.service.ITipoNotaService;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
        try {
            // Verificamos si el TipoNota existe antes de intentar actualizar
            tipoNotaService.findById(id);

            TipoNota actualizado = tipoNotaService.update(id, tipoNota);
            return ResponseEntity.ok(actualizado);

        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    // DELETE /tiponota/{id} - borrar por id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        tipoNotaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

