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

import com.imb2025.calificaciones.dto.EvaluacionRequestDto;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

import com.imb2025.calificaciones.entity.Evaluacion;
import com.imb2025.calificaciones.service.IEvaluacionService;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;

@RestController
@RequestMapping("api/v1/evaluacion")
public class EvaluacionController {

	@Autowired
        private IEvaluacionService evaluacionServiceImp;

        @GetMapping
        public ResponseEntity<List<Evaluacion>> getAll() {
                List<Evaluacion> evaluaciones = evaluacionServiceImp.findAll();
                return evaluaciones.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(evaluaciones);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Evaluacion> gitById(@PathVariable Long id) {
                Evaluacion evaluacion = evaluacionServiceImp.findById(id);
                return evaluacion == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(evaluacion);

        }

        @PostMapping
        public ResponseEntity<Evaluacion> create(@RequestBody EvaluacionRequestDto evaluacionRequestDto) throws Exception {
                Evaluacion evaluacion = evaluacionServiceImp.fromDto(evaluacionRequestDto);
                return ResponseEntity.status(HttpStatus.CREATED).body(evaluacionServiceImp.create(evaluacion));
        }

        @PutMapping("/{id}")
        public ResponseEntity<Evaluacion> update(@PathVariable Long id,
                        @RequestBody EvaluacionRequestDto newEvaluacionDTO) throws Exception {
                Evaluacion existente = evaluacionServiceImp.findById(id);
                if(existente == null){
                        return ResponseEntity.badRequest().build();
                }
                Evaluacion evaluacion = evaluacionServiceImp.fromDto(newEvaluacionDTO);
                return ResponseEntity.status(HttpStatus.OK).body(evaluacionServiceImp.update(evaluacion, id));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable Long id) {
                try {
                        evaluacionServiceImp.deleteById(id);
                        return ResponseEntity.noContent().build();
                } catch (Exception entityNotFound) {
                        return ResponseEntity.badRequest().build();
                }

        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<String> handleException(Exception ex){
                return ResponseEntity.badRequest().body(ex.getMessage());
        }

}
