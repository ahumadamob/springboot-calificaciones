package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.request.NivelMateriaRequestDto;
import com.imb2025.calificaciones.entity.NivelMateria;
import java.util.List;

public interface INivelMateriaService {

    public List<NivelMateria> findAll();

    // Nuevo: buscar por nombre (filtro)
    List<NivelMateria> findAllByNombre(String nombre);

    // Nuevo: contar por nombre
    long countByNombre(String nombre);

    // Nuevos: filtrar por activo
    List<NivelMateria> findByActivoTrue();
    
    List<NivelMateria> findByActivoFalse();
    
    public void deleteById(Long id) throws Exception;
    
    public NivelMateria create(NivelMateria nivelMateria);

    public NivelMateria update(NivelMateria nivelMateria, Long id) throws Exception;

    public NivelMateria findById(Long id);

}