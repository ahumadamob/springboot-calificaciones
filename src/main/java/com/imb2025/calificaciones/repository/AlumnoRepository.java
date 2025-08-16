package com.imb2025.calificaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imb2025.calificaciones.entity.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}

