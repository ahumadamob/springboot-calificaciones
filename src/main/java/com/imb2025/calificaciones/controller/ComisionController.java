package com.imb2025.calificaciones.controller;


import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
import com.imb2025.calificaciones.dto.ComisionRequestDto;
import com.imb2025.calificaciones.entity.Comision;
import com.imb2025.calificaciones.service.IComisionService;

@RestController
@RequestMapping("/api/comision")
public class ComisionController {

    @Autowired
    private IComisionService service;

    @GetMapping
    public ResponseEntity<ApiResponseSuccessDto<List<Comision>>> getAll() {
        List<Comision> list = service.findAll();
        ApiResponseSuccessDto<List<Comision>> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(list);
        resp.setMessage("Comisiones encontradas con éxito");
        return list.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(resp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<Comision>> getById(@PathVariable Long id) {
        Comision c = service.findById(id);
        ApiResponseSuccessDto<Comision> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(c);
        resp.setMessage("Comision encontrada con éxito");
        return ResponseEntity.ok(resp);
    }

    @PostMapping
    public ResponseEntity<ApiResponseSuccessDto<Comision>> create(@Valid @RequestBody ComisionRequestDto dto) throws Exception {
        Comision c = service.fromDto(dto);
        c = service.create(c);
        ApiResponseSuccessDto<Comision> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(c);
        resp.setMessage("Comision creada con éxito");
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<Comision>> update(@PathVariable Long id, @Valid @RequestBody ComisionRequestDto dto) throws Exception {
        if (!service.existsById(id)) {
            ApiResponseSuccessDto<Comision> notFound = new ApiResponseSuccessDto<>();
            notFound.setSuccess(false);
            notFound.setMessage("No se encontró Comision con id " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFound);
        }
        Comision c = service.fromDto(dto);
        c = service.update(c, id);
        ApiResponseSuccessDto<Comision> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(c);
        resp.setMessage("Comision actualizada con éxito");
        return ResponseEntity.ok(resp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<Void>> delete(@PathVariable Long id) throws Exception {
        service.deleteById(id);
        ApiResponseSuccessDto<Void> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(null);
        resp.setMessage("Comision con id " + id + " eliminada con éxito");
        return ResponseEntity.ok(resp);
    }

    // Eliminado el manejador local de excepciones para que GlobalExceptionHandler procese
    // los errores de validación y devuelva ApiResponseErrorDto con la lista completa.
}
    

