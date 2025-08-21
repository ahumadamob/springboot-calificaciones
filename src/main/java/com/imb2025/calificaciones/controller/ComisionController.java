package com.imb2025.calificaciones.controller;


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

import com.imb2025.calificaciones.dto.ComisionRequestDto;
import com.imb2025.calificaciones.entity.Comision;
import com.imb2025.calificaciones.service.IComisionService;

@RestController
@RequestMapping("api/v1/Comision")
public class ComisionController {

	@Autowired
	private IComisionService ComisionService;
	
	
        @GetMapping
        public ResponseEntity<List<Comision>> getAll() {
                List<Comision> comisiones = ComisionService.findAll();
                return comisiones.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(comisiones);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Comision> getById(@PathVariable Long id) {
                Comision comision = ComisionService.findById(id);
                return comision == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(comision);
        }

        @PostMapping
        public ResponseEntity<Comision> create(@RequestBody ComisionRequestDto dto) throws Exception {
                Comision comision = ComisionService.fromDto(dto);
                return ResponseEntity.ok(ComisionService.create(comision));
        }

        @PutMapping("/{id}")
        public ResponseEntity<Comision> update(@PathVariable Long id,
                @RequestBody ComisionRequestDto dto) throws Exception {
                Comision comision = ComisionService.fromDto(dto);
                return ResponseEntity.ok(ComisionService.update(comision, id));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception {
                ComisionService.deleteById(id);
                return ResponseEntity.noContent().build();
        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<String> handleException(Exception ex) {
                return ResponseEntity.badRequest().body(ex.getMessage());
        }
}
