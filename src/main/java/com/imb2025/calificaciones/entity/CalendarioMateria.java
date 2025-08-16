package com.imb2025.calificaciones.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class CalendarioMateria {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private LocalDate fechaInicio;
        private LocalDate fechaFin;

        @ManyToOne
        private Materia materia;

        @ManyToOne
        private Comision comision;

        // CONSTRUCTORES

        public CalendarioMateria() {
        }

        public CalendarioMateria(Long id, LocalDate fechaInicio, LocalDate fechaFin, Materia materia, Comision comision) {
                this.id = id;
                this.fechaInicio = fechaInicio;
                this.fechaFin = fechaFin;
                this.materia = materia;
                this.comision = comision;
        }

        public CalendarioMateria(LocalDate fechaInicio, LocalDate fechaFin, Materia materia, Comision comision) {
                this.fechaInicio = fechaInicio;
                this.fechaFin = fechaFin;
                this.materia = materia;
                this.comision = comision;
        }

        // GETTERS & SETTERS

        public Long getId() {
                return id;
        }
        public void setId(Long id) {
                this.id = id;
        }

        public LocalDate getFechaInicio() {
                return fechaInicio;
        }

        public void setFechaInicio(LocalDate fechaInicio) {
                this.fechaInicio = fechaInicio;
        }

        public LocalDate getFechaFin() {
                return fechaFin;
        }

        public void setFechaFin(LocalDate fechaFin) {
                this.fechaFin = fechaFin;
        }

        public Materia getMateria() {
                return materia;
        }

        public void setMateria(Materia materia) {
                this.materia = materia;
        }

        public Comision getComision() {
                return comision;
        }

        public void setComision(Comision comision) {
                this.comision = comision;
        }
}
