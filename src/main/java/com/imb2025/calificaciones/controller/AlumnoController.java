package com.imb2025.calificaciones.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.imb2025.calificaciones.service.IAlumnoService;

import io.swagger.v3.oas.annotations.Operation;

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
    
    @GetMapping("/buscar/{apellido}")
    public ResponseEntity<ApiResponseSuccessDto<List<Alumno>>> findByApellido(@PathVariable String apellido) {
        List<Alumno> alumnos = alumnoService.findByApellido(apellido);
        ApiResponseSuccessDto<List<Alumno>> response = new ApiResponseSuccessDto<>(
                true,
                "Alumnos encontrados con apellido: " + apellido,
                alumnos
        );
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/contar/{email}")
    public ResponseEntity<ApiResponseSuccessDto<Long>> contarPorEmail(@PathVariable String email) {
    // La lógica de servicio es la misma
    long count = alumnoService.countByEmail(email);
    
    // Preparación de la respuesta
    String message = String.format("Se encontraron %d alumnos con el email: %s", count, email);
    
    ApiResponseSuccessDto<Long> response = new ApiResponseSuccessDto<>(
            true,
            message,
            count
    );
    
    return ResponseEntity.ok(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}