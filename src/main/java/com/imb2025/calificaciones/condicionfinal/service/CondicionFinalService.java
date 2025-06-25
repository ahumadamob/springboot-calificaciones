package com.imb2025.calificaciones.condicionfinal.service;

import com.imb2025.calificaciones.condicionfinal.dto.CondicionFinalRequestDTO;
import com.imb2025.calificaciones.condicionfinal.entity.CondicionFinal;

import java.util.List;

public interface CondicionFinalService {
    List<CondicionFinal> getAll();
    CondicionFinal getById(Long id);
    CondicionFinal create(CondicionFinalRequestDTO dto);
    CondicionFinal update(Long id, CondicionFinalRequestDTO dto);
    void delete(Long id);
}
