package com.imb2025.calificaciones.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.imb2025.calificaciones.dto.CursadaRequestDto;
import com.imb2025.calificaciones.entity.Cursada;
import com.imb2025.calificaciones.service.ICursadaService;

@RestController
public class CursadaController {

    @Autowired
    private ICursadaService cursadaService;

    @GetMapping("/api/cursada")
    public List<Cursada>getAllCursada() {
        return cursadaService.findAll();

    }

    @GetMapping("/api/cursada/{id}")
    public Cursada getCursadaById(@PathVariable("id") Long id){
        return cursadaService.findById(id);
    }

    @PostMapping("/api/cursada")
    public ResponseEntity<String> createCursada(@RequestBody CursadaRequestDto cursada){
        return ResponseEntity.ok(cursadaService.save(cursada));
    } 

    @PutMapping("/api/cursada")
    public ResponseEntity<String> updateCursada(@RequestBody CursadaRequestDto cursada){
        return ResponseEntity.ok(cursadaService.save(cursada));

    }

    @DeleteMapping("/api/cursada/{id}")
    public void deleteCursada(@PathVariable("id") Long id){
        cursadaService.deleteById(id);

    }

    @PutMapping("/api/cursada/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody CursadaRequestDto dto) {
        try {
            return ResponseEntity.ok(cursadaService.update(id,dto));
        } catch (Exception e) {
            return ResponseEntity.status(404).body("No existe la cursada");
        }


    }

}
