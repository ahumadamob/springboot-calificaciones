package services;
import entities.Evaluacion;
import java.util.List;

public interface EvaluacionService {

	List<Evaluacion> findAll();
	Evaluacion findById(int id);
	
	
}
