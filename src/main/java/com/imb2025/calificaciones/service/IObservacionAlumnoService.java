package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.ObservacionAlumnoRequestDto;
import com.imb2025.calificaciones.entity.ObservacionAlumno;
import java.util.List;
import java.util.Optional;

public interface IObservacionAlumnoService {
    List<ObservacionAlumno> findAll();
    Optional<ObservacionAlumno> findById(Long id);
    ObservacionAlumno create(ObservacionAlumno observacionAlumno);
    ObservacionAlumno update(Long id, ObservacionAlumno observacionAlumno) throws Exception;
    void deleteById(Long id) throws Exception;
    ObservacionAlumno fromDTO(ObservacionAlumnoRequestDto dto);
}
