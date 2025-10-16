package com.imb2025.calificaciones.dto;

import java.util.Date;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

public class EvaluacionRequestDto {
	
	public interface Creacion{}

	@Future(message = "La Fecha de Evaluación debe ser en los dias posteriores", groups = Creacion.class)
	@NotNull(message = "Debe asignar una Fecha de Evaluacón")
    private Date fechaEvaluacion;
    
    @NotNull(message = "Debe asignar el Tipo de Evaluación")
    private Long tipoEvaluacionId;
    
    @NotNull(message = "Debe asignar a que Materia pertenece")
    private Long materiaId;
    
    @NotNull(message = "Debe asignar a cual Comisión pertenece")
    private Long comisionId;
    
    public EvaluacionRequestDto() {}

    public Date getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(Date fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }

    public Long getTipoEvaluacionId() {
        return tipoEvaluacionId;
    }

    public void setTipoEvaluacionId(Long tipoEvaluacionId) {
        this.tipoEvaluacionId = tipoEvaluacionId;
    }

    public Long getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(Long materiaId) {
        this.materiaId = materiaId;
    }

    public Long getComisionId() {
        return comisionId;
    }

    public void setComisionId(Long comisionId) {
        this.comisionId = comisionId;
    }
}
