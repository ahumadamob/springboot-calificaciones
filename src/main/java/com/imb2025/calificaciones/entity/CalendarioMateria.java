package com.imb2025.calificaciones.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;

@Entity
public class CalendarioMateria extends BaseEntity{


        private LocalDate fechaInicio;
        private LocalDate fechaFin;
        @Enumerated(EnumType.STRING)
        private EstadoCalendarioMateria estado;

        @ManyToOne
        private Materia materia;

        @ManyToOne
        private Comision comision;

        public enum EstadoCalendarioMateria {
            ACTIVO, INACTIVO
        }

        // CONSTRUCTORES

        public CalendarioMateria() {
        }

        public CalendarioMateria(LocalDate fechaInicio, LocalDate fechaFin, Materia materia, Comision comision, EstadoCalendarioMateria estado) {
                this.fechaInicio = fechaInicio;
                this.fechaFin = fechaFin;
                this.materia = materia;
                this.comision = comision;
                this.estado = estado;
        }

        // GETTERS & SETTERS

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

        public EstadoCalendarioMateria getEstado() {
            return estado;
        }

        public void setEstado(EstadoCalendarioMateria estado) {
            this.estado = estado;
        }
}
