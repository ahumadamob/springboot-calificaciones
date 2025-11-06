package com.imb2025.calificaciones.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
// importar el enum anidado de Comision
import com.imb2025.calificaciones.entity.Comision;

public class ComisionRequestDto {

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    private String nombre;

    @NotNull(message = "El id del turno es obligatorio")
    @Positive(message = "El id del turno debe ser un número positivo")
    private Long turnoId;

    @NotNull(message = "El id de la sede es obligatorio")
    @Positive(message = "El id de la sede debe ser un número positivo")
    private Long sedeId;

    @NotNull(message = "El estado es obligatorio")
    private Comision.Estado estado;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getTurnoId() {
        return turnoId;
    }

    public void setTurnoId(Long turnoId) {
        this.turnoId = turnoId;
    }

    public Long getSedeId() {
        return sedeId;
    }

    public void setSedeId(Long sedeId) {
        this.sedeId = sedeId;
    }

    public Comision.Estado getEstado() {
        return estado;
    }

    public void setEstado(Comision.Estado estado) {
        this.estado = estado;
    }
}
