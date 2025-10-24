package com.imb2025.calificaciones.dto.response;

import com.imb2025.calificaciones.enums.EstadoInscripcionMateria;

public class InscripcionMateriaResponseDto {
    private Long id;
    private Long version;

    private AlumnoResponseDto alumno;
    private MateriaResponseDto materia;
    private PeriodoLectivoResponseDto periodoLectivo;
    private Boolean inscripto;
    private String identificadorLegible; 
    private EstadoInscripcionMateria estado;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getVersion() {
        return version;
    }
    public void setVersion(Long version) {
        this.version = version;
    }
    public AlumnoResponseDto getAlumno() {
        return alumno;
    }
    public void setAlumno(AlumnoResponseDto alumno) {
        this.alumno = alumno;
    }
    public MateriaResponseDto getMateria() {
        return materia;
    }
    public void setMateria(MateriaResponseDto materia) {
        this.materia = materia;
    }
    public PeriodoLectivoResponseDto getPeriodoLectivo() {
        return periodoLectivo;
    }
    public void setPeriodoLectivo(PeriodoLectivoResponseDto periodoLectivo) {
        this.periodoLectivo = periodoLectivo;
    }
    public Boolean getInscripto() {
        return inscripto;
    }
    public void setInscripto(Boolean inscripto) {
        this.inscripto = inscripto;
    }
    public String getIdentificadorLegible() {
        return identificadorLegible;
    }
    public void setIdentificadorLegible(String identificadorLegible) {
        this.identificadorLegible = identificadorLegible;
    }
    public EstadoInscripcionMateria getEstado() {
        return estado;
    }
    public void setEstado(EstadoInscripcionMateria estado) {
        this.estado = estado;
    }
    
}
