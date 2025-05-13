package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import entities.Evaluacion;
import java.util.List;
import services.EvaluacionServiceImp;

@RestController
@RequestMapping("api/v1/evaluacion")
public class EvaluacionController {
	
	@Autowired
	private EvaluacionServiceImp evaluacionServiceImp;
	
	
	@GetMapping
	public ResponseEntity<List<Evaluacion>> getAll(){
		List<Evaluacion> evaluaciones = evaluacionServiceImp.findAll();
		return ResponseEntity.ok(evaluaciones);
	}

}
