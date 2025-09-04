package com.imb2025.calificaciones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
import com.imb2025.calificaciones.dto.CondicionFinalRequestDto;
import com.imb2025.calificaciones.entity.CondicionFinal;
import com.imb2025.calificaciones.service.ICondicionFinalService;

import java.util.List;

@RestController
@RequestMapping("/api/condicionFinal")
public class CondicionFinalController {

    @Autowired
    private ICondicionFinalService service;

    @GetMapping
    public ResponseEntity<ApiResponseSuccessDto<List<CondicionFinal>>> getAll() {
        List<CondicionFinal> condiciones = service.findAll();

        if (condiciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        ApiResponseSuccessDto<List<CondicionFinal>> response = new ApiResponseSuccessDto<>();
        response.setSuccess(true);
        response.setMessage("Condiciones finales encontradas con éxito");
        response.setData(condiciones);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<CondicionFinal>> getById(@PathVariable Long id) {
        CondicionFinal condicion = service.findById(id);

        if (condicion == null) {
            return ResponseEntity.noContent().build();
        }

        ApiResponseSuccessDto<CondicionFinal> response = new ApiResponseSuccessDto<>();
        response.setSuccess(true);
        response.setMessage("Condición final encontrada con éxito");
        response.setData(condicion);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/crear")
    public ResponseEntity<ApiResponseSuccessDto<CondicionFinal>> create(@RequestBody CondicionFinalRequestDto dto) throws Exception {
        CondicionFinal condicion = service.fromDto(dto);
        condicion = service.create(condicion);

        ApiResponseSuccessDto<CondicionFinal> response = new ApiResponseSuccessDto<>();
        response.setSuccess(true);
        response.setMessage("Condición final creada con éxito");
        response.setData(condicion);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<CondicionFinal>> update(@PathVariable Long id, @RequestBody CondicionFinalRequestDto dto) throws Exception {
        CondicionFinal existente = service.findById(id);
        if (existente == null) {
            return ResponseEntity.badRequest().build();
        }

        CondicionFinal condicion = service.fromDto(dto);
        condicion = service.update(condicion, id);

        ApiResponseSuccessDto<CondicionFinal> response = new ApiResponseSuccessDto<>();
        response.setSuccess(true);
        response.setMessage("Condición final actualizada con éxito");
        response.setData(condicion);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<Void>> delete(@PathVariable Long id) throws Exception {
        service.deleteById(id);

        ApiResponseSuccessDto<Void> response = new ApiResponseSuccessDto<>();
        response.setSuccess(true);
        response.setMessage("La condición final con id " + id + " fue eliminada con éxito");
        response.setData(null);

        return ResponseEntity.ok(response);
    }
}

