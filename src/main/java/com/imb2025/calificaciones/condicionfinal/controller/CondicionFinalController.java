package com.imb2025.calificaciones.condicionfinal.controller;

import com.imb2025.calificaciones.condicionfinal.dto.CondicionFinalRequestDTO;
import com.imb2025.calificaciones.condicionfinal.entity.CondicionFinal;
import com.imb2025.calificaciones.condicionfinal.service.CondicionFinalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/condicion-final")
public class CondicionFinalController {

    @Autowired
    private CondicionFinalService service;

    @GetMapping
    public List<CondicionFinal> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CondicionFinal getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public CondicionFinal create(@RequestBody CondicionFinalRequestDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public CondicionFinal update(@PathVariable Long id, @RequestBody CondicionFinalRequestDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
