package com.imb2025.calificaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imb2025.calificaciones.entity.Alumno;

import java.time.LocalDate;
import java.util.List;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    List<Alumno> findByApellido(String apellido);

    long countByEmail(String email); 
    List<Alumno> findByAtributoBooleanoTrue();

    List<Alumno> findByAtributoBooleanoFalse();


	List<Alumno> findByFechaBajaNotNull(LocalDate fechaBaja);

	List<Alumno> findByFechaBajaIsNull(LocalDate fechaBaja);
}