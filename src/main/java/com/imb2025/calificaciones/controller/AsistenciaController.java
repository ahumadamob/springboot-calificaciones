package com.imb2025.calificaciones.controller;


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

import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
import com.imb2025.calificaciones.dto.AsistenciaRequestDto;
import com.imb2025.calificaciones.entity.Asistencia;
import com.imb2025.calificaciones.service.IAsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api/asistencia")
public class AsistenciaController {

    @Autowired
    private IAsistenciaService asistenciaService;

    // GET - listar todas las asistencias
    @GetMapping
    public ResponseEntity<ApiResponseSuccessDto<List<Asistencia>>> getAll() {
        List<Asistencia> asistencias = asistenciaService.findAll();
        ApiResponseSuccessDto<List<Asistencia>> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(asistencias);
        resp.setMessage(asistencias.isEmpty() ? "No se encontraron asistencias" : "Listado de asistencias obtenido correctamente");
        return ResponseEntity.ok(resp);
    }

    // GET - buscar una asistencia por ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<Asistencia>> getById(@PathVariable Long id) {
        Asistencia asistencia = asistenciaService.findById(id);
        ApiResponseSuccessDto<Asistencia> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(asistencia);
        resp.setMessage("Asistencia encontrada correctamente");
        return ResponseEntity.ok(resp);
    }

    // POST - crear nueva asistencia
    @PostMapping
    public ResponseEntity<ApiResponseSuccessDto<Asistencia>> create(@RequestBody AsistenciaRequestDto dto) throws Exception {
        Asistencia nueva = asistenciaService.create(dto);
        ApiResponseSuccessDto<Asistencia> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(nueva);
        resp.setMessage("Asistencia creada correctamente");
        return ResponseEntity.status(201).body(resp);
    }

    // PUT - actualizar asistencia existente
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<Asistencia>> update(@PathVariable Long id, @RequestBody AsistenciaRequestDto dto) throws Exception {
        if (!asistenciaService.existsById(id)) {
            return ResponseEntity.badRequest().build();
        }
        Asistencia actualizada = asistenciaService.update(dto, id);
        ApiResponseSuccessDto<Asistencia> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(actualizada);
        resp.setMessage("Asistencia actualizada correctamente");
        return ResponseEntity.ok(resp);
    }

    // DELETE - eliminar una asistencia
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<Void>> delete(@PathVariable Long id) throws Exception {
        if (!asistenciaService.existsById(id)) {
            return ResponseEntity.badRequest().build();
        }
        asistenciaService.deleteById(id);
        ApiResponseSuccessDto<Void> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(null);
        resp.setMessage("Asistencia eliminada correctamente");
        return ResponseEntity.ok(resp);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}

