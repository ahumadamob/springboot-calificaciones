package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.entity.Asistencia;
import java.util.List;

public interface IAsistenciaService {

    public List<Asistencia> findAll();

    public Asistencia create(Asistencia asistencia);

    public Asistencia update(Asistencia asistencia, Long id) throws Exception;

    public Asistencia findById(Long id);

    public boolean existsById(Long id);

    public void deleteById(Long id) throws Exception;

    long countByPresente(boolean presente);

    List<Asistencia> findByAlumnoNombreIgnoreCase(String nombre);

    
    List<Asistencia> findByTardanzaTrue();
    List<Asistencia> findByTardanzaFalse();
}
