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

import com.imb2025.calificaciones.dto.ComisionRequestDTO;
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
	    public Comision create(@RequestBody ComisionRequestDTO comisionRequestDTO) {
	    	Comision createComision = new Comision();
	    	try{ 
	    		createComision = ComisionService.mapFromDto(comisionRequestDTO);
	    		createComision = ComisionService.create(createComision);
	    	} catch (Exception e) {
	    		
	    		e.printStackTrace();
	    	}
	        return createComision;
	    }

	    
	    @PutMapping("/{id}")
	    public Comision updateComision(@RequestBody ComisionRequestDTO comisionRequestDTO, @PathVariable Long id){
	        Comision comision = new Comision();
	        try {
	            comision = ComisionService.mapFromDto(comisionRequestDTO);
	            comision = ComisionService.update(id, comision);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return comision;
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Long id) {
	    	ComisionService.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }
}
