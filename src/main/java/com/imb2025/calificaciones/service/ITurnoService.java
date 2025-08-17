package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.TurnoRequestDto;
import com.imb2025.calificaciones.entity.Turno;
import java.util.List;

public interface ITurnoService {

    public List<Turno> findAll();

    public Turno create(Turno turno);

    public Turno update(Turno turno, Long id) throws Exception;

    public Turno findById(Long id);

    public void deleteById(Long id);

    public Turno fromDto(TurnoRequestDto dto) throws Exception;
}
