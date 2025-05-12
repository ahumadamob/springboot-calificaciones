package com.imb2025.calificaciones.service;

import java.util.List;

import com.imb2025.calificaciones.entity.AsignacionDocente;

public interface AsignacionDocenteService {

    AsignacionDocente findById(Long id);

    List<AsignacionDocente> findAll();

    AsignacionDocente save(AsignacionDocente asignacionDocente);

    AsignacionDocente update(Long id, AsignacionDocente asignacionDocente);

    void deleteById(Long id);

}