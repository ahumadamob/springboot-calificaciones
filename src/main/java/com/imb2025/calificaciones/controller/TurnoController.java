package com.imb2025.calificaciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
		return turnos.isEmpty() 
				? ResponseEntity.noContent().build()
						: ResponseEntity.ok(turnos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Turno> getById (@PathVariable Long id) {
		return turnoService.existsById(id)
				? ResponseEntity.ok(turnoService.findById(id))
						: ResponseEntity.noContent().build();
	}
	
	 @PostMapping
	  public ResponseEntity<Turno> createTurno(@RequestBody TurnoRequestDTO turnoRequestDTO) {
		 Turno turno = new Turno();
		
			 turno = turnoService.mapFromDTO(turnoRequestDTO);
			 turno = turnoService.create(turno);
			 return ResponseEntity.status(HttpStatus.CREATED).body(turno);
	    }
	 
	 @PutMapping("/{id}")
	    public ResponseEntity<Turno> updateTurno(@RequestBody TurnoRequestDTO turnoRequestDTO, @PathVariable Long id) throws Exception {
		 Turno turno = new Turno();
			 turno = turnoService.mapFromDTO(turnoRequestDTO);
			 turno = turnoService.update(id, turno);
			 return ResponseEntity.ok(turno);
	 }
	
	 
	 @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteTurno(@PathVariable Long id) throws Exception{
	        turnoService.deleteById(id);
	        return ResponseEntity.ok().build();
	    }
	 
	 @ExceptionHandler(Exception.class)
	 public ResponseEntity<String> handleException(Exception ex) {
		 return ResponseEntity.badRequest().body(ex.getMessage());
	 }
	

}
