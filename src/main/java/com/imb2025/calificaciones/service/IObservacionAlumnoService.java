package com.imb2025.calificaciones.service;

import java.util.List;

import com.imb2025.calificaciones.entity.Alumno;
import com.imb2025.calificaciones.entity.Docente;
import com.imb2025.calificaciones.entity.ObservacionAlumno;

public interface IObservacionAlumnoService {

    public List<ObservacionAlumno> findAll();

    public ObservacionAlumno create(ObservacionAlumno observacionAlumno, Long alumnoId, Long docenteId);

    ObservacionAlumno update(ObservacionAlumno observacionAlumno, Long id, Long alumnoId, Long docenteId);

    public ObservacionAlumno findById(Long id);

    public void deleteById(Long id) throws Exception;
    
    public List<ObservacionAlumno> findByDocente(Docente docente);
    
    public Long countByAlumno(Alumno alumno);
    
    public List<ObservacionAlumno> findByRevisadaTrue();
    
    public List<ObservacionAlumno> findByRevisadaFalse();
    
     
}
