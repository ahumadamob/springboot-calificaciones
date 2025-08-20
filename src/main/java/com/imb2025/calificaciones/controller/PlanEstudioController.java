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

private IPlanEstudioService planestudioserviceimp;

@GetMapping
public ResponseEntity<List<PlanEstudio>> getAllPlanesEstudio() {
    List<PlanEstudio> planes = planestudioserviceimp.findAll();
    return ResponseEntity.ok(planes);
}


@GetMapping("/{id}")
public ResponseEntity<?> getPlanEstudioById(@PathVariable Long id) {
    Optional<PlanEstudio> plan = Optional.ofNullable(planestudioserviceimp.findById(id));

    if (plan.isPresent()) {
        return ResponseEntity.ok(plan.get());
    } else {
        Map<String, Object> message = new HashMap<>();
        message.put("error", "Plan de estudio con ID " + id + " no encontrado");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}


@PostMapping
public ResponseEntity<?> createPlanEstudio(@RequestBody PlanEstudioRequestDto planestudioRequestDto) {
    try {
        
        PlanEstudio planestudio = planestudioserviceimp.convertToEntity(planestudioRequestDto);

      
        PlanEstudio saved = planestudioserviceimp.save(planestudio);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);

    } catch (EntidadNoEncontradaException e) {
        Map<String, Object> message = new HashMap<>();
        message.put("mensaje", e.getMessage());
        message.put("error", "Entidad relacionada no encontrada");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);

    } catch (Exception e) {
        Map<String, Object> message = new HashMap<>();
        message.put("mensaje", e.getMessage());
        message.put("error", "Error al crear el plan de estudio");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }
}


        @PutMapping("/{id}")
        public ResponseEntity<?> updatePlanEstudio(@PathVariable Long id, @RequestBody PlanEstudioRequestDto newPlanEstudioDto) {
            try {
                
                Optional<PlanEstudio> existing = Optional.ofNullable(planestudioserviceimp.findById(id));
                if (existing.isEmpty()) {
                    Map<String, Object> message = new HashMap<>();
                    message.put("error", "Plan de estudio con ID " + id + " no encontrado");
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
                }

                
                PlanEstudio planestudio = planestudioserviceimp.convertToEntity(newPlanEstudioDto);

               

                PlanEstudio updated = planestudioserviceimp.save(planestudio);
                return ResponseEntity.ok(updated);

            } catch (EntidadNoEncontradaException e) {
                Map<String, Object> message = new HashMap<>();
                message.put("mensaje", e.getMessage());
                message.put("error", "Entidad relacionada no encontrada");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);

            } catch (Exception e) {
                Map<String, Object> message = new HashMap<>();
                message.put("mensaje", e.getMessage());
                message.put("error", "Error al actualizar el plan de estudio");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
            }
        }








        @DeleteMapping("/{id}")
        public ResponseEntity<?> deletePlanEstudio(@PathVariable Long id) {
            try {
                Optional<PlanEstudio> existing = Optional.ofNullable(planestudioserviceimp.findById(id));
                if (existing.isEmpty()) {
                    Map<String, Object> message = new HashMap<>();
                    message.put("error", "Plan de estudio con ID " + id + " no encontrado");
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
                }

                planestudioserviceimp.deleteById(id);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

            } catch (Exception e) {
                Map<String, Object> message = new HashMap<>();
                message.put("error", "Error al eliminar el plan de estudio");
                message.put("mensaje", e.getMessage());
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
            }
        }



	

}
