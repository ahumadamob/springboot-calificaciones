package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.entity.Asistencia;

import java.util.List;


public interface IAsistenciaService {

    public List<Asistencia> findAll();

    public Asistencia findById(Long id);

    public Asistencia save(Asistencia asistencia);

    public void deleteById(Long id);
}
