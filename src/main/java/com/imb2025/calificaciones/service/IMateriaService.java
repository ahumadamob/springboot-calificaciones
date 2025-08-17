package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.MateriaRequestDto;
import com.imb2025.calificaciones.entity.Materia;
import java.util.List;

public interface IMateriaService {

    public List<Materia> findAll();

    public Materia create(Materia materia);

    public Materia update(Materia materia, Long id);

    public Materia findById(Long id);

    public void deleteById(Long id);

    public Materia fromDto(MateriaRequestDto dto) throws Exception;
}
