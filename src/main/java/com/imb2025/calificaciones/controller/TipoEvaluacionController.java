package com.imb2025.calificaciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        TipoEvaluacion actualizado = tipoEvaluacionService.update(id, tipoEvaluacion);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/tipoEvaluacion/{id}")
    public ResponseEntity<?> deleteTipoEvaluacion(@PathVariable Long id) {
        tipoEvaluacionService.deleteById(id);
        return ResponseEntity.ok("Eliminado correctamente");
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
