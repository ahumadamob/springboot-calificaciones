package com.imb2025.calificaciones.controller;

import java.util.List;
import java.util.Optional;

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

import com.imb2025.calificaciones.dto.ObservacionAlumnoRequestDTO;
import com.imb2025.calificaciones.entity.ObservacionAlumno;
import com.imb2025.calificaciones.service.IObservacionAlumnoService;

@RestController
@RequestMapping("/api/v1/observacionAlumno")
public class ObservacionAlumnoController {
	
	@Autowired
	private IObservacionAlumnoService observacionAlumnoService;
	
        @GetMapping
        public ResponseEntity<List<ObservacionAlumno>> getAll(){
                List<ObservacionAlumno> lista = observacionAlumnoService.findAll();
                return ResponseEntity.ok(lista);
        }

        @GetMapping("/{id}")
        public ResponseEntity<ObservacionAlumno> getById(@PathVariable Long id) {

                Optional<ObservacionAlumno> observacionAlumno = observacionAlumnoService.findById(id);

                if (observacionAlumno.isPresent()) {
                        return ResponseEntity.ok(observacionAlumno.get());
                } else {
                        return ResponseEntity.notFound().build();
                }
        }

        @PostMapping
        public ResponseEntity<ObservacionAlumno> create(@RequestBody ObservacionAlumnoRequestDTO dto) {
                ObservacionAlumno observacionAlumno = observacionAlumnoService.create(observacionAlumnoService.fromDTO(dto));
                return ResponseEntity.status(HttpStatus.CREATED).body(observacionAlumno);
        }

        @PutMapping("/{id}")
        public ResponseEntity<ObservacionAlumno> update(@RequestBody ObservacionAlumnoRequestDTO dto, @PathVariable Long id) {
                ObservacionAlumno observacionAlumno = observacionAlumnoService.update(id, observacionAlumnoService.fromDTO(dto));
                return ResponseEntity.ok(observacionAlumno);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable Long id) {
                observacionAlumnoService.deleteById(id);
                return ResponseEntity.noContent().build();
        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<String> handleException(Exception ex) {
                return ResponseEntity.badRequest().body(ex.getMessage());
        }
	
 

}
