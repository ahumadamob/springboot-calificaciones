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
import com.imb2025.calificaciones.dto.ApiResponseErrorDto;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.imb2025.calificaciones.exception.EntidadNoEncontradaException;
import com.imb2025.calificaciones.dto.PlanEstudioRequestDto;
import com.imb2025.calificaciones.entity.PlanEstudio;
import com.imb2025.calificaciones.service.IPlanEstudioService;


@RestController
@RequestMapping("/planestudio")


public class PlanEstudioController {
	

@Autowired
IPlanEstudioService planEstudioService;

@GetMapping("/planestudio")
public ResponseEntity<List<PlanEstudio>> obtenerTodos() {
    List<PlanEstudio> planesDeEstudio = planEstudioService.findAll();
    return planesDeEstudio.isEmpty()
            ? ResponseEntity.noContent().build()
            : ResponseEntity.ok(planesDeEstudio);
}

@GetMapping("/{id}")
public ResponseEntity<PlanEstudio> obtenerPlanEstudioPorId(@PathVariable Long id) {
    return planEstudioService.existsById(id)
            ? ResponseEntity.ok(planEstudioService.findById(id))
            : ResponseEntity.noContent().build();
}

@PostMapping("/planestudio")
public ResponseEntity<PlanEstudio> crear(@RequestBody PlanEstudioRequestDto dto) throws Exception {
    PlanEstudio planEstudio = planEstudioService.fromDto(dto);
    return ResponseEntity.ok(planEstudioService.create(planEstudio));
}

@PutMapping("/planestudio/{id}")
public ResponseEntity<PlanEstudio> actualizar(@PathVariable Long id, @RequestBody PlanEstudioRequestDto dto) throws Exception {
    if (planEstudioService.existsById(id)) {
        PlanEstudio planEstudio = planEstudioService.fromDto(dto);
        return ResponseEntity.ok(planEstudioService.update(planEstudio, id));
    } else {
        return ResponseEntity.badRequest().body(null);
    }
}

@DeleteMapping("/planestudio/{id}")
public ResponseEntity<Void> eliminar(@PathVariable Long id) {
    try {
        planEstudioService.deleteById(id);
        return ResponseEntity.ok().build();
    } catch (Exception e) {
        return ResponseEntity.badRequest().build();
    }
}



@ExceptionHandler(Exception.class)
public ResponseEntity<String> handleException(Exception ex) {
    return ResponseEntity.badRequest().body(ex.getMessage());
}

}
