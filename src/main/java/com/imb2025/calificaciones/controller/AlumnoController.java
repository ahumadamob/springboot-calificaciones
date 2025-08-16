package com.imb2025.calificaciones.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.imb2025.calificaciones.service.IAlumnoServices;
import com.imb2025.calificaciones.dto.AlumnoRequestDTO;
import com.imb2025.calificaciones.entity.Alumno;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
public class AlumnoController {

    @Autowired
    IAlumnoServices IAlumnoServices;

    @GetMapping("/entidad")
    public ResponseEntity<List<Alumno>> obtenerTodos() {
        List<Alumno> alumnos = IAlumnoServices.findAll();   
        return alumnos.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(alumnos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> obtenerAlumnoPorId(@PathVariable Long id) {
        return IAlumnoServices.existsById(id)
                ? ResponseEntity.ok(IAlumnoServices.findById(id))
                : ResponseEntity.noContent().build();
    }

    @PostMapping("/entidad")
    public ResponseEntity<Alumno> crear(@RequestBody AlumnoRequestDTO nuevoAlumno) throws Exception {
        return ResponseEntity.ok(IAlumnoServices.create(nuevoAlumno));
    }

    @PutMapping("/entidad/{id}")
    public ResponseEntity<Alumno> actualizar(@PathVariable Long id, @RequestBody AlumnoRequestDTO datosActualizados) throws Exception {
        return ResponseEntity.ok(IAlumnoServices.update(id, datosActualizados));
    }

    @DeleteMapping("/entidad/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        IAlumnoServices.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}
