package com.imb2025.calificaciones.service;

import java.util.List;

import com.imb2025.calificaciones.dto.ObservacionAlumnoRequestDto;
import com.imb2025.calificaciones.entity.Alumno;
import com.imb2025.calificaciones.entity.Docente;
import com.imb2025.calificaciones.entity.ObservacionAlumno;

public interface IObservacionAlumnoService {

    public List<ObservacionAlumno> findAll();

    public ObservacionAlumno create(ObservacionAlumno observacionAlumno);

    public ObservacionAlumno update(ObservacionAlumno observacionAlumno, Long id) throws Exception;

    public ObservacionAlumno findById(Long id);

    public void deleteById(Long id) throws Exception;

    public ObservacionAlumno fromDto(ObservacionAlumnoRequestDto dto) throws Exception;
    
    public List<ObservacionAlumno> findByDocente(Docente docente);
    
    public Long countByAlumno(Alumno alumno);
    
     
}
