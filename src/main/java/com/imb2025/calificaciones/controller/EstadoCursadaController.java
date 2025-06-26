package com.imb2025.calificaciones.controller;


import com.imb2025.calificaciones.dto.EstadoCursadaRequestDTO;
import com.imb2025.calificaciones.entity.EstadoCursada;
import com.imb2025.calificaciones.service.IEstadoCursadaService;
import com.imb2025.calificaciones.service.jpa.EstadoCursadaServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/estadocursada")
public class EstadoCursadaController {

    @Autowired
    private EstadoCursadaServiceImp service;


    @GetMapping
    public ResponseEntity<List<EstadoCursada>> getAll() {
        List<EstadoCursada> asignaciones = service.findAll();
        return ResponseEntity.ok(asignaciones);
    }
  
    @GetMapping("/{id}")
    public EstadoCursada getEstadoCursadabyId(@PathVariable Long id) {
    	return service.findById(id);
    }

    @PostMapping
    public EstadoCursada create(@RequestBody EstadoCursadaRequestDTO dto) {
        EstadoCursada estadoCursada = new EstadoCursada();
        try {
        	estadoCursada = service.mapFromDto(dto);
            estadoCursada= service.create(estadoCursada);
        }catch(Exception e){
        	e.printStackTrace();
        }
        return estadoCursada;
    }
    
    @PutMapping("/{id}")
    public EstadoCursada update(@RequestBody EstadoCursadaRequestDTO estadoCursadaRequestDTO, @PathVariable Long id) {
        EstadoCursada estadoCursada = new EstadoCursada();
        try {
        	estadoCursada = service.mapFromDto(estadoCursadaRequestDTO);
        	estadoCursada = service.update(estadoCursada, id);
        }catch(Exception e){
        	e.printStackTrace();
        }
        return estadoCursada;
    }
    

    @DeleteMapping("/{id}")
    public void deleteEstadoCursada(@PathVariable Long id) {
        service.deleteById(id);
    }
}
