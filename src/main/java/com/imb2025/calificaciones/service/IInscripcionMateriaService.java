package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.entity.InscripcionMateria;

import java.time.LocalDate;
import java.util.List;

public interface IInscripcionMateriaService {

    public List<InscripcionMateria> findAll();

    public List<InscripcionMateria> findByAlumno_Id(Long idAlumno);

    public long countByAlumno_Id(Long idAlumno);

    public InscripcionMateria create(InscripcionMateria inscripcionMateria) throws Exception;

    public InscripcionMateria update(InscripcionMateria inscripcionMateria, Long id) throws Exception;

    public InscripcionMateria findById(Long id);
    
    public List<InscripcionMateria> findByInscriptoTrue();

    public List<InscripcionMateria> findByInscriptoFalse();

    public void deleteById(Long id) throws Exception;

    public List<InscripcionMateria> findByFechaVigenciaGreaterThanEqual(LocalDate fecha);
    public List<InscripcionMateria> findByFechaVigenciaLessThan(LocalDate fecha);
    public List<InscripcionMateria> findVigentes();
    public List<InscripcionMateria> findVencidos();

    public long countActivos();
    public long countInactivos();

}
