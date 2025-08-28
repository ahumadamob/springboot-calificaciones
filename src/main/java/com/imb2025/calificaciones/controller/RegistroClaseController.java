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
    public ResponseEntity<ApiResponseSuccessDto<List<RegistroClase>>> findAll() {
        List<RegistroClase> registros = iregistroClase.findAll();
        ApiResponseSuccessDto<List<RegistroClase>> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(registros);
        resp.setMessage(registros.isEmpty() ? "No hay registros" : "Registros obtenidos correctamente");
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        RegistroClase registro = iregistroClase.findById(id);
        if (registro == null) {
            ApiResponseErrorDto resp = new ApiResponseErrorDto();
            resp.setSuccess(false);
            resp.setErrors(Collections.singletonList(new FieldErrorDto("id", "Registro no encontrado")));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp);
        } else {
            ApiResponseSuccessDto<RegistroClase> resp = new ApiResponseSuccessDto<>();
            resp.setSuccess(true);
            resp.setData(registro);
            resp.setMessage("Registro obtenido correctamente");
            return ResponseEntity.ok(resp);
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponseSuccessDto<RegistroClase>> create(@RequestBody RegistroClaseRequestDto dto) throws Exception {
        RegistroClase registro = iregistroClase.fromDto(dto);
        RegistroClase creado = iregistroClase.create(registro);

        ApiResponseSuccessDto<RegistroClase> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(creado);
        resp.setMessage("Registro creado correctamente");

        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody RegistroClaseRequestDto dto) {
        try {
            RegistroClase registro = iregistroClase.fromDto(dto);
            RegistroClase actualizado = iregistroClase.update(registro, id);

            ApiResponseSuccessDto<RegistroClase> resp = new ApiResponseSuccessDto<>();
            resp.setSuccess(true);
            resp.setData(actualizado);
            resp.setMessage("Registro actualizado correctamente");

            return ResponseEntity.ok(resp);
        } catch (Exception e) {
            ApiResponseErrorDto resp = new ApiResponseErrorDto();
            resp.setSuccess(false);
            resp.setErrors(Collections.singletonList(new FieldErrorDto("id", "Error al actualizar registro: " + e.getMessage())));
            return ResponseEntity.badRequest().body(resp);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            iregistroClase.deleteById(id);
            ApiResponseSuccessDto<Void> resp = new ApiResponseSuccessDto<>();
            resp.setSuccess(true);
            resp.setMessage("Registro eliminado correctamente");
            return ResponseEntity.ok(resp);
        } catch (Exception e) {
            ApiResponseErrorDto resp = new ApiResponseErrorDto();
            resp.setSuccess(false);
            resp.setErrors(Collections.singletonList(new FieldErrorDto("id", "Error al eliminar registro: " + e.getMessage())));
            return ResponseEntity.badRequest().body(resp);
        }
    }
}
