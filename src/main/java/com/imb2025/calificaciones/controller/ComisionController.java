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

import org.springframework.beans.factory.annotation.Autowired;

import com.imb2025.calificaciones.entity.Comision;
import com.imb2025.calificaciones.service.IComisionService;

@RestController
@RequestMapping("api/v1/Comision")
public class ComisionController {

	@Autowired
	private IComisionService ComisionService;
	
	
	 @GetMapping
	    public ResponseEntity<List<Comision>> getAll() {
	        List<Comision> Comisiones = ComisionService.findAll();
	        return ResponseEntity.ok(Comisiones);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Comision> getById(@PathVariable Long id) {
	    	Comision comision = ComisionService.findById(id);
	        return ResponseEntity.ok(comision);
	    }

	    @PostMapping
	    public ResponseEntity<Comision> create(@RequestBody Comision comision) {
	    	Comision createdComision = ComisionService.save(comision);
	        return ResponseEntity.ok(createdComision);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Comision> update(@PathVariable Long id,
	            @RequestBody Comision comision) {
	    	Comision updatedComision = ComisionService.update(id, comision);
	        return ResponseEntity.ok(updatedComision);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Long id) {
	    	ComisionService.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }
}
