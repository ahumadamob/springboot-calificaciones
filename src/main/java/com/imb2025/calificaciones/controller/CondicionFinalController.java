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

// Importar la anotación @Valid
import jakarta.validation.Valid; // <--- ¡NUEVO IMPORT!

import com.imb2025.calificaciones.dto.request.CondicionFinalRequestDto; 
import com.imb2025.calificaciones.dto.response.CondicionFinalResponseDto; 
import com.imb2025.calificaciones.entity.CondicionFinal;
import com.imb2025.calificaciones.service.ICondicionFinalService;
import com.imb2025.calificaciones.mapper.CondicionFinalMapper; 

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors; 

@RestController
@RequestMapping("/api/condicion-final")
public class CondicionFinalController {

    @Autowired
    private ICondicionFinalService service;

    @Autowired 
    private CondicionFinalMapper mapper;

    // Métodos CRUD existentes
    // =========================================================================
    
    @GetMapping
    public ResponseEntity<List<CondicionFinalResponseDto>> getAll() { 
        List<CondicionFinal> condiciones = service.findAll();
        if (condiciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<CondicionFinalResponseDto> dtos = condiciones.stream()
            .map(mapper::toResponseDto)
            .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CondicionFinalResponseDto> getById(@PathVariable Long id) { 
        CondicionFinal condicion = service.findById(id);
        return condicion == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(mapper.toResponseDto(condicion));
    }

    @PostMapping
    // Se añade @Valid para activar la validación del DTO (para el caso de error 400)
    public ResponseEntity<CondicionFinalResponseDto> create(@Valid @RequestBody CondicionFinalRequestDto dto) throws Exception { 
        CondicionFinal condicion = mapper.toEntity(dto);
        CondicionFinal created = service.create(condicion);
        return ResponseEntity.ok(mapper.toResponseDto(created));
    }

    @PutMapping("/{id}")
    // Se añade @Valid para activar la validación del DTO (para el caso de error 400)
    public ResponseEntity<CondicionFinalResponseDto> update(@PathVariable Long id, @Valid @RequestBody CondicionFinalRequestDto dto) throws Exception { 
        CondicionFinal existente = service.findById(id);
        if (existente == null) {
            return ResponseEntity.badRequest().build();
        }
        CondicionFinal condicion = mapper.toEntity(dto);
        CondicionFinal updated = service.update(condicion, id);
        return ResponseEntity.ok(mapper.toResponseDto(updated));
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

    // Otros endpoints existentes
    // =========================================================================

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<CondicionFinalResponseDto>> getByNombre(@PathVariable String nombre) { 
        List<CondicionFinal> lista = service.findByNombre(nombre);
        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<CondicionFinalResponseDto> dtos = lista.stream()
            .map(mapper::toResponseDto)
            .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/count/{nombre}")
    public ResponseEntity<Long> countByNombre(@PathVariable String nombre) {
        Long cantidad = service.countByNombre(nombre);
        return ResponseEntity.ok(cantidad);
    }

    // Nuevos Endpoints del Ejercicio 1 (Atributo Booleano: esVigente)
    // =========================================================================

    /**
     * Listado True: Registros donde esVigente es true.
     * Responde 200 con la lista.
     */
    @GetMapping("/vigentes")
    public ResponseEntity<List<CondicionFinalResponseDto>> getVigentes() {
        List<CondicionFinal> condiciones = service.findVigentes();
        if (condiciones.isEmpty()) {
            return ResponseEntity.ok(List.of()); // Devuelve 200 con lista vacía
        }
        List<CondicionFinalResponseDto> dtos = condiciones.stream()
            .map(mapper::toResponseDto)
            .collect(Collectors.toList());
        return ResponseEntity.ok(dtos); 
    }

    /**
     * Listado False: Registros donde esVigente es false.
     * Responde 200 con la lista.
     */
    @GetMapping("/no-vigentes")
    public ResponseEntity<List<CondicionFinalResponseDto>> getNoVigentes() {
        List<CondicionFinal> condiciones = service.findNoVigentes();
        if (condiciones.isEmpty()) {
            return ResponseEntity.ok(List.of()); // Devuelve 200 con lista vacía
        }
        List<CondicionFinalResponseDto> dtos = condiciones.stream()
            .map(mapper::toResponseDto)
            .collect(Collectors.toList());
        return ResponseEntity.ok(dtos); 
    }

    // Manejador de Excepciones
    // =========================================================================
    
   
}