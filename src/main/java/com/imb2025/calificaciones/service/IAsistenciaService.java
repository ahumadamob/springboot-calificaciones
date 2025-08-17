package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.AsistenciaRequestDto;
import com.imb2025.calificaciones.entity.Asistencia;
import java.util.List;

public interface IAsistenciaService {

    public List<Asistencia> findAll();

    public Asistencia create(Asistencia asistencia);

    public Asistencia update(Asistencia asistencia, Long id);

    public Asistencia findById(Long id);

    public void deleteById(Long id);

    public Asistencia fromDto(AsistenciaRequestDto dto) throws Exception;
}
