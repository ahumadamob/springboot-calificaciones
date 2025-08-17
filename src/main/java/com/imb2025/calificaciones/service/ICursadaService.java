package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.CursadaRequestDto;
import com.imb2025.calificaciones.entity.Cursada;
import java.util.List;

public interface ICursadaService {

    public List<Cursada> findAll();

    public Cursada create(Cursada cursada);

    public Cursada update(Cursada cursada, Long id);

    public Cursada findById(Long id);

    public void deleteById(Long id);

    public Cursada fromDto(CursadaRequestDto dto);
}
