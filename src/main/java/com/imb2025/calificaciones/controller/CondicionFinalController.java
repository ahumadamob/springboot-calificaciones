package com.imb2025.calificaciones.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

import com.imb2025.calificaciones.dto.request.CondicionFinalRequestDto;
import com.imb2025.calificaciones.dto.response.CondicionFinalResponseDto;
import com.imb2025.calificaciones.dto.mapper.CondicionFinalMapper;
import com.imb2025.calificaciones.entity.CondicionFinal;
import com.imb2025.calificaciones.service.ICondicionFinalService;

@RestController
@RequestMapping("/api/condicion-final")
public class CondicionFinalController {

    @Autowired
    private ICondicionFinalService service;

    @Autowired
    private CondicionFinalMapper mapper;

    @GetMapping
    public ResponseEntity<List<CondicionFinalResponseDto>> getAll() {
        List<CondicionFinal> condiciones = service.findAll();
        if (condiciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<CondicionFinalResponseDto> respuesta = condiciones.stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CondicionFinalResponseDto> getById(@PathVariable Long id) {
        CondicionFinal condicion = service.findById(id);
        return condicion == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(mapper.toResponse(condicion));
    }

    @PostMapping
    public ResponseEntity<CondicionFinalResponseDto> create(@RequestBody CondicionFinalRequestDto dto) {
        CondicionFinal condicion = mapper.fromDto(dto);
        CondicionFinal guardada = service.create(condicion);
        return ResponseEntity.ok(mapper.toResponse(guardada));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CondicionFinalResponseDto> update(@PathVariable Long id, @RequestBody CondicionFinalRequestDto dto) throws Exception {
        CondicionFinal existente = service.findById(id);
        if (existente == null) {
            return ResponseEntity.badRequest().build();
        }
        CondicionFinal condicion = mapper.fromDto(dto);
        CondicionFinal actualizada = service.update(condicion, id);
        return ResponseEntity.ok(mapper.toResponse(actualizada));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            service.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<CondicionFinalResponseDto>> getByNombre(@PathVariable String nombre) {
        List<CondicionFinal> lista = service.findByNombre(nombre);
        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<CondicionFinalResponseDto> respuesta = lista.stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/count/{nombre}")
    public ResponseEntity<Long> countByNombre(@PathVariable String nombre) {
        Long cantidad = service.countByNombre(nombre);
        return ResponseEntity.ok(cantidad);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}

