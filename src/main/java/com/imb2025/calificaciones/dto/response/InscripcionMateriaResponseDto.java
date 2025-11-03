package com.imb2025.calificaciones.dto.response;

public class InscripcionMateriaResponseDto {
    private Long id;
    private Long version;

    private AlumnoResponseDto alumno;
    private MateriaResponseDto materia;
    private PeriodoLectivoResponseDto periodoLectivo;

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
}
