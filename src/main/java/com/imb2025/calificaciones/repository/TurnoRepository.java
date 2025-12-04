package com.imb2025.calificaciones.repository;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imb2025.calificaciones.entity.Turno;

public interface TurnoRepository extends JpaRepository<Turno, Long> {
	
	List<Turno> findByNombre(String nombre);
	Long countByHoraFinAfter(LocalTime hora);
	List<Turno> findByPrioridadGreaterThanEqual(int prioridad);
	List<Turno> findByPrioridadLessThanEqual(int prioridad);
}

