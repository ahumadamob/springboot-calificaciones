package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.NivelMateriaRequestDto;
import com.imb2025.calificaciones.entity.NivelMateria;
import java.util.List;

public interface INivelMateriaService {

    public List<NivelMateria> findAll();

    public NivelMateria create(NivelMateria nivelMateria);

    public NivelMateria update(NivelMateria nivelMateria, Long id);

    public NivelMateria findById(Long id);

    public void deleteById(Long id);

    public NivelMateria fromDto(NivelMateriaRequestDto dto) throws Exception;
}
