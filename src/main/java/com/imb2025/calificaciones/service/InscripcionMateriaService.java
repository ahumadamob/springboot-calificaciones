package com.imb2025.calificaciones.service;

import java.util.List;

import com.imb2025.calificaciones.entity.InscripcionMateria;

public interface InscripcionMateriaService {
    InscripcionMateria findById(Long id);
    List<InscripcionMateria> findAll();
    InscripcionMateria save(InscripcionMateria inscripcionMateria);
    InscripcionMateria update(Long id, InscripcionMateria inscripcionMateria);
    void deleteById(Long id);
}
