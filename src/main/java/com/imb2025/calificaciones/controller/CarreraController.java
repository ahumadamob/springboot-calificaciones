package com.imb2025.calificaciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Carrera> getAll() {
        return carreraService.findAll();
    }

    @GetMapping("/{idcarrera}")
    public Carrera getCarreraById(@PathVariable("idcarrera") Long id) {
    	return carreraService.findById(id);
    } 
    
    @PostMapping
    public ResponseEntity<Carrera> createCarrera(@RequestBody @Valid CarreraRequestDto dto) {
        try {
            Carrera carrera = new Carrera();
            carrera.setNombre(dto.getNombre());
            carrera.setTituloOtorgado(dto.getTituloOtorgado());
            Carrera created = carreraService.create(carrera);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (Exception e) {
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    	
        
    @PutMapping("/{idcarrera}")
    public ResponseEntity<?> updateCarrera(@PathVariable("idcarrera") Long id, @RequestBody @Valid CarreraRequestDto dto) {
        try {
            Carrera existente = carreraService.findById(id);
            if (existente == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carrera no encontrada con ID: " + id);
            }

            Carrera actualizada = carreraService.update(carreraService.mapFromDto(dto), id);
            return ResponseEntity.ok(actualizada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar la carrera: " + e.getMessage());
        }
    }

    
    @DeleteMapping("/{idcarrera}")
    public void deleteCarrera(@PathVariable("idcarrera") Long id) {
        carreraService.deleteById(id);
    }
   
}
