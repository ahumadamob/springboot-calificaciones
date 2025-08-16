package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.RequisitoMateriaRequestDTO;
import com.imb2025.calificaciones.entity.RequisitoMateria;

import java.util.List;
import java.util.Optional;

public interface RequisitoMateriaService {

    List<RequisitoMateria> findAll();

    Optional<RequisitoMateria> findById(Long id);

    RequisitoMateria save(RequisitoMateriaRequestDTO dto);

    RequisitoMateria update(Long id, RequisitoMateriaRequestDTO dto);

    void deleteById(Long id);
}
