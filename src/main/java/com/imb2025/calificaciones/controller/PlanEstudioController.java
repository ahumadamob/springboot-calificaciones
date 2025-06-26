package com.imb2025.calificaciones.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imb2025.calificaciones.entity.PlanEstudio;
import com.imb2025.calificaciones.service.jpa.PlanEstudioServiceImp;


@RestController
@RequestMapping("/planestudio")


public class PlanEstudioController {
	
@Autowired

private PlanEstudioServiceImp planestudioserviceimp;

@GetMapping
public ResponseEntity<List<PlanEstudio>> getAll(){
	List<PlanEstudio> planes = planestudioserviceimp.findAll();
	return ResponseEntity.ok(planes);
}

@GetMapping("/{id}")
public ResponseEntity<Optional<PlanEstudio>> gitById(@PathVariable int id){
	Optional<PlanEstudio> planestudio=planestudioserviceimp.findById(id);
	return ResponseEntity.ok(planestudio);
	
}


@PostMapping
public PlanEstudio createPlanEstudio(@RequestBody PlanEstudio planestudio) {
      return planestudioserviceimp.save(planestudio);
  }

@PutMapping("/{id}")
  public ResponseEntity<PlanEstudio> updatePlanEstudio(@PathVariable Long id, @RequestBody PlanEstudio planestudio) {
      PlanEstudio updated = planestudioserviceimp.update(id, planestudio);
      if (updated != null) {
          return ResponseEntity.ok(updated);
      } else {
          return ResponseEntity.notFound().build();
      }
  }


@DeleteMapping("/{id}")
  public ResponseEntity<Void> deletePlanEstudio(@PathVariable Long id) {
      planestudioserviceimp.deleteById(id);
      return ResponseEntity.noContent().build();
  }


	

}
