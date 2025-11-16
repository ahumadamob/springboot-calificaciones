package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.entity.Cursada;
import java.util.List;

public interface ICursadaService {

    public List<Cursada> findAll();

    public Cursada create(Cursada cursada);

    public Cursada update(Cursada cursada, Long id) throws Exception;

    public Cursada findById(Long id);

    public void deleteById(Long id) throws Exception;
    
    public List<Cursada> findByNombreAlumno(String nombre);

    public Long countByNombreMateria(String nombreMateria);
}
