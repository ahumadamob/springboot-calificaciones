package com.imb2025.calificaciones.controller;

import com.imb2025.calificaciones.DTO.AlumnoRequestDTO;
import com.imb2025.calificaciones.entity.Alumno;
import com.imb2025.calificaciones.service.IAlumnoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private IAlumnoServices alumnoServices;

    @GetMapping
    public List<Alumno> obtenerTodos() {
        return alumnoServices.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> obtenerPorId(@PathVariable Long id) {
        Alumno alumno = alumnoServices.findById(id);
        if (alumno == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(alumno);
    }

    @PostMapping
    public ResponseEntity<Alumno> crear(@RequestBody AlumnoRequestDTO dto) {
        Alumno creado = alumnoServices.saveFromDTO(dto);
        return ResponseEntity.ok(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> actualizar(@PathVariable Long id, @RequestBody AlumnoRequestDTO dto) {
        Alumno actualizado = alumnoServices.updateFromDTO(id, dto);
        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Alumno alumno = alumnoServices.findById(id);
        if (alumno == null) {
            return ResponseEntity.notFound().build();
        }
        alumnoServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}
