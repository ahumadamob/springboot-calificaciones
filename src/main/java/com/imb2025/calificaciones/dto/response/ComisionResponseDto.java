package com.imb2025.calificaciones.dto.response;

public class ComisionResponseDto {

    private Long id;
    private String nombre;
    private Long turnoId;
    private Long sedeId;
    private Long version;

    public ComisionResponseDto() {}

    public ComisionResponseDto(Long id, String nombre, Long turnoId, Long sedeId, Long version) {
        this.id = id;
        this.nombre = nombre;
        this.turnoId = turnoId;
        this.sedeId = sedeId;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Long getTurnoId() {
        return turnoId;
    }

    public Long getSedeId() {
        return sedeId;
    }

    public Long getVersion() {
        return version;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTurnoId(Long turnoId) {
        this.turnoId = turnoId;
    }

    public void setSedeId(Long sedeId) {
        this.sedeId = sedeId;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
