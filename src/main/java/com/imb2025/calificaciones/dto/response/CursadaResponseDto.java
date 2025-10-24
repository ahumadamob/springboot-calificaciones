package com.imb2025.calificaciones.dto.response;

public class CursadaResponseDto {
    private Long id;
    private Long alumnoId;
    private Long materiaId;
    private Long anioLectivoId;
    private Long condicionFinalId;
    private boolean regular;
    private Integer version;

    public CursadaResponseDto() {
    }

    public CursadaResponseDto(Long id, Long alumnoId, Long materiaId, Long anioLectivoId, Long condicionFinalId, boolean regular, Integer version) {
        this.id = id;
        this.alumnoId = alumnoId;
        this.materiaId = materiaId;
        this.anioLectivoId = anioLectivoId;
        this.condicionFinalId = condicionFinalId;
        this.version = version;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getAlumnoId() { return alumnoId; }
    public void setAlumnoId(Long alumnoId) { this.alumnoId = alumnoId; }

    public Long getMateriaId() { return materiaId; }
    public void setMateriaId(Long materiaId) { this.materiaId = materiaId; }

    public Long getAnioLectivoId() { return anioLectivoId; }
    public void setAnioLectivoId(Long anioLectivoId) { this.anioLectivoId = anioLectivoId; }

    public Long getCondicionFinalId() { return condicionFinalId; }
    public void setCondicionFinalId(Long condicionFinalId) { this.condicionFinalId = condicionFinalId; }
    
    public boolean isRegular() { return regular; }
    public void setRegular(boolean regular) { this.regular = regular; }

    public Integer getVersion() { return version; }
    public void setVersion(Integer version) { this.version = version; }
}

