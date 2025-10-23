package com.imb2025.calificaciones.repository;

import java.util.List;
<<<<<<< HEAD

import org.springframework.data.jpa.repository.JpaRepository;

import com.imb2025.calificaciones.entity.TipoEvaluacion;

public interface TipoEvaluacionRepository extends JpaRepository<TipoEvaluacion, Long> {
	
	 List<TipoEvaluacion> findByNombreContainingIgnoreCase(String nombre);
	 
	 long countByNombreContainingIgnoreCase(String nombre);
	
}

=======
import org.springframework.data.jpa.repository.JpaRepository;
import com.imb2025.calificaciones.entity.TipoEvaluacion;

public interface TipoEvaluacionRepository extends JpaRepository<TipoEvaluacion, Long> {

   
    List<TipoEvaluacion> findByNombreContainingIgnoreCase(String nombre);

    long countByNombreContainingIgnoreCase(String nombre);
    
}
>>>>>>> f92b8fc (TP07: métodos mágicos)
