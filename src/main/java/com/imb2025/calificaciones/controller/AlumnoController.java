package com.imb2025.calificaciones.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.imb2025.calificaciones.service.IAlumnoService;
import com.imb2025.calificaciones.dto.AlumnoRequestDto;
import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
import com.imb2025.calificaciones.entity.Alumno;

import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    private IAlumnoService alumnoService;

    @GetMapping
    public ResponseEntity<List<Alumno>> obtenerTodos() {
        List<Alumno> alumnos = alumnoService.findAll();
        return alumnos.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(alumnos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<Alumno>> obtenerAlumnoPorId(@PathVariable Long id) {
        Alumno alumno = alumnoService.findById(id);
        ApiResponseSuccessDto<Alumno> response = new ApiResponseSuccessDto<>(true,
                "Alumno encontrado con éxito", alumno);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponseSuccessDto<Alumno>> crear(@Valid @RequestBody AlumnoRequestDto dto)
            throws Exception {
        Alumno createdAlumno = alumnoService.create(alumnoService.fromDto(dto));
        ApiResponseSuccessDto<Alumno> response = new ApiResponseSuccessDto<>(true,
                "Alumno creado con éxito", createdAlumno);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<Alumno>> actualizar(@PathVariable Long id,
            @Valid @RequestBody AlumnoRequestDto dto) throws Exception {
        Alumno updatedAlumno = alumnoService.update(alumnoService.fromDto(dto), id);
        ApiResponseSuccessDto<Alumno> response = new ApiResponseSuccessDto<>(true,
                "Alumno actualizado con éxito", updatedAlumno);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}