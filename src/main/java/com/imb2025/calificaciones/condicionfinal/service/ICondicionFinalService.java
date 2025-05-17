package com.imb2025.calificaciones.condicionfinal.service;

import com.imb2025.calificaciones.condicionfinal.entity.CondicionFinal;

import java.util.List;

public interface ICondicionFinalService {
    List<CondicionFinal> getAll();
    CondicionFinal getById(Long id);
    CondicionFinal save(CondicionFinal cf);
    void delete(Long id);
}
