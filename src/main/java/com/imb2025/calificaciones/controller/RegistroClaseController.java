package com.imb2025.calificaciones.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


import com.imb2025.calificaciones.dto.RegistroClaseRequestDto;
import com.imb2025.calificaciones.entity.RegistroClase;
import com.imb2025.calificaciones.service.IRegistroClaseService;



@RestController
@RequestMapping("/registro")
public class RegistroClaseController {

    private final IRegistroClaseService iregistroClase;

    public RegistroClaseController(IRegistroClaseService iregistroClase) {
        this.iregistroClase = iregistroClase;
    }

    @GetMapping
    public ResponseEntity<List<RegistroClase>> findAll() {
        List<RegistroClase> registros = iregistroClase.findAll();
        return registros.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(registros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroClase> getById(@PathVariable Long id) {
        RegistroClase registro = iregistroClase.findById(id);
        return registro == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(registro);
    }

    @PostMapping
    public ResponseEntity<RegistroClase> create(@RequestBody RegistroClaseRequestDto dto) throws Exception {
        RegistroClase registro = iregistroClase.fromDto(dto);
        return ResponseEntity.ok(iregistroClase.create(registro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistroClase> update(@PathVariable Long id, @RequestBody RegistroClaseRequestDto dto) {
        try {
            RegistroClase registro = iregistroClase.fromDto(dto);
            return ResponseEntity.ok(iregistroClase.update(registro, id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            iregistroClase.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
