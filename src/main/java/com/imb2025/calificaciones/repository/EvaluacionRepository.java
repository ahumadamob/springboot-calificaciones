package com.imb2025.calificaciones.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imb2025.calificaciones.entities.Evaluacion;


@Repository
public interface EvaluacionRepository extends JpaRepository<Evaluacion, Integer> {

	
}
