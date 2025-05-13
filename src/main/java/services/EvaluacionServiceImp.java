package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import entities.Evaluacion;
import repositories.EvaluacionRepository;

@Service
public class EvaluacionServiceImp {
	
	@Autowired
	private EvaluacionRepository evaluacionRepository;
	
	public List<Evaluacion> findAll(){
		return evaluacionRepository.findAll();
	}
	
	public Evaluacion findById(int id) {
		return evaluacionRepository.findById(id).orElse(null);
	}
}
