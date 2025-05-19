package com.imb2025.calificaciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imb2025.calificaciones.entity.Comisión;
import com.imb2025.calificaciones.service.IComisiónService;

@RestController
@RequestMapping("api/v1/Comisión")
public class ComisiónController {

	@Autowired
	private IComisiónService ComisiónService;
	
	
	 @GetMapping
	    public ResponseEntity<List<Comisión>> getAll() {
	        List<Comisión> Comisiones = ComisiónService.findAll();
	        return ResponseEntity.ok(Comisiones);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Comisión> getById(@PathVariable Long id) {
	    	Comisión comisión = ComisiónService.findById(id);
	        return ResponseEntity.ok(comisión);
	    }

	    @PostMapping
	    public ResponseEntity<Comisión> create(@RequestBody Comisión comisión) {
	    	Comisión createdComisión = ComisiónService.save(comisión);
	        return ResponseEntity.ok(createdComisión);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Comisión> update(@PathVariable Long id,
	            @RequestBody Comisión comisión) {
	    	Comisión updatedComisión = ComisiónService.update(id, comisión);
	        return ResponseEntity.ok(updatedComisión);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Long id) {
	    	ComisiónService.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }
}
