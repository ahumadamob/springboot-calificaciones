package com.imb2025.calificaciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imb2025.calificaciones.entity.Docente;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Long> {

    List<Docente> findByApellido(String apellido);

    Long countByTitulo(String titulo);

    Docente findByLegajo(Long legajo);

    List<Docente> findByActivoTrue();

    List<Docente> findByActivoFalse();
}
