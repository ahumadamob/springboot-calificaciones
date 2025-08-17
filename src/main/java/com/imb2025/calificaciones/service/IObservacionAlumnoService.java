package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.ObservacionAlumnoRequestDto;
import com.imb2025.calificaciones.entity.ObservacionAlumno;
import java.util.List;

public interface IObservacionAlumnoService {

    public List<ObservacionAlumno> findAll();

    public ObservacionAlumno create(ObservacionAlumno observacionAlumno);

    public ObservacionAlumno update(ObservacionAlumno observacionAlumno, Long id) throws Exception;

    public ObservacionAlumno findById(Long id);

    public void deleteById(Long id) throws Exception;

    public ObservacionAlumno fromDto(ObservacionAlumnoRequestDto dto) throws Exception;
}
