package com.imb2025.calificaciones.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.imb2025.calificaciones.dto.CarreraRequestDto;
import com.imb2025.calificaciones.entity.Carrera;
import com.imb2025.calificaciones.service.ICarreraService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/carrera")
public class CarreraController {

    @Autowired
    private ICarreraService carreraService;

    @GetMapping
    public ResponseEntity<List<Carrera>> getAll() {
        List<Carrera> carreras = carreraService.findAll();
        return carreras.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(carreras);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrera> getById(@PathVariable Long id) {
        Carrera carrera = carreraService.findById(id);
        return carrera == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(carrera);
    }

    @PostMapping
    public ResponseEntity<Carrera> create(@RequestBody @Valid CarreraRequestDto dto) throws Exception {
        Carrera carrera = carreraService.fromDto(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(carreraService.create(carrera));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carrera> update(@PathVariable Long id, @RequestBody @Valid CarreraRequestDto dto) throws Exception {
        Carrera existente = carreraService.findById(id);
        if (existente == null) {
            return ResponseEntity.badRequest().build();
        }
        Carrera carrera = carreraService.fromDto(dto);
        return ResponseEntity.ok(carreraService.update(carrera, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            carreraService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}
