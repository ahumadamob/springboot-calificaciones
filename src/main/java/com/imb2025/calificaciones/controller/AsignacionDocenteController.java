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

import com.imb2025.calificaciones.dto.AsignacionDocenteRequestDto;
import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
import com.imb2025.calificaciones.dto.ApiResponseErrorDto;
import com.imb2025.calificaciones.entity.AsignacionDocente;
import com.imb2025.calificaciones.service.IAsignacionDocenteService;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("api/v1/asignacion-docente")
public class AsignacionDocenteController {

    @Autowired
    private IAsignacionDocenteService service;

    @GetMapping
    public ResponseEntity<ApiResponseSuccessDto<List<AsignacionDocente>>> getAll() {
        List<AsignacionDocente> asignaciones = service.findAll();
        ApiResponseSuccessDto<List<AsignacionDocente>> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(asignaciones);
        resp.setMessage(asignaciones.isEmpty() ? "No se encontraron asignaciones docentes" : "Asignaciones docentes obtenidas exitosamente");
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<AsignacionDocente>> getById(@PathVariable Long id) throws Exception {
        AsignacionDocente asignacionDocente = service.findById(id);
        ApiResponseSuccessDto<AsignacionDocente> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(asignacionDocente);
        resp.setMessage("Asignación docente obtenida exitosamente");
        return ResponseEntity.ok(resp);
    }

    @PostMapping
    public ResponseEntity<ApiResponseSuccessDto<AsignacionDocente>> create(@RequestBody AsignacionDocenteRequestDto dto) throws Exception {
        AsignacionDocente asignacion = service.fromDto(dto);
        AsignacionDocente createdAsignacion = service.create(asignacion);
        ApiResponseSuccessDto<AsignacionDocente> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(createdAsignacion);
        resp.setMessage("Asignación docente creada exitosamente");
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<AsignacionDocente>> update(@PathVariable Long id,
            @RequestBody AsignacionDocenteRequestDto dto) throws Exception {
        AsignacionDocente asignacion = service.fromDto(dto);
        AsignacionDocente updatedAsignacion = service.update(asignacion, id);
        ApiResponseSuccessDto<AsignacionDocente> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(updatedAsignacion);
        resp.setMessage("Asignación docente actualizada exitosamente");
        return ResponseEntity.ok(resp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<Void>> deleteById(@PathVariable Long id) throws Exception {
        service.deleteById(id);
        ApiResponseSuccessDto<Void> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(null);
        resp.setMessage("Asignación docente eliminada exitosamente");
        return ResponseEntity.ok(resp);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponseErrorDto> handleException(Exception e) {
        ApiResponseErrorDto errorResp = new ApiResponseErrorDto();
        errorResp.setSuccess(false);
        errorResp.setErrors(List.of(new com.imb2025.calificaciones.dto.FieldErrorDto("general", e.getMessage())));
        return ResponseEntity.badRequest().body(errorResp);
    }

}
