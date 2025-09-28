package com.imb2025.calificaciones.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.imb2025.calificaciones.dto.ApiResponseErrorDto;
import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
import com.imb2025.calificaciones.dto.EstadoEvaluacionRequestDto;
import com.imb2025.calificaciones.dto.FieldErrorDto;
import com.imb2025.calificaciones.entity.EstadoEvaluacion;
import com.imb2025.calificaciones.service.IEstadoEvaluacionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/estadoevaluacion")
public class EstadoEvaluacionController {

    @Autowired
    private IEstadoEvaluacionService service;

    @GetMapping
    public ResponseEntity<ApiResponseSuccessDto<List<EstadoEvaluacion>>> getAll() {
        List<EstadoEvaluacion> estados = service.findAll();
        ApiResponseSuccessDto<List<EstadoEvaluacion>> response = new ApiResponseSuccessDto<>();
        response.setSuccess(true);
        response.setData(estados);
        response.setMessage(estados.isEmpty() ? "No hay registros" : "Lista de estados encontrada exitosamente");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<EstadoEvaluacion>> getById(@PathVariable Long id) {
        EstadoEvaluacion estado = service.findById(id);
        ApiResponseSuccessDto<EstadoEvaluacion> response = new ApiResponseSuccessDto<>();
        response.setSuccess(true);
        response.setData(estado);
        response.setMessage("EstadoEvaluacion encontrada exitosamente");
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponseSuccessDto<EstadoEvaluacion>> create(@Valid @RequestBody EstadoEvaluacionRequestDto estadoEvaluacion) throws Exception {
        EstadoEvaluacion creado = service.create(service.fromDto(estadoEvaluacion));
        ApiResponseSuccessDto<EstadoEvaluacion> response = new ApiResponseSuccessDto<>();
        response.setSuccess(true);
        response.setData(creado);
        response.setMessage("EstadoEvaluacion creada exitosamente");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<EstadoEvaluacion>> update(@PathVariable Long id, @Valid @RequestBody EstadoEvaluacionRequestDto estadoEvaluacion) throws Exception {
        EstadoEvaluacion actualizado = service.update(service.fromDto(estadoEvaluacion), id);
        ApiResponseSuccessDto<EstadoEvaluacion> response = new ApiResponseSuccessDto<>();
        response.setSuccess(true);
        response.setData(actualizado);
        response.setMessage("EstadoEvaluacion actualizada exitosamente");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<Void>> delete(@PathVariable Long id) throws Exception {
        service.deleteById(id);
        ApiResponseSuccessDto<Void> response = new ApiResponseSuccessDto<>();
        response.setSuccess(true);
        response.setData(null);
        response.setMessage("EstadoEvaluacion eliminada exitosamente");
        return ResponseEntity.ok(response);
    }



}
