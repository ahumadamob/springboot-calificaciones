package com.imb2025.calificaciones.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PlanEstudio extends BaseEntity {

   

    @ManyToOne
    @JoinColumn(name = "carrera_id")
    private Carrera carrera;

    private String nombre;

    private int anioVigencia;

    private boolean activo; 
    
    public PlanEstudio() {
    }

    public PlanEstudio(Carrera carrera, String nombre, int anioVigencia, boolean activo) {
        this.carrera = carrera;
        this.nombre = nombre;
        this.anioVigencia = anioVigencia;
        this.activo = activo; 
    }

   

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnioVigencia() {
        return anioVigencia;
    }

    public void setAnioVigencia(int anioVigencia) {
        this.anioVigencia = anioVigencia;
    }

	
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
	
}
