package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.AsistenciaRequestDto;
import com.imb2025.calificaciones.entity.Asistencia;
import java.util.List;

public interface IAsistenciaService {

    public List<Asistencia> findAll();

    public Asistencia create(AsistenciaRequestDto dto) throws Exception;

    public Asistencia update(AsistenciaRequestDto dto, Long id) throws Exception;

    public Asistencia findById(Long id);

    public void deleteById(Long id) throws Exception;

    public Asistencia fromDto(AsistenciaRequestDto dto) throws Exception;
}
