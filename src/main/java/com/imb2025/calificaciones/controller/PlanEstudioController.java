package com.imb2025.calificaciones.controller;

import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
import com.imb2025.calificaciones.dto.PlanEstudioRequestDto;
import com.imb2025.calificaciones.entity.PlanEstudio;
import com.imb2025.calificaciones.service.IPlanEstudioService;
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
    public ResponseEntity<ApiResponseSuccessDto<List<PlanEstudio>>> getAllPlanesEstudio() {
        List<PlanEstudio> planes = planEstudioService.findAll();

        ApiResponseSuccessDto<List<PlanEstudio>> response = new ApiResponseSuccessDto<>();
        response.setMessage("Listado de planes de estudio obtenido con éxito");
        response.setData(planes);

        return planes.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(response);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<PlanEstudio>> getPlanEstudioById(@PathVariable Long id) {
        PlanEstudio plan = planEstudioService.findById(id);

        ApiResponseSuccessDto<PlanEstudio> response = new ApiResponseSuccessDto<>();
        response.setMessage("Plan de estudio encontrado con éxito");
        response.setData(plan);

        return ResponseEntity.ok(response);
    }

    
    @PostMapping
    public ResponseEntity<ApiResponseSuccessDto<PlanEstudio>> createPlanEstudio(@RequestBody PlanEstudioRequestDto dto) throws Exception {
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
            @RequestBody PlanEstudioRequestDto dto) throws Exception {

        PlanEstudio actualizado = planEstudioService.update(
                planEstudioService.fromDto(dto),
                id
        );

        ApiResponseSuccessDto<PlanEstudio> response = new ApiResponseSuccessDto<>();
        response.setMessage("Plan de estudio actualizado con éxito");
        response.setData(actualizado);

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
