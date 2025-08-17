package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.RequisitoMateriaRequestDto;
import com.imb2025.calificaciones.entity.RequisitoMateria;
import java.util.List;

public interface IRequisitoMateriaService {

    public List<RequisitoMateria> findAll();

    public RequisitoMateria create(RequisitoMateria requisitoMateria);

    public RequisitoMateria update(RequisitoMateria requisitoMateria, Long id);

    public RequisitoMateria findById(Long id);

    public void deleteById(Long id);

    public RequisitoMateria fromDto(RequisitoMateriaRequestDto dto);
}
