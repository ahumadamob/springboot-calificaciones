package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.CalendarioMateriaRequestDto;
import com.imb2025.calificaciones.entity.CalendarioMateria;

import java.time.LocalDate;
import java.util.List;

public interface ICalendarioMateriaService {

    public List<CalendarioMateria> findAll();

    public CalendarioMateria create(CalendarioMateria calendarioMateria);

    public CalendarioMateria update(CalendarioMateria calendarioMateria, Long id) throws Exception;

    public CalendarioMateria findById(Long id);

    public void deleteById(Long id) throws Exception;

    public List<CalendarioMateria> findByMateriaId(Long materiaId);

    public Long countByComisionId(Long comisionId);

    public CalendarioMateria fromDto(CalendarioMateriaRequestDto dto) throws Exception;
}
