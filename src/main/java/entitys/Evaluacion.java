package entitys;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Evaluacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column (name = "fecha_evaluacion")
	private Date fecha;
	
	@Column (name = "tipo_evalucion_id")
	private int tipoEvaluacionId;
	
	@Column (name = "materia_id")
	private int materiaId;
	
	@Column (name = "comision_id")
	private int comisionId;
	
}
