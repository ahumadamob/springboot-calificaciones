package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.AlumnoRequestDto;
import com.imb2025.calificaciones.entity.Alumno;
import java.util.List;

public interface IAlumnoServices {
    List<Alumno> findAll();
    boolean existsById(Long id);
    Alumno findById(Long id);
    Alumno create(AlumnoRequestDto dto);
    Alumno update(AlumnoRequestDto dto, Long id) throws Exception;
    void deleteById(Long id);
    Alumno fromDto(AlumnoRequestDto dto);
}
