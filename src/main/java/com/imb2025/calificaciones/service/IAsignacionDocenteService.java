package com.imb2025.calificaciones.service;

import java.util.List;

import com.imb2025.calificaciones.entity.AsignacionDocente;
import com.imb2025.calificaciones.dto.AsignacionDocenteRequestDTO;

public interface IAsignacionDocenteService {

    AsignacionDocente findById(Long id);

    List<AsignacionDocente> findAll();

    AsignacionDocente save(AsignacionDocente asignacionDocente);

    AsignacionDocente update(Long id, AsignacionDocenteRequestDTO dto);

    void deleteById(Long id);

}