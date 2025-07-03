package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.entity.RequisitoMateria;

import java.util.List;
import java.util.Optional;

public interface RequisitoMateriaService {
    List<RequisitoMateria> findAll();
    Optional<RequisitoMateria> findById(Long id);
    RequisitoMateria save(RequisitoMateria requisito);
    RequisitoMateria update(Long id, RequisitoMateria requisito);
    void deleteById(Long id);
}
