package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.entity.Sede;
import java.util.List;

public interface ISedeService {

    List<Sede> findAll();

    Sede create(Sede sede) throws Exception;

    Sede update(Sede sede, Long id) throws Exception;

    Sede findById(Long id);

    void deleteById(Long id) throws Exception;

    boolean existsById(Long id);

    List<Sede> findByNombreIgnoreCase(String nombre);

    long countByDireccionIgnoreCase(String direccion);

    // Nuevos para listar sedes activas e inactivas
    List<Sede> findByActivaTrue();
    List<Sede> findByActivaFalse();
}
