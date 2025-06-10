package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.DTO.AlumnoRequestDTO;
import com.imb2025.calificaciones.entity.Alumno;

import java.util.List;
import java.util.Optional;


public interface IAlumnoServices {
    Alumno saveFromDTO(AlumnoRequestDTO dto);

    Alumno updateFromDTO(Long id, AlumnoRequestDTO dto);

    Alumno findById(Long id);

    void delete(Long id);

    List<Alumno> getAll();


    
}
