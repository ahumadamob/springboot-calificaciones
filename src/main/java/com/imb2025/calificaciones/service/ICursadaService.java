package com.imb2025.calificaciones.service;

import java.util.List;

import com.imb2025.calificaciones.dto.CursadaRequestDTO;
import com.imb2025.calificaciones.entity.Cursada;

public interface ICursadaService {

    public List<Cursada> findAll();
    Cursada findById(Long id);
    String save(CursadaRequestDTO cursada);
    public void deleteById (Long id);
    public String update(Long id, CursadaRequestDTO dto);


}

