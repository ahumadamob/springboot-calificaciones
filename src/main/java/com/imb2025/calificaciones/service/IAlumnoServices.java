package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.entity.Alumno;

import java.util.List;


public interface IAlumnoServices {

    public List<Alumno> getAll();

    public Alumno save(Alumno nuevoAlumno);

    public Alumno update(Long id, Alumno datosActualizados);

    public void delete(Long id);

    public Alumno findById(Long id);
}
