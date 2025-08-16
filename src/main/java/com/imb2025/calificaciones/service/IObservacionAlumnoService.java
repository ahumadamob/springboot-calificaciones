package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.ObservacionAlumnoRequestDto;
import com.imb2025.calificaciones.entity.ObservacionAlumno;
import java.util.List;

public interface IObservacionAlumnoService {

    public List<ObservacionAlumno> findAll();

    public ObservacionAlumno findById(Long id);

    public ObservacionAlumno create(ObservacionAlumnoRequestDto dto);

    public ObservacionAlumno update(Long id, ObservacionAlumnoRequestDto dto) throws Exception;

    public void deleteById(Long id);

    public ObservacionAlumno fromDto(ObservacionAlumnoRequestDto dto) throws Exception;
}
