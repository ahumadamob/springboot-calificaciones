package com.imb2025.calificaciones.service;

import java.util.List;

import com.imb2025.calificaciones.entity.CondicionFinal;

public interface ICondicionFinalService {
    List<CondicionFinal> getAll();
    CondicionFinal getById(Long id);
    CondicionFinal save(CondicionFinal cf);
    void delete(Long id);
}
