package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.PeriodoLectivoRequestDto;
import com.imb2025.calificaciones.entity.PeriodoLectivo;
import java.util.List;

public interface IPeriodoLectivoService {

    public List<PeriodoLectivo> findAll();

    public PeriodoLectivo create(PeriodoLectivo periodoLectivo);

    public PeriodoLectivo update(PeriodoLectivo periodoLectivo, Long id) throws Exception;

    public PeriodoLectivo findById(Long id);

    public void deleteById(Long id) throws Exception;

    public PeriodoLectivo fromDto(PeriodoLectivoRequestDto dto) throws Exception;
}
