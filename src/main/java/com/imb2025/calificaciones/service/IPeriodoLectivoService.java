package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.PeriodoLectivoRequestDto;
import com.imb2025.calificaciones.entity.PeriodoLectivo;
import java.util.List;

public interface IPeriodoLectivoService {

    public List<PeriodoLectivo> findAll();

    public PeriodoLectivo findById(Long id);

    public PeriodoLectivo create(PeriodoLectivoRequestDto dto);

    public PeriodoLectivo update(Long id, PeriodoLectivoRequestDto dto) throws Exception;

    public void deleteById(Long id) throws Exception;

    public PeriodoLectivo fromDto(PeriodoLectivoRequestDto dto);
}
