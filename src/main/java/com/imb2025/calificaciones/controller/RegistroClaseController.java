package com.imb2025.calificaciones.controller;

import java.util.Collections;
import java.util.List;

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

import com.imb2025.calificaciones.dto.ApiResponseErrorDto;
import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
import com.imb2025.calificaciones.dto.FieldErrorDto;
import com.imb2025.calificaciones.dto.RegistroClaseRequestDto;
import com.imb2025.calificaciones.entity.RegistroClase;
import com.imb2025.calificaciones.service.IRegistroClaseService;

@RestController
@RequestMapping("/registro")
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
    public ResponseEntity<?> getById(@PathVariable Long id) {
        RegistroClase registro = iregistroClase.findById(id);
        if (registro == null) {
            ApiResponseErrorDto error =
                    new ApiResponseErrorDto(false, Collections.singletonList(
                            new FieldErrorDto("id", "Registro no encontrado")
                    ));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
        ApiResponseSuccessDto<RegistroClase> resp =
                new ApiResponseSuccessDto<>(true, "Registro encontrado", registro);
        return ResponseEntity.ok(resp);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody RegistroClaseRequestDto dto) {
        try {
            RegistroClase registro = iregistroClase.fromDto(dto);
            RegistroClase creado = iregistroClase.create(registro);
            ApiResponseSuccessDto<RegistroClase> resp =
                    new ApiResponseSuccessDto<>(true, "Registro creado con éxito", creado);
            return ResponseEntity.status(HttpStatus.CREATED).body(resp);
        } catch (Exception e) {
            ApiResponseErrorDto error =
                    new ApiResponseErrorDto(false, Collections.singletonList(
                            new FieldErrorDto("registro", "Error al crear el registro: " + e.getMessage())
                    ));
            return ResponseEntity.badRequest().body(error);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody RegistroClaseRequestDto dto) {
        try {
            RegistroClase registro = iregistroClase.fromDto(dto);
            RegistroClase actualizado = iregistroClase.update(registro, id);
            ApiResponseSuccessDto<RegistroClase> resp =
                    new ApiResponseSuccessDto<>(true, "Registro actualizado con éxito", actualizado);
            return ResponseEntity.ok(resp);
        } catch (Exception e) {
            ApiResponseErrorDto error =
                    new ApiResponseErrorDto(false, Collections.singletonList(
                            new FieldErrorDto("registro", "Error al actualizar el registro: " + e.getMessage())
                    ));
            return ResponseEntity.badRequest().body(error);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            iregistroClase.deleteById(id);
            ApiResponseSuccessDto<Void> resp =
                    new ApiResponseSuccessDto<>(true, "Registro eliminado con éxito", null);
            return ResponseEntity.ok(resp);
        } catch (Exception e) {
            ApiResponseErrorDto error =
                    new ApiResponseErrorDto(false, Collections.singletonList(
                            new FieldErrorDto("id", "Error al eliminar el registro: " + e.getMessage())
                    ));
            return ResponseEntity.badRequest().body(error);
        }
    }
}
