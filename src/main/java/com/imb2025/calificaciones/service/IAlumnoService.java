package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.AlumnoRequestDto;
import com.imb2025.calificaciones.entity.Alumno;
import java.util.List;

public interface IAlumnoService {

    public List<Alumno> findAll();

    public Alumno findById(Long id);

    public Alumno create(AlumnoRequestDto dto) throws Exception;

    public Alumno update(Long id, AlumnoRequestDto dto) throws Exception;

    public void deleteById(Long id);

    public Alumno fromDto(AlumnoRequestDto dto);
}

