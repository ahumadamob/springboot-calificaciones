package com.imb2025.calificaciones.controller;

import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
import com.imb2025.calificaciones.dto.mapper.PlanEstudioMapper;
import com.imb2025.calificaciones.dto.request.PlanEstudioRequestDto;
import com.imb2025.calificaciones.dto.response.PlanEstudioResponseDto;
import com.imb2025.calificaciones.entity.PlanEstudio;
import com.imb2025.calificaciones.service.IPlanEstudioService;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planestudios")
public class PlanEstudioController {

    @Autowired
    private IPlanEstudioService planEstudioService;

   
    
    @GetMapping
    public ResponseEntity<ApiResponseSuccessDto<List<PlanEstudioResponseDto>>> getAllPlanesEstudio() {
        List<PlanEstudio> resultados = planEstudioService.findAll(); 
        List<PlanEstudioResponseDto> planesDto = resultados.stream().map(p -> PlanEstudioMapper.toResponseDto(p)).toList();

        
        ApiResponseSuccessDto<List<PlanEstudioResponseDto>> response = 
                new ApiResponseSuccessDto<>(true, "Listado de planes de estudio obtenido con éxito", planesDto);

        
        return planesDto.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(response);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<PlanEstudio>> getPlanEstudioById(@PathVariable Long id) {
    	PlanEstudio plan = planEstudioService.findById(id);
    	ApiResponseSuccessDto<PlanEstudio> response = new 
    	ApiResponseSuccessDto<>();
    	response.setMessage("Plan de estudio encontrado con éxito");
    	        response.setData(plan);

        return ResponseEntity.ok(response);
    }
    
    
    @GetMapping("/buscar")
    public ResponseEntity<ApiResponseSuccessDto<List<PlanEstudio>>>  getByNombre(
    		@RequestParam (required = true) String nombre) {
        List<PlanEstudio> planes = planEstudioService.findAllByNombre(nombre);
       
        
        ApiResponseSuccessDto<List<PlanEstudio>> response = new ApiResponseSuccessDto<List<PlanEstudio>>(true, "Plan Estudio con nombre "+ nombre +" encontrados con éxito", planes);
        response.setMessage("Resultado del filtro por nombre");
        response.setData(planes);

        return planes.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(response);
    }

    
    @GetMapping("/count")
    public ResponseEntity<ApiResponseSuccessDto<Long>> countByCarrera(@PathVariable Long carreraId) {
        long cantidad = planEstudioService.countByCarrera(carreraId);

        ApiResponseSuccessDto<Long> response = new ApiResponseSuccessDto<>();
        response.setMessage("Cantidad de planes asociados a la carrera con ID: " + carreraId);
        response.setData(cantidad);

        return ResponseEntity.ok(response);
    }

   
    @PostMapping
    public ResponseEntity<ApiResponseSuccessDto<PlanEstudio>> createPlanEstudio( @Valid @RequestBody PlanEstudioRequestDto dto) throws Exception {
        PlanEstudio nuevo = planEstudioService.fromDto(dto);
        PlanEstudio saved = planEstudioService.create(nuevo);
               
        ApiResponseSuccessDto<PlanEstudio> response = new ApiResponseSuccessDto<>();
        response.setMessage("Plan de estudio creado con éxito");
        response.setData(saved);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<PlanEstudio>> updatePlanEstudio(
            @PathVariable Long id,
            @Valid @RequestBody PlanEstudioRequestDto dto) throws Exception {

    	PlanEstudio actualizado = planEstudioService.update
    			(PlanEstudioMapper.fromDto(dto), id);
    	ApiResponseSuccessDto<PlanEstudio> response = new 
    	ApiResponseSuccessDto<>();
    	response.setMessage("Plan de estudio actualizado con éxito");
        
    

        return ResponseEntity.ok(response);
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<Void>> deletePlanEstudio(@PathVariable Long id) {
        planEstudioService.deleteById(id);

        ApiResponseSuccessDto<Void> response = new ApiResponseSuccessDto<>();
        response.setMessage("Plan de estudio eliminado con éxito");
        response.setData(null);

        return ResponseEntity.ok(response);
    }
}
