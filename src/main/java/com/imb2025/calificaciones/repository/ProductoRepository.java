package com.imb2025.calificaciones.repository;

import com.imb2025.calificaciones.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findByFechaVigenciaGreaterThanEqual(LocalDate fecha);

    List<Producto> findByFechaVigenciaLessThan(LocalDate fecha);
}