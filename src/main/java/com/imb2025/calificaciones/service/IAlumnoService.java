package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.AlumnoRequestDto;
import com.imb2025.calificaciones.entity.Alumno;
import java.util.List;

public interface IAlumnoService {

    public List<Alumno> findAll();

    public Alumno create(Alumno alumno);

    public Alumno update(Alumno alumno, Long id) throws Exception;

    public Alumno findById(Long id);

    public void deleteById(Long id) throws Exception;

    public Alumno fromDto(AlumnoRequestDto dto) throws Exception;
}
