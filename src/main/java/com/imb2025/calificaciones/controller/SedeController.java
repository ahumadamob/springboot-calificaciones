package com.imb2025.calificaciones.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.imb2025.calificaciones.entity.Sede;
import com.imb2025.calificaciones.service.ISedeService;

@RestController
public class SedeController {

    @Autowired  
    private ISedeService sedeService;

    @GetMapping("/api/sede")
    public ResponseEntity<List<Sede>> getAllSedes(){
        List<Sede> lista = sedeService.findAll();
        return lista.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(lista);
    }

    @GetMapping("/api/sede/{idSede}")
    public ResponseEntity<Sede> getSedeById(@PathVariable("idSede") Long id){
        Sede sede = sedeService.findById(id);
        return sede == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(sede);
    }

    @PostMapping("/api/sede")
    public ResponseEntity<Sede> createSede(@RequestBody Sede sede){
        try {
            Sede creado = sedeService.create(sede);
            return ResponseEntity.ok(creado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/api/sede/{idSede}")
    public ResponseEntity<Sede> updateSede(@PathVariable("idSede") Long id, @RequestBody Sede sede){
        try {
            if (!sedeService.existsById(id)) {
                return ResponseEntity.badRequest().build();
            }
            Sede actualizado = sedeService.update(sede, id);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/api/sede/{idSede}")
    public ResponseEntity<Void> deleteSede(@PathVariable("idSede") Long id){
        try {
            if (!sedeService.existsById(id)) {
                return ResponseEntity.badRequest().build();
            }
            sedeService.deleteById(id);
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

