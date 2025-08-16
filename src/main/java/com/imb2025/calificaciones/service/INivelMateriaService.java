package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.NivelMateriaRequestDto;
import com.imb2025.calificaciones.entity.NivelMateria;
import java.util.List;

public interface INivelMateriaService {

    public List<NivelMateria> findAll();

    public NivelMateria findById(Long id);

    public NivelMateria create(NivelMateriaRequestDto dto);

    public NivelMateria update(Long id, NivelMateriaRequestDto dto);

    public void deleteById(Long id);

    public NivelMateria fromDto(NivelMateriaRequestDto dto);
}
