package com.imb2025.calificaciones.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imb2025.calificaciones.entity.Evaluacion;

@Repository
public interface EvaluacionRepository extends JpaRepository<Evaluacion, Long> {
	List<Evaluacion> findByFechaBetween(Date fechaInicio, Date fechaFin);

	List<Evaluacion> findByMateriaIdAndComisionId(long materiaId, long comisionId);

	long countByMateriaIdAndComisionId(long materiaId, long comisionId);

	long countByEstado(Evaluacion.Estado estado);
}
