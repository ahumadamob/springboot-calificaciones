package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.ComisionRequestDto;
import com.imb2025.calificaciones.entity.Comision;
import java.util.List;

public interface IComisionService {

    public List<Comision> findAll();

    public Comision findById(Long id);

    public Comision create(ComisionRequestDto dto);

    public Comision update(Long id, ComisionRequestDto dto);

    public void deleteById(Long id);

    public Comision fromDto(ComisionRequestDto dto);
}

