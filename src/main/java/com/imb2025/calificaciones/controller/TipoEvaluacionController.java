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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.imb2025.calificaciones.entity.TipoEvaluacion;
import com.imb2025.calificaciones.service.ITipoEvaluacionService;

@RestController
@RequestMapping("/api")
public class TipoEvaluacionController {

    @Autowired
    private ITipoEvaluacionService tipoEvaluacionService;

    @GetMapping("/tipoEvaluacion")
    public ResponseEntity<?> getTodosTipoEvaluacion() {
        List<TipoEvaluacion> lista = tipoEvaluacionService.findAll();
        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/tipoEvaluacion/{id}")
    public ResponseEntity<?> getTipoEvaluacionById(@PathVariable Long id) {
        TipoEvaluacion tipo = tipoEvaluacionService.findById(id);
        return ResponseEntity.ok(tipo);
    }

    @PostMapping("/tipoEvaluacion")
    public ResponseEntity<?> createTipoEvaluacion(@RequestBody TipoEvaluacion tipoEvaluacion) {
        TipoEvaluacion creado = tipoEvaluacionService.create(tipoEvaluacion);
        return ResponseEntity.ok(creado);
    }

    @PutMapping("/tipoEvaluacion/{id}")
    public ResponseEntity<?> updateTipoEvaluacion(@PathVariable Long id, @RequestBody TipoEvaluacion tipoEvaluacion) {
        try {
            TipoEvaluacion actualizado = tipoEvaluacionService.update(tipoEvaluacion, id);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/tipoEvaluacion/{id}")
    public ResponseEntity<?> deleteTipoEvaluacion(@PathVariable Long id) {
        try {
            tipoEvaluacionService.deleteById(id);
            return ResponseEntity.ok("Eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
