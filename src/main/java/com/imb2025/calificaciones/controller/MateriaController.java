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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
import com.imb2025.calificaciones.dto.request.MateriaRequestDto;
import com.imb2025.calificaciones.dto.response.MateriaResponseDto;
import com.imb2025.calificaciones.entity.Materia;
import com.imb2025.calificaciones.mapper.MateriaMapper;
import com.imb2025.calificaciones.service.IMateriaService;

import jakarta.validation.Valid;


@RestController
public class MateriaController {
	
	@Autowired
	private IMateriaService materiaService;
	
        @GetMapping("/api/materia")
        public ResponseEntity<List<MateriaResponseDto>> getAllMateria(){
                List<Materia> materias = materiaService.findAll();
                List<MateriaResponseDto> materiaDtoList = new ArrayList<MateriaResponseDto>();
                
                MateriaMapper mapper= new MateriaMapper();
                for(Materia n: materias) {
                	materiaDtoList.add(mapper.toResponseDto(n));
                }
                
                
                return materias.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(materiaDtoList);
        }
        
        @GetMapping("/api/materia/ordenado")
        public ResponseEntity<List<MateriaResponseDto>> getAllOrder(){ 
            List<Materia> materias = materiaService.findAllOrder();
            MateriaMapper mapper = new MateriaMapper();
            List<MateriaResponseDto> dtoList = new ArrayList<>();
            for (Materia m : materias) {
                dtoList.add(mapper.toResponseDto(m));
            }
            
            return dtoList.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(dtoList);
        }
        
        @GetMapping("/api/materia/nivel/{nombreNivel}")
        public ResponseEntity<List<MateriaResponseDto>> getAllMateriaByNivelDomain(@PathVariable String nombreNivel){
                List<Materia> materias = materiaService.findByNivelEndsWith(nombreNivel);
                MateriaMapper mapper = new MateriaMapper();
                List<MateriaResponseDto> dtoList = new ArrayList<>();
                for (Materia m : materias) {
                    dtoList.add(mapper.toResponseDto(m));
                }
                return materias.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(dtoList);
        }

        @GetMapping("/api/materia/{id}")
        public ResponseEntity<ApiResponseSuccessDto <MateriaResponseDto>> getMateriaById(@PathVariable Long id) { 
            
            Materia materia = materiaService.findById(id); 
            MateriaMapper mapper = new MateriaMapper();
            MateriaResponseDto materiaDto = mapper.toResponseDto(materia);
            ApiResponseSuccessDto<MateriaResponseDto> response = new ApiResponseSuccessDto<>(); 
            response.setMessage("Materia encontrada con exito");
            response.setData(materiaDto);
            
            return ResponseEntity.ok(response);
        }
        
        @GetMapping("/api/materia/codigo/{numeroCodigo}")
        public ResponseEntity<ApiResponseSuccessDto <Materia>> getMateriaByCodigo(@PathVariable String numeroCodigo) {
        	
        	Materia materia = materiaService.findByCodigo(numeroCodigo);
        	ApiResponseSuccessDto<Materia> response = new ApiResponseSuccessDto<>();
        	response.setMessage("Materia encontrada con exito");
        	response.setData(materia);
            
            return ResponseEntity.ok(response);
        }
        
        @GetMapping("/api/materia/contador/{cargaHoraria}")
        public ResponseEntity<Long> contarPorCargaHoraria(@PathVariable Integer cargaHoraria) {
            long contador = materiaService.findByCargaHoraria(cargaHoraria);
            return ResponseEntity.ok(contador);
        
        };
        
        //parcial 
        
        @GetMapping("/api/materia/estado/activos")
        public ResponseEntity<Map<String, Long>> getEstadoActivos() {
            long total = materiaService.contarMateriasActivas();
            return ResponseEntity.ok(Map.of("total", total));
        }
        
        @GetMapping("/api/materia/estado/inactivos")
        public ResponseEntity<Map<String, Long>> getEstadoInactivos() {
            long total = materiaService.contarMateriasInactivas();
            return ResponseEntity.ok(Map.of("total", total));
        }


        @PostMapping("/api/materia")
     
     public ResponseEntity<MateriaResponseDto> createMateria(@Valid @RequestBody MateriaRequestDto materiaRequestDto) throws Exception {
         
         MateriaMapper mapper = new MateriaMapper(); 
         Materia materia = mapper.fromDto(materiaRequestDto);
         Materia materiaGuardada = materiaService.create(materia); 
         MateriaResponseDto respuestaDto = mapper.toResponseDto(materiaGuardada);
         return ResponseEntity.ok(respuestaDto);
     }

        

        @PutMapping ("/api/materia/{id}")
        public ResponseEntity<Materia> updateMateria(@Valid @RequestBody MateriaRequestDto materiaRequestDto, @PathVariable("id") Long id) throws Exception{   
        	MateriaMapper mapper =new MateriaMapper();
        	Materia existente = materiaService.findById(id);
                if(existente == null){
                    return ResponseEntity.badRequest().build();
                }
                Materia materia = mapper.fromDto(materiaRequestDto);
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