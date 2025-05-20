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

import com.imb2025.calificaciones.entity.Turno;
import com.imb2025.calificaciones.service.TurnoService;

@RestController
@RequestMapping("/api/turno")
public class TurnoController {
	
	@Autowired
	private TurnoService turnoService;
	
	@GetMapping
	public ResponseEntity<List<Turno>> getAll (){
		List<Turno> turnos = turnoService.findAll();
		return ResponseEntity.ok(turnos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Turno> getById (@PathVariable Long id) {
		Turno turno = turnoService.findById(id);
		if (turno != null) {
			return ResponseEntity.ok(turno);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	 @PostMapping
	  public Turno createTurno(@RequestBody Turno turno) {
	        return turnoService.save(turno);
	    }
	 
	 @PutMapping("/{id}")
	    public ResponseEntity<Turno> updateTurno(@PathVariable Long id, @RequestBody Turno turno) {
	        Turno updated = turnoService.update(id, turno);
	        if (updated != null) {
	            return ResponseEntity.ok(updated);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	
	 
	 @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteTurno(@PathVariable Long id) {
	        turnoService.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }
	

}
