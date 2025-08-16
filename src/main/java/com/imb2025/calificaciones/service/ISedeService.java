package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.SedeRequestDto;
import com.imb2025.calificaciones.entity.Sede;
import java.util.List;

public interface ISedeService {

    public List<Sede> findAll();

    public Sede findById(Long id);

    public Sede create(SedeRequestDto dto);

    public Sede update(Long id, SedeRequestDto dto);

    public void deleteById(Long id);

    public Sede fromDto(SedeRequestDto dto);
}
