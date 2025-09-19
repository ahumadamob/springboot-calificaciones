package com.imb2025.calificaciones.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
import com.imb2025.calificaciones.dto.MateriaRequestDto;
import com.imb2025.calificaciones.entity.Materia;
import com.imb2025.calificaciones.service.IMateriaService;





@RestController
public class MateriaController {
	
	@Autowired
	private IMateriaService materiaService;
	
        @GetMapping("/api/materia")
        public ResponseEntity<List<Materia>> getAllMateria(){
                List<Materia> materias = materiaService.findAll();
                return materias.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(materias);
        }

        @GetMapping("/api/materia/{id}")
        public ResponseEntity<ApiResponseSuccessDto <Materia>> getMateriaById(@PathVariable Long id) {
        	
        	Materia materia = materiaService.findById(id);
        	ApiResponseSuccessDto<Materia> response = new ApiResponseSuccessDto<>();
        	response.setMessage("Materia encontrada con exito");
        	response.setData(materia);
            
            return ResponseEntity.ok(response);
        }


        @PostMapping("/api/materia")
        public ResponseEntity<Materia> createMateria(@RequestBody MateriaRequestDto materiaRequestDto) throws Exception{
                Materia materia = materiaService.fromDto(materiaRequestDto);
                return ResponseEntity.ok(materiaService.create(materia));

        }

        @PutMapping ("/api/materia/{id}")
        public ResponseEntity<Materia> updateMateria(@RequestBody MateriaRequestDto materiaRequestDto, @PathVariable("id") Long id) throws Exception{
                Materia existente = materiaService.findById(id);
                if(existente == null){
                    return ResponseEntity.badRequest().build();
                }
                Materia materia = materiaService.fromDto(materiaRequestDto);
                return ResponseEntity.ok(materiaService.update(materia,id));
        }
        @DeleteMapping("/api/materia/{id}")
        public ResponseEntity<Void> deleteMateria(@PathVariable("id") Long id) {
            try {
                materiaService.deleteById(id);
                return ResponseEntity.ok().build();
            } catch (Exception e) {
                return ResponseEntity.badRequest().build();
            }


        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<String> handleException(Exception ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
}