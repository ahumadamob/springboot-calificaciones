package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import entities.Evaluacion;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import services.EvaluacionServiceImp;

@RestController
@RequestMapping("api/v1/evaluacion")
public class EvaluacionController {
	
	@Autowired
	private EvaluacionServiceImp evaluacionServiceImp;
	
	 
	@GetMapping("/all")
	public ResponseEntity<List<Evaluacion>> getAll(){
		List<Evaluacion> evaluaciones = evaluacionServiceImp.findAll();
		return ResponseEntity.ok(evaluaciones);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Evaluacion> gitById(@PathVariable int id){
		Evaluacion evaluacion=evaluacionServiceImp.findById(id);
		return ResponseEntity.ok(evaluacion);
		
	}
	
	@PostMapping
	public ResponseEntity<Evaluacion> create(@RequestBody Evaluacion evaluacion){
		Evaluacion eva=evaluacionServiceImp.save(evaluacion);
		return ResponseEntity.ok(eva);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Evaluacion> update(@PathVariable int id, @RequestBody Evaluacion newEvaluacion){
		try {
			Evaluacion evaluacion=evaluacionServiceImp.update(id, newEvaluacion);
			return ResponseEntity.ok(evaluacion);
			
		}catch (EntityNotFoundException entityNotFound) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable int id) {
		evaluacionServiceImp.deleteById(id);
		return ResponseEntity.noContent().build();
		
	}
	
	
	

}
