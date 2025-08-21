package com.imb2025.calificaciones.controller;

import com.imb2025.calificaciones.dto.CursadaRequestDto;
import com.imb2025.calificaciones.entity.Cursada;
import com.imb2025.calificaciones.service.ICursadaService;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/api/cursada")
public class CursadaController {

    @Autowired
    private ICursadaService cursadaService;

    @GetMapping
    public ResponseEntity<List<Cursada>> getAll() {
        List<Cursada> cursadas = cursadaService.findAll();
        return cursadas.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(cursadas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cursada> getById(@PathVariable Long id) {
        Cursada cursada = cursadaService.findById(id);
        return cursada == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(cursada);
    }

    @PostMapping
    public ResponseEntity<Cursada> create(@RequestBody CursadaRequestDto dto) throws Exception {
        Cursada cursada = cursadaService.fromDto(dto);
        return ResponseEntity.ok(cursadaService.create(cursada));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cursada> update(@PathVariable Long id, @RequestBody CursadaRequestDto dto) {
        try {
            Cursada cursada = cursadaService.fromDto(dto);
            return ResponseEntity.ok(cursadaService.update(cursada, id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            cursadaService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
