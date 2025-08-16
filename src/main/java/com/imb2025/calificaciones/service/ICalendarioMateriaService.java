package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.CalendarioMateriaRequestDto;
import com.imb2025.calificaciones.entity.CalendarioMateria;
import java.util.List;

public interface ICalendarioMateriaService {

    public List<CalendarioMateria> findAll();

    public CalendarioMateria findById(Long id);

    public CalendarioMateria create(CalendarioMateriaRequestDto dto);

    public CalendarioMateria update(Long id, CalendarioMateriaRequestDto dto) throws Exception;

    public void deleteById(Long id);

    public CalendarioMateria fromDto(CalendarioMateriaRequestDto dto) throws Exception;
}
