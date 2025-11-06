package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.entity.Carrera;
import java.util.List;

public interface ICarreraService {

    public List<Carrera> findAll();

    public Carrera create(Carrera carrera);

    public Carrera update(Carrera carrera, Long id) throws Exception;

    public Carrera findById(Long id);

    public void deleteById(Long id) throws Exception;

    // Métodos de búsqueda
    List<Carrera> buscarPorNombre(String nombre);
    
    List<Carrera> buscarPorFragmentoNombre(String fragmento);

    // Validación de duplicados
    boolean existePorNombre(String nombre);
}