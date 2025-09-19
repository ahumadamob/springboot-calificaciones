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

import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
import com.imb2025.calificaciones.dto.PeriodoLectivoRequestDto;
import com.imb2025.calificaciones.entity.PeriodoLectivo;
import com.imb2025.calificaciones.service.IPeriodoLectivoService;

@RestController
@RequestMapping("/api/periodo-lectivo")
public class PeriodoLectivoController {
	
	@Autowired
	private IPeriodoLectivoService service;
	
        @GetMapping
        public ResponseEntity<List<PeriodoLectivo>> getAll() {
                List<PeriodoLectivo> periodos = service.findAll();
                return periodos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(periodos);
        }

        @GetMapping("/{id}")
        public ResponseEntity<ApiResponseSuccessDto<PeriodoLectivo>> getById(@PathVariable Long id) {
                PeriodoLectivo periodoLectivo = service.findById(id);
                ApiResponseSuccessDto<PeriodoLectivo> response = new ApiResponseSuccessDto<PeriodoLectivo>(true, "Periodo Lectivo encontrado con éxito", periodoLectivo); 
                return ResponseEntity.ok(response);
        }

        @PostMapping
        public ResponseEntity<ApiResponseSuccessDto<PeriodoLectivo>> create(@RequestBody PeriodoLectivoRequestDto periodoLectivo) throws Exception {
                PeriodoLectivo createdPeriodoLectivo = service.create(
                                        service.fromDto(periodoLectivo)
                                );
                ApiResponseSuccessDto<PeriodoLectivo> response = new ApiResponseSuccessDto<PeriodoLectivo>(true, "Periodo Lectivo creado con éxito", createdPeriodoLectivo);
                return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }

        @PutMapping("/{id}")
        public ResponseEntity<ApiResponseSuccessDto<PeriodoLectivo>> updateById(@PathVariable Long id,
                        @RequestBody PeriodoLectivoRequestDto periodoLectivo) throws Exception {
                PeriodoLectivo updatedPeriodoLectivo = service.update(
                                service.fromDto(periodoLectivo),
                                id
                                );
                ApiResponseSuccessDto<PeriodoLectivo> response = new ApiResponseSuccessDto<PeriodoLectivo>(true, "Periodo Lectivo actualizado con éxito", updatedPeriodoLectivo);
                return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteById(@PathVariable Long id) throws Exception {
                service.deleteById(id);
                return ResponseEntity.noContent().build();
        }
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ex) {
	  return ResponseEntity.badRequest().body(ex.getMessage());
	}
	
}
