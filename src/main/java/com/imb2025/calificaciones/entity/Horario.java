package com.imb2025.calificaciones.entity;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Horario {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	@Column(name = "comisionId")
	private int comisionId;
	
	@Column(name = "diaSemana")
	private String diaSemana;
	
	@Column(name = "horarioInicio")
	@JsonFormat(pattern = "HH:mm")
	private LocalTime horarioInicio;
	
	@Column(name = "horarioFin")
	@JsonFormat(pattern = "HH:mm")
	private LocalTime horaFin;

	public int getComisionId() {
		return comisionId;
	}

	public void setComisionId(int comisionId) {
		this.comisionId = comisionId;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public LocalTime getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(LocalTime horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public LocalTime getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}
	
	
	
	
}
