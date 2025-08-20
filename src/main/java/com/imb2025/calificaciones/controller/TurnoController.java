package com.imb2025.calificaciones.controller;


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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.imb2025.calificaciones.dto.TurnoRequestDto;
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
                Turno turno = turnoService.findById(id);
                return turno == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(turno);
        }

         @PostMapping
          public ResponseEntity<Turno> createTurno(@RequestBody TurnoRequestDto turnoRequestDto) throws Exception {
                 Turno turno = turnoService.fromDto(turnoRequestDto);
                 turno = turnoService.create(turno);
                 return ResponseEntity.status(HttpStatus.CREATED).body(turno);
            }

         @PutMapping("/{id}")
            public ResponseEntity<Turno> updateTurno(@RequestBody TurnoRequestDto turnoRequestDto, @PathVariable Long id) throws Exception {
                 Turno existente = turnoService.findById(id);
                 if(existente == null){
                        return ResponseEntity.badRequest().build();
                 }
                 Turno turno = turnoService.fromDto(turnoRequestDto);
                 turno = turnoService.update(turno, id);
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
