package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.AlumnoRequestDTO;
import com.imb2025.calificaciones.entity.Alumno;

import java.util.List;

public interface IAlumnoServices {

    public Alumno update(Long id, AlumnoRequestDTO datosActualizados) throws Exception;

    public List<Alumno> findAll();

    public boolean existsById(Long id);

    public Alumno findById(Long id);

    public Alumno create(AlumnoRequestDTO nuevoAlumno) throws Exception;

    public void deleteById(Long id);
    
    public Alumno mapFromDTO(AlumnoRequestDTO alumnoDto);
}
