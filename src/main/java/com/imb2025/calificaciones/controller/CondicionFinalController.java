package com.imb2025.calificaciones.controller;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imb2025.calificaciones.entity.CondicionFinal;
import com.imb2025.calificaciones.service.ICondicionFinalService;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api/condicion-final")
public class CondicionFinalController {

    @Autowired
    private ICondicionFinalService service;

    @GetMapping
    public List<CondicionFinal> getAll() {
        return service.getAll();
    }

    @PostMapping
    public CondicionFinal create(@RequestBody CondicionFinal cf) {
        return service.save(cf);    
    }

    @GetMapping("/{id}")
    public CondicionFinal getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public CondicionFinal update(@PathVariable Long id, @RequestBody CondicionFinal cf) {
        cf.setId(id);
        return service.save(cf);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
