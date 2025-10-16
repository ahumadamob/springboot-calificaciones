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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
import com.imb2025.calificaciones.dto.DocenteRequestDto;
import com.imb2025.calificaciones.entity.Docente;
import com.imb2025.calificaciones.service.IDocenteService;

import jakarta.validation.Valid;

@RestController

@RequestMapping("/api/docente")
public class DocenteController {

    @Autowired
    private IDocenteService docenteService;

    @GetMapping
    public ResponseEntity<List<Docente>> getAllDocente() {
        List<Docente> docentes = docenteService.findAll();
        return docentes.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(docentes);
    }

    @GetMapping("/{id}")

    public ResponseEntity<ApiResponseSuccessDto<Docente>> obtenerDocentePorId(@PathVariable Long id) {
        Docente docente = docenteService.findById(id);
        ApiResponseSuccessDto<Docente> response = new ApiResponseSuccessDto<>(true,
                "Docente encontrado con éxito", docente);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/apellido/{apellido}")
    public ResponseEntity<ApiResponseSuccessDto<List<Docente>>> getDocentesByApellido(@PathVariable String apellido) {
        List<Docente> docentes = docenteService.findByApellido(apellido);

        ApiResponseSuccessDto<List<Docente>> response = new ApiResponseSuccessDto<>();
        response.setSuccess(true);
        response.setData(docentes);
        response.setMessage("Búsqueda de docentes por apellido realizada con éxito");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/titulo/{titulo}/count")
    public ResponseEntity<ApiResponseSuccessDto<Long>> countDocentesByTitulo(@PathVariable String titulo) {
        long cantidad = docenteService.countByTitulo(titulo);

        ApiResponseSuccessDto<Long> response = new ApiResponseSuccessDto<>();
        response.setSuccess(true);
        response.setData(cantidad);
        response.setMessage("Conteo de docentes por título realizado con éxito");

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponseSuccessDto<Docente>> crear(@Valid @RequestBody DocenteRequestDto dto)
            throws Exception {
        Docente createdDocente = docenteService.create(docenteService.fromDto(dto));
        ApiResponseSuccessDto<Docente> response = new ApiResponseSuccessDto<>(true,
                "Alumno creado con éxito", createdDocente);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocente(@PathVariable("id") Long id) {
        try {
            docenteService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<Docente>> actualizar(@PathVariable Long id,
            @Valid @RequestBody DocenteRequestDto dto) throws Exception {
        Docente updatedDocente = docenteService.update(docenteService.fromDto(dto), id);
        ApiResponseSuccessDto<Docente> response = new ApiResponseSuccessDto<>(true,
                "Docente actualizado con éxito", updatedDocente);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
