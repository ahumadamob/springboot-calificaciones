package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.AsistenciaRequestDTO;
import com.imb2025.calificaciones.entity.Asistencia;

import java.util.List;

public interface IAsistenciaService {

    List<Asistencia> findAll();

    Asistencia findById(Long id);

    Asistencia save(AsistenciaRequestDTO asistencia) throws Exception;

    Asistencia update(Long id, AsistenciaRequestDTO asistencia) throws Exception;

    void deleteById(Long id) throws Exception;
}
