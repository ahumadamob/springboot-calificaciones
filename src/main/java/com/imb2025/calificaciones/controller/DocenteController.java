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

import com.imb2025.calificaciones.dto.DocenteRequestDTO;
import com.imb2025.calificaciones.entity.Docente;
import com.imb2025.calificaciones.service.IDocenteService;




@RestController
@RequestMapping("/api/docente")
public class DocenteController {

    @Autowired
    private IDocenteService docenteService ;

    @GetMapping
    public List<Docente> getAllDocente() {
        return docenteService.findAll();
    }

    @GetMapping("/{iddocente}")
    public Docente getDocenteById(@PathVariable("iddocente") Long id){
        return docenteService.findById(id);
    }

    @PostMapping
    public Docente createDocente(@RequestBody DocenteRequestDTO docenteDTO){
        Docente docente = new Docente();
        try {
            docente = docenteService.mapFromDTO(docenteDTO);
            docente = docenteService.create(docente);
        } catch (Exception e) {
            throw new RuntimeException("Error al mapear el DTO: " + e.getMessage());
        }
        return docente;
    }

    @PutMapping("/{id}")
    public Docente updateDocente(@PathVariable Long id, @RequestBody DocenteRequestDTO docenteDTO) {
        Docente docente = new Docente();
        try {
            docente = docenteService.mapFromDTO(docenteDTO);
        } catch (Exception e) {
            throw new RuntimeException("Error al mapear el DTO: " + e.getMessage());
        }
        try {
            docente = docenteService.update(id, docente);
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar el docente: " + e.getMessage());
        }
        return docente;
    }

    @DeleteMapping("/{iddocente}")
    public void deleteDocente(@PathVariable("iddocente") Long id) {
        docenteService.deleteById(id);
    }
}
