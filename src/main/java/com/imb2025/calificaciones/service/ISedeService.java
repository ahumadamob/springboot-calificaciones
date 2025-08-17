package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.SedeRequestDto;
import com.imb2025.calificaciones.entity.Sede;
import java.util.List;

public interface ISedeService {

    public List<Sede> findAll();

    public Sede create(Sede sede);

    public Sede update(Sede sede, Long id);

    public Sede findById(Long id);

    public void deleteById(Long id);

    public Sede fromDto(SedeRequestDto dto);
}
