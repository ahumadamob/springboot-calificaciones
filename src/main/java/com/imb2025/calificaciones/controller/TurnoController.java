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

import com.imb2025.calificaciones.dto.TurnoRequestDTO;
import com.imb2025.calificaciones.entity.Turno;
import com.imb2025.calificaciones.service.ITurnoService;

@RestController
@RequestMapping("/api/turno")
public class TurnoController {
	
	@Autowired
	private ITurnoService turnoService;
	
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
	  public Turno createTurno(@RequestBody TurnoRequestDTO turnoRequestDTO) {
		 Turno turno = new Turno();
		 try {
			 turno = turnoService.mapFromDTO(turnoRequestDTO);
			 turno = turnoService.create(turno);
		 }catch (Exception e) {
			 e.printStackTrace();
		 }
		 return turnoService.create(turno);
	    }
	 
	 @PutMapping("/{id}")
	    public Turno updateTurno(@RequestBody TurnoRequestDTO turnoRequestDTO, @PathVariable Long id) {
		 Turno turno = new Turno();
		 try {
			 turno = turnoService.mapFromDTO(turnoRequestDTO);
			 turno = turnoService.update(id, turno);
		 }catch (Exception e) {
			 e.printStackTrace();
		 }
	
		 return turno;
	 }
	
	 
	 @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteTurno(@PathVariable Long id) {
	        turnoService.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }
	

}
