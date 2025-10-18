package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.NivelMateriaRequestDto;
import com.imb2025.calificaciones.entity.NivelMateria;
import java.util.List;

public interface INivelMateriaService {

    public List<NivelMateria> findAll();
   
    // Nuevo: buscar por nombre (filtro)
    List<NivelMateria> findAllByNombre(String nombre);

    // Nuevo: contar por nombre
    long countByNombre(String nombre);

    public NivelMateria create(NivelMateria nivelMateria);

    public NivelMateria update(NivelMateria nivelMateria, Long id) throws Exception;

    public NivelMateria findById(Long id);

    public void deleteById(Long id) throws Exception;

    public NivelMateria fromDto(NivelMateriaRequestDto dto) throws Exception;
}
