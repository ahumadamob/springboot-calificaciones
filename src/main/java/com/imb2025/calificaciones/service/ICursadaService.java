package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.CursadaRequestDto;
import com.imb2025.calificaciones.entity.Cursada;
import java.util.List;

public interface ICursadaService {

    public List<Cursada> findAll();

    public Cursada findById(Long id);

    public Cursada create(CursadaRequestDto dto);

    public Cursada update(Long id, CursadaRequestDto dto);

    public void deleteById(Long id);

    public Cursada fromDto(CursadaRequestDto dto);
}
