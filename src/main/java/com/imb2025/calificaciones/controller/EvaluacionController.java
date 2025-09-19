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

import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
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
        public ResponseEntity<ApiResponseSuccessDto<List<Evaluacion>>> getAll() {
            List<Evaluacion> evaluaciones = evaluacionServiceImp.findAll();
            
            ApiResponseSuccessDto<List<Evaluacion>> response = new ApiResponseSuccessDto<>();
            response.setData(evaluaciones);
            response.setMessage("Lista Evaluaciones encontrada exitosamente");
            response.setSuccess(true);
            
            return ResponseEntity.ok(response);
        }

        @GetMapping("/{id}")
        public ResponseEntity<ApiResponseSuccessDto<Evaluacion>> gitById(@PathVariable Long id) {
                Evaluacion evaluacion = evaluacionServiceImp.findById(id);
            ApiResponseSuccessDto<Evaluacion> response = new ApiResponseSuccessDto<>();
            response.setMessage("Evaluacion encontrada exitosamente");
            response.setData(evaluacion);
            response.setSuccess(true);
               
            return ResponseEntity.ok(response);
        }

        @PostMapping
        public ResponseEntity<ApiResponseSuccessDto<Evaluacion>> create(@RequestBody EvaluacionRequestDto evaluacionRequestDto) throws Exception {
        	Evaluacion evaluacion = evaluacionServiceImp.create(evaluacionServiceImp.fromDto(evaluacionRequestDto));
        	ApiResponseSuccessDto<Evaluacion> response = new ApiResponseSuccessDto<>();
        	response.setMessage("Evaluacion creada exitosamente");
        	response.setData(evaluacion);
        	response.setSuccess(true);
        	
        	return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }

        @PutMapping("/{id}")
        public ResponseEntity<ApiResponseSuccessDto<Evaluacion>> update(@PathVariable Long id,
                        @RequestBody EvaluacionRequestDto newEvaluacionDTO) throws Exception {
            Evaluacion existente = evaluacionServiceImp.findById(id);
                
            ApiResponseSuccessDto<Evaluacion> response = new ApiResponseSuccessDto<>();
            response.setMessage("Evaluacion actualizada exitosamente");
            response.setData(existente);
            response.setSuccess(true);
              
            evaluacionServiceImp.update(evaluacionServiceImp.fromDto(newEvaluacionDTO), id);
            return ResponseEntity.ok(response);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<ApiResponseSuccessDto<Evaluacion>> delete(@PathVariable Long id) throws Exception {
        	evaluacionServiceImp.deleteById(id);
        	ApiResponseSuccessDto<Evaluacion> response = new ApiResponseSuccessDto<>();
        	response.setMessage("Evaluacion eliminada exitosamente");
        	response.setData(null);
        	response.setSuccess(true);
        	
        	
        	return ResponseEntity.ok(response);

        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<String> handleException(Exception ex){
                return ResponseEntity.badRequest().body(ex.getMessage());
        }

}
