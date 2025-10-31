package com.imb2025.calificaciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imb2025.calificaciones.entity.Alumno;
import com.imb2025.calificaciones.entity.Docente;
import com.imb2025.calificaciones.entity.ObservacionAlumno;

@Repository
public interface ObservacionAlumnoRepository extends JpaRepository<ObservacionAlumno, Long> {
	
		List<ObservacionAlumno> findByDocente(Docente docente);
		Long countByAlumno(Alumno alumno);
}

