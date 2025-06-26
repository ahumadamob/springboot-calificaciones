package com.imb2025.calificaciones.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "plan_estudio")


public class PlanEstudio {
	
	

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "carrera_id", nullable = false)
	    private Long carreraId;

	    @Column(nullable = false)
	    private String nombre;

	    @Column(name = "anio_vigencia", nullable = false)
	    private int anioVigencia;

	    
	    public Long getId() { return id; }

	    public void setId(Long id) { this.id = id; }

	    public Long getCarreraId() { return carreraId; }

	    public void setCarreraId(Long carreraId) { this.carreraId = carreraId; }

	    public String getNombre() { return nombre; }

	    public void setNombre(String nombre) { this.nombre = nombre; }

	    public int getAnioVigencia() { return anioVigencia; }

	    public void setAnioVigencia(int anioVigencia) { this.anioVigencia = anioVigencia; }
	


}
