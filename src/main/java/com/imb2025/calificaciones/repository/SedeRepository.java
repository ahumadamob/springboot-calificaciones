package com.imb2025.calificaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.imb2025.calificaciones.entity.Sede;
import java.util.List;

public interface SedeRepository extends JpaRepository<Sede, Long> {
    List<Sede> findByNombreIgnoreCase(String nombre);
    long countByDireccionIgnoreCase(String direccion);


    List<Sede> findByActivaTrue();
    List<Sede> findByActivaFalse();
}

