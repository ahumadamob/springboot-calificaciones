package com.imb2025.calificaciones;

import java.util.List;
import java.util.Optional;


public interface AlumnoServices {

    List<Alumno> getAll();

    Alumno save(Alumno nuevoAlumno);

    Alumno update(Long id, Alumno datosActualizados);

    void delete(Long id);

    Optional<Alumno> findById(Long id);
}
