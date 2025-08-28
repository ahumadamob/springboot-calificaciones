package com.imb2025.calificaciones.controller;


import org.springframework.http.HttpStatus;
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
import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
import com.imb2025.calificaciones.entity.Alumno;
import com.imb2025.calificaciones.entity.PeriodoLectivo;

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

    @GetMapping("/alumno/{id}")
    public ResponseEntity<ApiResponseSuccessDto<Alumno>> obtenerAlumnoPorId(@PathVariable Long id) {
        Alumno alumno = alumnoService.findById(id);
        ApiResponseSuccessDto<Alumno> response = new ApiResponseSuccessDto<Alumno>(true,
                "Alumno encontrado con éxito", alumno);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/alumno")
    public ResponseEntity<ApiResponseSuccessDto<Alumno>> crear(@RequestBody AlumnoRequestDto dto) throws Exception {
    	Alumno createdAlumno = alumnoService.create(
                alumnoService.fromDto(dto));
            ApiResponseSuccessDto<Alumno> response = new ApiResponseSuccessDto<Alumno>(true,
                "Alumno creado con éxito", createdAlumno);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/alumno/{id}")
    public ResponseEntity<ApiResponseSuccessDto<Alumno>> actualizar(@PathVariable Long id, @RequestBody AlumnoRequestDto dto) throws Exception {
         Alumno updatedAlumno = alumnoService.update(
                alumnoService.fromDto(dto),
                id);
    	 ApiResponseSuccessDto<Alumno> response = new ApiResponseSuccessDto<Alumno>(true,
                 "Alumno actualizado con éxito", updatedAlumno);
         return ResponseEntity.status(HttpStatus.CREATED).body(response);
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
