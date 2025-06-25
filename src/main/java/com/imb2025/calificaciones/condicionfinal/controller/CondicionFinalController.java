package com.imb2025.calificaciones.condicionfinal.controller;

import com.imb2025.calificaciones.condicionfinal.dto.CondicionFinalRequestDTO;
import com.imb2025.calificaciones.condicionfinal.entity.CondicionFinal;
import com.imb2025.calificaciones.condicionfinal.exception.EntidadNoEncontradaException;
import com.imb2025.calificaciones.condicionfinal.service.CondicionFinalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/condicion-final")
public class CondicionFinalController {

    @Autowired
    private CondicionFinalService service;

    @GetMapping
    public ResponseEntity<List<CondicionFinal>> getAll() {
        List<CondicionFinal> lista = service.getAll();
        return lista.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CondicionFinal> getById(@PathVariable Long id) {
        try {
            CondicionFinal cf = service.getById(id);
            return ResponseEntity.ok(cf);
        } catch (EntidadNoEncontradaException ex) {
            return ResponseEntity.noContent().build(); // 204 No Content
        }
    }

    @PostMapping
    public ResponseEntity<CondicionFinal> create(@RequestBody @Valid CondicionFinalRequestDTO dto) {
        CondicionFinal creado = service.create(dto);
        return ResponseEntity.ok(creado); // 200 OK
    }

    @PutMapping("/{id}")
    public ResponseEntity<CondicionFinal> update(@PathVariable Long id, @RequestBody @Valid CondicionFinalRequestDTO dto) {
        try {
            CondicionFinal actualizado = service.update(id, dto);
            return ResponseEntity.ok(actualizado);
        } catch (EntidadNoEncontradaException ex) {
            return ResponseEntity.badRequest().body(null); // 400 Bad Request
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok().build();
        } catch (EntidadNoEncontradaException ex) {
            return ResponseEntity.badRequest().build(); // 400 Bad Request
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
