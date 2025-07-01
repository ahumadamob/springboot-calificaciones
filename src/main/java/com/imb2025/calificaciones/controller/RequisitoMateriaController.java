package com.imb2025.calificaciones.controller;

import com.imb2025.calificaciones.entity.RequisitoMateria;
import com.imb2025.calificaciones.service.RequisitoMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requisito-materia")
public class RequisitoMateriaController {

    @Autowired
    private RequisitoMateriaService service;

    @GetMapping
    public List<RequisitoMateria> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public RequisitoMateria getById(@PathVariable Long id) {
        return service.findById(id).orElseThrow();
    }

    @PostMapping
    public RequisitoMateria create(@RequestBody RequisitoMateria requisito) {
        return service.save(requisito);
    }

    @PutMapping("/{id}")
    public RequisitoMateria update(@PathVariable Long id, @RequestBody RequisitoMateria requisito) {
        return service.update(id, requisito);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
