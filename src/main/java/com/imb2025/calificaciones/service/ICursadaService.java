package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.CursadaRequestDto;
import com.imb2025.calificaciones.entity.Cursada;
import java.util.List;

public interface ICursadaService {

    public List<Cursada> findAll();

    public String create(CursadaRequestDto dto);

    public String update(CursadaRequestDto dto, Long id);

    public Cursada findById(Long id);

    public void deleteById(Long id);

    public Cursada fromDto(CursadaRequestDto dto) throws Exception;
}
