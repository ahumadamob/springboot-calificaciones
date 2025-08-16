package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.RequisitoMateriaRequestDto;
import com.imb2025.calificaciones.entity.RequisitoMateria;
import java.util.List;
import java.util.Optional;

public interface IRequisitoMateriaService {
    List<RequisitoMateria> findAll();
    Optional<RequisitoMateria> findById(Long id);
    RequisitoMateria save(RequisitoMateriaRequestDto dto);
    RequisitoMateria update(Long id, RequisitoMateriaRequestDto dto);
    void deleteById(Long id);
}
