package com.imb2025.calificaciones.controller;


import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.imb2025.calificaciones.dto.*;
import com.imb2025.calificaciones.entity.RegistroClase;
import com.imb2025.calificaciones.service.IRegistroClaseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/registro")
@Validated
public class RegistroClaseController {

    private final IRegistroClaseService iregistroClase;

    public RegistroClaseController(IRegistroClaseService iregistroClase) {
        this.iregistroClase = iregistroClase;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<RegistroClase> registros = iregistroClase.findAll();
        if (registros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        ApiResponseSuccessDto<List<RegistroClase>> resp =
                new ApiResponseSuccessDto<>(true, "Listado de registros obtenido con éxito", registros);
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<RegistroClase>> getById(@PathVariable Long id) {
        RegistroClase registro = iregistroClase.findById(id);
        if (registro == null) {
            ApiResponseSuccessDto<RegistroClase> resp =
                    new ApiResponseSuccessDto<>(false, "Registro no encontrado", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp);
        }

        ApiResponseSuccessDto<RegistroClase> resp =
                new ApiResponseSuccessDto<>(true, "Registro encontrado", registro);
        return ResponseEntity.ok(resp);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody RegistroClaseRequestDto dto) {
        RegistroClase registro = iregistroClase.fromDto(dto);
        RegistroClase creado = iregistroClase.create(registro);
        ApiResponseSuccessDto<RegistroClase> resp =
                new ApiResponseSuccessDto<>(true, "Registro creado con éxito", creado);
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody RegistroClaseRequestDto dto) {
        RegistroClase registro = iregistroClase.fromDto(dto);
        RegistroClase actualizado = iregistroClase.update(registro, id);
        ApiResponseSuccessDto<RegistroClase> resp =
                new ApiResponseSuccessDto<>(true, "Registro actualizado con éxito", actualizado);
        return ResponseEntity.ok(resp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        iregistroClase.deleteById(id);
        ApiResponseSuccessDto<Void> resp =
                new ApiResponseSuccessDto<>(true, "Registro eliminado con éxito", null);
        return ResponseEntity.ok(resp);
    }
}
