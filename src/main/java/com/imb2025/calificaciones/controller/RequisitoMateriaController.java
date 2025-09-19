package com.imb2025.calificaciones.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imb2025.calificaciones.dto.RequisitoMateriaRequestDto;
import com.imb2025.calificaciones.entity.RequisitoMateria;
import com.imb2025.calificaciones.service.IRequisitoMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/requisito-materia")
public class RequisitoMateriaController {

    @Autowired
    private IRequisitoMateriaService service;

    @GetMapping
    public List<RequisitoMateria> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<RequisitoMateria>> getById(@PathVariable Long id) {
        RequisitoMateria requisito = service.findById(id);

        ApiResponseSuccessDto<RequisitoMateria> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(requisito);
        resp.setMessage("RequisitoMateria encontrada correctamente");

        return ResponseEntity.ok(resp);
    }

    @PostMapping
    public ResponseEntity<ApiResponseSuccessDto<RequisitoMateria>> create(@RequestBody @Valid RequisitoMateriaRequestDto dto) {
        try {
            RequisitoMateria nuevo = service.create(service.fromDto(dto));

            ApiResponseSuccessDto<RequisitoMateria> resp = new ApiResponseSuccessDto<>();
            resp.setSuccess(true);
            resp.setData(nuevo);
            resp.setMessage("RequisitoMateria creada exitosamente");

            return ResponseEntity.status(HttpStatus.CREATED).body(resp);
        } catch (Exception e) {
            ApiResponseSuccessDto<RequisitoMateria> errorResp = new ApiResponseSuccessDto<>();
            errorResp.setSuccess(false);
            errorResp.setMessage("Error al crear requisito: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResp);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<RequisitoMateria>> update(@PathVariable Long id, @RequestBody @Valid RequisitoMateriaRequestDto dto) {
        RequisitoMateria existente = service.findById(id);
        if (existente == null) {
            ApiResponseSuccessDto<RequisitoMateria> notFoundResp = new ApiResponseSuccessDto<>();
            notFoundResp.setSuccess(false);
            notFoundResp.setMessage("No se encontró un requisito con el ID " + id + " para actualizar.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundResp);
        }

        try {
            RequisitoMateria actualizado = service.update(service.fromDto(dto), id);

            ApiResponseSuccessDto<RequisitoMateria> resp = new ApiResponseSuccessDto<>();
            resp.setSuccess(true);
            resp.setData(actualizado);
            resp.setMessage("RequisitoMateria actualizada correctamente");

            return ResponseEntity.ok(resp);
        } catch (Exception e) {
            ApiResponseSuccessDto<RequisitoMateria> errorResp = new ApiResponseSuccessDto<>();
            errorResp.setSuccess(false);
            errorResp.setMessage("Error al actualizar: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResp);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<String>> delete(@PathVariable Long id) {
        RequisitoMateria existente = service.findById(id);
        if (existente == null) {
            ApiResponseSuccessDto<String> notFoundResp = new ApiResponseSuccessDto<>();
            notFoundResp.setSuccess(false);
            notFoundResp.setMessage("No se encontró el requisito con ID " + id + " para eliminar.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundResp);
        }

        try {
            service.deleteById(id);

            ApiResponseSuccessDto<String> resp = new ApiResponseSuccessDto<>();
            resp.setSuccess(true);
            resp.setData("Requisito eliminado correctamente");
            resp.setMessage("Eliminación exitosa");

            return ResponseEntity.ok(resp);
        } catch (Exception e) {
            ApiResponseSuccessDto<String> errorResp = new ApiResponseSuccessDto<>();
            errorResp.setSuccess(false);
            errorResp.setMessage("Error al eliminar: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResp);
        }
    }
}
