package com.imb2025.calificaciones.controller;

import com.imb2025.calificaciones.entity.Asistencia;
import com.imb2025.calificaciones.service.IAsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class AsistenciaController {

    @Autowired
    private IAsistenciaService asistenciaService;

    // GET /asistencia
    @GetMapping("/api/asistencia")
    public List<Asistencia> getAllAsistencia() {
        return asistenciaService.findAll();
    }

    // GET /asistencia/{id}
    @GetMapping("/api/asistencia/{alumnoid}")
    public Asistencia getById(@PathVariable("alumnoid") Long id) {
        return asistenciaService.findById(id);
    }

    // POST /asistencia
    @PostMapping("/api/asistencia")
    public Asistencia createAsistencia(@RequestBody Asistencia asistencia) {
        return asistenciaService.save(asistencia);
    }

    @PutMapping("/api/asistencia/{alumnoid}")
    public ResponseEntity<Asistencia> updateAsistencia(@PathVariable Long id, @RequestBody Asistencia asistencia) {
        Asistencia existente = asistenciaService.findById(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        asistencia.setId(id); // asegurarse que el objeto tenga el id correcto
        Asistencia updated = asistenciaService.save(asistencia);
        return ResponseEntity.ok(updated);
    }

    // DELETE /asistencia/{id}
    @DeleteMapping("/api/asistencia/{alumnoid}")
    public void deleteAsistencia(@PathVariable("alumnoid") Long id) {
    	asistenciaService.deleteById(id);
    }
}
