package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.HorarioRequestDto;
import com.imb2025.calificaciones.entity.Horario;
import java.util.List;

public interface IHorarioService {

    public List<Horario> findAll();

    public Horario create(Horario horario);

    public Horario update(Horario horario, Long id);

    public Horario findById(Long id);

    public void deleteById(Long id);

    public Horario fromDto(HorarioRequestDto dto) throws Exception;
}
