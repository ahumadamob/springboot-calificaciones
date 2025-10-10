package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.entity.PeriodoLectivo;

import java.time.LocalDate;
import java.util.List;

public interface IPeriodoLectivoService {

    public List<PeriodoLectivo> findAll();
    
    public List<PeriodoLectivo> findAllByNombre(String nombre);
    
    public long countByFechaInicioAndFechaFin(LocalDate inicio, LocalDate fin);

    public PeriodoLectivo create(PeriodoLectivo periodoLectivo);

    public PeriodoLectivo update(PeriodoLectivo periodoLectivo, Long id) throws Exception;

    public PeriodoLectivo findById(Long id);

    public void deleteById(Long id) throws Exception;
}
