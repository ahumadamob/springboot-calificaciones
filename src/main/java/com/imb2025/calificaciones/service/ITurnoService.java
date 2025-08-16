package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.TurnoRequestDto;
import com.imb2025.calificaciones.entity.Turno;
import java.util.List;

public interface ITurnoService {

    public List<Turno> findAll();

    public Turno findById(Long id);

    public Turno create(TurnoRequestDto dto);

    public Turno update(Long id, TurnoRequestDto dto) throws Exception;

    public void deleteById(Long id) throws Exception;

    public Turno fromDto(TurnoRequestDto dto);
}
