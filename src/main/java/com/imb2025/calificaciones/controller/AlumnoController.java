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

import com.imb2025.calificaciones.service.IAlumnoService;
import com.imb2025.calificaciones.dto.AlumnoRequestDto;
import com.imb2025.calificaciones.entity.Alumno;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
public class AlumnoController {

    @Autowired
    IAlumnoService alumnoService;

    @GetMapping("/alumno")
    public ResponseEntity<List<Alumno>> obtenerTodos() {
        List<Alumno> alumnos = alumnoService.findAll();   
        return alumnos.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(alumnos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> obtenerAlumnoPorId(@PathVariable Long id) {
        return alumnoService.existsById(id)
                ? ResponseEntity.ok(alumnoService.findById(id))
                : ResponseEntity.noContent().build();
    }

    @PostMapping("/alumno")
    public ResponseEntity<Alumno> crear(@RequestBody AlumnoRequestDto dto) throws Exception {
    	Alumno alumno = new Alumno();
        alumno = alumnoService.fromDto(dto);
    	return ResponseEntity.ok(alumnoService.create(alumno));
    }

    @PutMapping("/alumno/{id}")
    public ResponseEntity<Alumno> actualizar(@PathVariable Long id, @RequestBody AlumnoRequestDto dto) throws Exception {
        if(alumnoService.existsById(id)) {
        	Alumno alumno = new Alumno();
            alumno = alumnoService.fromDto(dto);
        	return ResponseEntity.ok(alumnoService.update(alumno, id));
        }else {
        	return ResponseEntity.badRequest().body(null);
        }
    	
    }

    @DeleteMapping("/alumno/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        try {
			alumnoService.deleteById(id);
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
