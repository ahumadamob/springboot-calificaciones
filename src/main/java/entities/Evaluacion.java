package entities;

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

	
	
	public Evaluacion() {
		super();
	}

	public Evaluacion(int id, Date fecha, int tipoEvaluacionId, int materiaId, int comisionId) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.tipoEvaluacionId = tipoEvaluacionId;
		this.materiaId = materiaId;
		this.comisionId = comisionId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getTipoEvaluacionId() {
		return tipoEvaluacionId;
	}

	public void setTipoEvaluacionId(int tipoEvaluacionId) {
		this.tipoEvaluacionId = tipoEvaluacionId;
	}

	public int getMateriaId() {
		return materiaId;
	}

	public void setMateriaId(int materiaId) {
		this.materiaId = materiaId;
	}

	public int getComisionId() {
		return comisionId;
	}

	public void setComisionId(int comisionId) {
		this.comisionId = comisionId;
	}
	
	
	
}
