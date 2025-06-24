package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.entity.Alumno;

import java.util.List;

public interface IAlumnoServices {

    public Alumno update(Long id, Alumno datosActualizados) throws Exception;

    public List<Alumno> findAll();

    public boolean existsById(Long id);

    public Alumno findById(Long id);

    public Alumno create(Alumno nuevoAlumno) throws Exception;

    public void deleteById(Long id);
}
