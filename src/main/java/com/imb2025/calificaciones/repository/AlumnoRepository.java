package com.imb2025.calificaciones.repository;

import com.imb2025.calificaciones.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
