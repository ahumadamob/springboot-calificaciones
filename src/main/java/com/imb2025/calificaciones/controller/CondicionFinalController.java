package com.imb2025.calificaciones.controller;


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

import com.imb2025.calificaciones.dto.CondicionFinalRequestDto;
import com.imb2025.calificaciones.entity.CondicionFinal;
import com.imb2025.calificaciones.service.ICondicionFinalService;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api/condicion-final")
public class CondicionFinalController {

    @Autowired
    private ICondicionFinalService service;

    @GetMapping
    public ResponseEntity<List<CondicionFinal>> getAll() {
        List<CondicionFinal> condiciones = service.findAll();
        return condiciones.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(condiciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CondicionFinal> getById(@PathVariable Long id) {
        CondicionFinal condicion = service.findById(id);
        return condicion == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(condicion);
    }

    @PostMapping
    public ResponseEntity<CondicionFinal> create(@RequestBody CondicionFinalRequestDto dto) throws Exception {
        CondicionFinal condicion = service.fromDto(dto);
        return ResponseEntity.ok(service.create(condicion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CondicionFinal> update(@PathVariable Long id, @RequestBody CondicionFinalRequestDto dto) throws Exception {
        CondicionFinal existente = service.findById(id);
        if (existente == null) {
            return ResponseEntity.badRequest().build();
        }
        CondicionFinal condicion = service.fromDto(dto);
        return ResponseEntity.ok(service.update(condicion, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            service.deleteById(id);
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
