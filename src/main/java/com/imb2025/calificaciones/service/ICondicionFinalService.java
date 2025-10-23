package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.entity.CondicionFinal;
import java.util.List;

public interface ICondicionFinalService {

    List<CondicionFinal> findAll();

    CondicionFinal create(CondicionFinal condicionFinal);

    CondicionFinal update(CondicionFinal condicionFinal, Long id) throws Exception;

    CondicionFinal findById(Long id);

    void deleteById(Long id) throws Exception;

    List<CondicionFinal> findByNombre(String nombre);

    Long countByNombre(String nombre);
    
    // Nuevos métodos del Ejercicio 1
    List<CondicionFinal> findVigentes();
    
    List<CondicionFinal> findNoVigentes();
}