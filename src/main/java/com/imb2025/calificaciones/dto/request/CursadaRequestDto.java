package com.imb2025.calificaciones.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CursadaRequestDto {

	@NotNull(message = "El ID del alumno es obligatorio")
    @Positive(message = "El ID del alumno debe ser un número positivo")
	private Long alumnoId;
	
	@NotNull(message = "El ID de la materia es obligatorio")
	@Positive(message = "El ID de la materia debe ser un número positivo")
    private Long materiaId;
	 
	@NotNull(message = "El ID del año lectivo es obligatorio")
	@Positive(message = "El ID del año lectivo debe ser un número positivo")
    private Long anioLectivoId;
	 
	@NotNull(message = "El ID del año lectivo es obligatorio")
	@Positive(message = "El ID del año lectivo debe ser un número positivo")
    private Long condicionFinalId;

    public Long getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(Long alumnoId) {
        this.alumnoId = alumnoId;
    }

    public Long getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(Long materiaId) {
        this.materiaId = materiaId;
    }

    public Long getAnioLectivoId() {
        return anioLectivoId;
    }

    public void setAnioLectivoId(Long anioLectivoId) {
        this.anioLectivoId = anioLectivoId;
    }

    public Long getCondicionFinalId() {
        return condicionFinalId;
    }

    public void setCondicionFinalId(Long condicionFinalId) {
        this.condicionFinalId = condicionFinalId;
    }
}
