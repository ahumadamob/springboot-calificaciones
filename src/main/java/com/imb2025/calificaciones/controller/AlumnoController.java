package com.imb2025.calificaciones.controller;

import com.imb2025.calificaciones.dto.AlumnoRequestDTO;
import com.imb2025.calificaciones.entity.Alumno;
import com.imb2025.calificaciones.service.IAlumnoServices;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Alumno obtenerPorId(@PathVariable Long id) {
        return alumnoServices.findById(id);
    }

    @PostMapping
    public Alumno crear(@RequestBody AlumnoRequestDTO alumnoDto) {
        Alumno alumno = new Alumno();
        try {
            alumno = alumnoServices.mapFromDTO(alumnoDto);
            alumno = alumnoServices.create(alumno);
        } catch (Exception e) {
            throw new RuntimeException("Error al mapear el DTO: " + e.getMessage());
        }
        return alumno;
    }

    @PutMapping("/{id}")
    public Alumno actualizar(@PathVariable Long id, @RequestBody AlumnoRequestDTO alumnoDto) throws Exception {
        Alumno alumno = new Alumno();
        try {
            alumno = alumnoServices.mapFromDTO(alumnoDto);
        } catch (Exception e) {
            throw new RuntimeException("Error al mapear el DTO: " + e.getMessage());
        }
        try {
            alumno = alumnoServices.update(id, alumno);
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar el alumno: " + e.getMessage());
        }
        return alumno;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        alumnoServices.deleteById(id);
    }
}
