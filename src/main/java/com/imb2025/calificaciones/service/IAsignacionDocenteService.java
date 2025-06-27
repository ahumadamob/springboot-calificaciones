package com.imb2025.calificaciones.service;

import java.util.List;

import com.imb2025.calificaciones.entity.AsignacionDocente;

public interface IAsignacionDocenteService {

    AsignacionDocente findById(Long id);

    List<AsignacionDocente> findAll();

    AsignacionDocente save(AsignacionDocente asignacionDocente);

    AsignacionDocente update(Long id, AsignacionDocente asignacionDocente) throws Exception;

    void deleteById(Long id) throws Exception;

}