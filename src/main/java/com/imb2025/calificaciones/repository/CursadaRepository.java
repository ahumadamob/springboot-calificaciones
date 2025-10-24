package com.imb2025.calificaciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imb2025.calificaciones.entity.Cursada;

public interface CursadaRepository extends JpaRepository<Cursada, Long> {
	
    List<Cursada> findByAlumno_Nombre(String nombre);
    
    Long countByMateria_Nombre(String nombreMateria);
    
    List<Cursada> findByRegularTrue();
    
    List<Cursada> findByRegularFalse();


}


