package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.DTO.AlumnoRequestDTO;
import com.imb2025.calificaciones.entity.Alumno;

import java.util.List;

public interface IAlumnoServices {
    Alumno create(Alumno alumno);

    Alumno update(Long id, Alumno alumno) throws Exception;

    Alumno findById(Long id);

    void deleteById(Long id);

    List<Alumno> getAll();

    public Alumno mapFromDTO(AlumnoRequestDTO alumnoDto);
    
}
