package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.MateriaRequestDto;
import com.imb2025.calificaciones.entity.Materia;
import java.util.List;

public interface IMateriaService {

    public List<Materia> findAll();

    public Materia findById(Long id);

    public Materia create(MateriaRequestDto dto);

    public Materia update(Long id, MateriaRequestDto dto) throws Exception;

    public void deleteById(Long id);

    public Materia fromDto(MateriaRequestDto dto) throws Exception;
}
