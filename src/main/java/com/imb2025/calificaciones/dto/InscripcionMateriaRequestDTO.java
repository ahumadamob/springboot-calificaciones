package com.imb2025.calificaciones.dto;


public class InscripcionMateriaRequestDTO {
    
   private Long idAlumno;
   private Long idMateria;
   private Long idPeriodoLectivo;

   public Long getIdAlumno() {
    return idAlumno;
   }
   public void setIdAlumno(Long idAlumno) {
    this.idAlumno = idAlumno;
   }
   public Long getIdMateria() {
    return idMateria;
   }
   public void setIdMateria(Long idMateria) {
    this.idMateria = idMateria;
   }
   public Long getIdPeriodoLectivo() {
    return idPeriodoLectivo;
   }
   public void setIdPeriodoLectivo(Long idPeriodoLectivo) {
    this.idPeriodoLectivo = idPeriodoLectivo;
   }

   
}
