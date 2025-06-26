package com.imb2025.calificaciones.service;

import java.util.List;

import com.imb2025.calificaciones.dto.InscripcionMateriaRequestDTO;
import com.imb2025.calificaciones.entity.InscripcionMateria;

public interface IInscripcionMateriaService {
    InscripcionMateria findById(Long id);
    List<InscripcionMateria> findAll();
    InscripcionMateria create(InscripcionMateria inscripcionMateria);
    InscripcionMateria update(Long id,InscripcionMateria inscripcionMateria) throws Exception;
    void deleteById(Long id);
    InscripcionMateria mapFromDto(InscripcionMateriaRequestDTO inscripcionMateriaDTO) throws Exception;
}
