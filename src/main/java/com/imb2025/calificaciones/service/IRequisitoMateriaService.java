package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.RequisitoMateriaRequestDto;
import com.imb2025.calificaciones.entity.RequisitoMateria;
import java.util.List;
import java.util.Optional;

public interface IRequisitoMateriaService {

    public List<RequisitoMateria> findAll();

    public RequisitoMateria create(RequisitoMateriaRequestDto dto);

    public RequisitoMateria update(RequisitoMateriaRequestDto dto, Long id) throws Exception;

    public Optional<RequisitoMateria> findById(Long id);

    public void deleteById(Long id);

    public RequisitoMateria fromDto(RequisitoMateriaRequestDto dto) throws Exception;
}
