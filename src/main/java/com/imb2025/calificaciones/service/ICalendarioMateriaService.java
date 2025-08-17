package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.CalendarioMateriaRequestDto;
import com.imb2025.calificaciones.entity.CalendarioMateria;
import java.util.List;

public interface ICalendarioMateriaService {

    public List<CalendarioMateria> findAll();

    public CalendarioMateria create(CalendarioMateria calendarioMateria);

    public CalendarioMateria update(CalendarioMateria calendarioMateria, Long id);

    public CalendarioMateria findById(Long id);

    public void deleteById(Long id);

    public CalendarioMateria fromDto(CalendarioMateriaRequestDto dto) throws Exception;
}
