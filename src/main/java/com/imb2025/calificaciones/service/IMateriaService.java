package com.imb2025.calificaciones.service;


import com.imb2025.calificaciones.entity.Materia;
import java.util.List; 


public interface IMateriaService {

    public List<Materia> findAll();
    
    public List<Materia> findAllOrder();
    
    public List<Materia>findByNivelEndsWith(String sufijo);

    public Materia create(Materia materia);

    public Materia update(Materia materia, Long id) throws Exception;

    public Materia findById(Long id);
    
    public Materia findByCodigo(String codigo);
    
    long findByCargaHoraria(Integer cargaHoraria);

    public void deleteById(Long id) throws Exception;
    
    long contarMateriasActivas();
    
    long contarMateriasInactivas();

 
}
