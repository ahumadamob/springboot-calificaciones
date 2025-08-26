package com.imb2025.calificaciones.condicionfinal.controller;

import com.imb2025.calificaciones.condicionfinal.dto.CondicionFinalRequestDTO;
import com.imb2025.calificaciones.condicionfinal.dto.ApiResponseDTO;
import com.imb2025.calificaciones.condicionfinal.entity.CondicionFinal;
import com.imb2025.calificaciones.condicionfinal.service.CondicionFinalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/condicion-final")
public class CondicionFinalController {

    @Autowired
    private CondicionFinalService service;

    @GetMapping
    public ResponseEntity<ApiResponseDTO<List<CondicionFinal>>> getAll() {
        List<CondicionFinal> lista = service.getAll();
        ApiResponseDTO<List<CondicionFinal>> resp = new ApiResponseDTO<>(
                true,
                lista,
                lista.isEmpty() ? "No hay registros de condiciones finales" : "Lista de condiciones finales obtenida con éxito"
        );
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<CondicionFinal>> getById(@PathVariable Long id) {
        CondicionFinal cf = service.getById(id); // lanza ResourceNotFoundException si no existe
        ApiResponseDTO<CondicionFinal> resp = new ApiResponseDTO<>(
                true,
                cf,
                "Condición final encontrada con ID: " + id
        );
        return ResponseEntity.ok(resp);
    }

    @PostMapping
    public ResponseEntity<ApiResponseDTO<CondicionFinal>> create(@RequestBody @Valid CondicionFinalRequestDTO dto) {
        CondicionFinal creado = service.create(dto);
        ApiResponseDTO<CondicionFinal> resp = new ApiResponseDTO<>(
                true,
                creado,
                "Condición final creada correctamente"
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<CondicionFinal>> update(@PathVariable Long id,
                                                                 @RequestBody @Valid CondicionFinalRequestDTO dto) {
        CondicionFinal actualizado = service.update(id, dto);
        ApiResponseDTO<CondicionFinal> resp = new ApiResponseDTO<>(
                true,
                actualizado,
                "Condición final actualizada con éxito"
        );
        return ResponseEntity.ok(resp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<Void>> delete(@PathVariable Long id) {
        service.delete(id);
        ApiResponseDTO<Void> resp = new ApiResponseDTO<>(
                true,
                null,
                "Condición final eliminada con éxito"
        );
        return ResponseEntity.ok(resp);
    }
}
