package com.imb2025.calificaciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imb2025.calificaciones.entity.Carrera;
import com.imb2025.calificaciones.services.ICarreraService;

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
    public Carrera createCarrera(@RequestBody Carrera carrera) {
    	return carreraService.save(carrera);
    }
    	
    @PutMapping
    public Carrera updateCarrera(@RequestBody Carrera carrera) {
        return carreraService.save(carrera);
    }

    
    @DeleteMapping("/{idcarrera}")
    public void deleteCarrera(@PathVariable("idcarrera") Long id) {
        carreraService.deleteById(id);
    }
   
}
