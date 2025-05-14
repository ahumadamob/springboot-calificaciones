package services;
import entities.Evaluacion;
import java.util.List;

public interface EvaluacionService {

	List<Evaluacion> findAll(); //Todos las evaluaciones GET ALL
	Evaluacion findById(int id); //Encontrar una Evaluacion por id GET ID
	Evaluacion save(Evaluacion evaluacion); //Crear y guardar Evaluacion POST
	Evaluacion update(int id, Evaluacion evaluacion); //Actualizar Evaluacion PUT
	void delete(int id);  //Eliminar Evaluacion
	
}
