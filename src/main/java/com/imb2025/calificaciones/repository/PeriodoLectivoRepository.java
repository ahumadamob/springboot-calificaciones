package com.imb2025.calificaciones.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imb2025.calificaciones.entity.PeriodoLectivo;

@Repository
public interface PeriodoLectivoRepository extends JpaRepository<PeriodoLectivo, Long> {
	List<PeriodoLectivo> findByNombreIgnoreCase(String nombre);
	long countByFechaInicioAfterAndFechaFinBefore(LocalDate fechaInicio, LocalDate fechaFin);
	List<PeriodoLectivo> findByDescripcionCortaContainingIgnoreCase(String texto);
}

