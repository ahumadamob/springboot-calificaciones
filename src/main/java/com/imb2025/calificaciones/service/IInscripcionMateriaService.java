package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.InscripcionMateriaRequestDto;
import com.imb2025.calificaciones.entity.InscripcionMateria;
import java.util.List;

public interface IInscripcionMateriaService {

    public List<InscripcionMateria> findAll();

    public InscripcionMateria create(InscripcionMateria inscripcionMateria);

    public InscripcionMateria update(InscripcionMateria inscripcionMateria, Long id);

    public InscripcionMateria findById(Long id);

    public void deleteById(Long id);

    public InscripcionMateria fromDto(InscripcionMateriaRequestDto dto) throws Exception;
}
