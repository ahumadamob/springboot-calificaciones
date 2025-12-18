package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.entity.Comision;
import java.util.List;

public interface IComisionService {

    public List<Comision> findAll();

    // services trabajan con entidades, no con DTOs
    public Comision create(Comision comision) throws Exception;

    public Comision update(Comision comision, Long id) throws Exception;

    public Comision findById(Long id);

    public void deleteById(Long id) throws Exception;

    public boolean existsById(Long id);
    

    // Métodos añadidos para TP07
    public List<Comision> findByNombreContainingIgnoreCase(String nombre);

    public long countBySedeId(Long sedeId);
    
    public java.util.List<Comision> findByDestacadoTrue();

    public java.util.List<Comision> findByDestacadoFalse();

	public Comision updateDestacadoState(Long id, boolean b);

	boolean updateDestacadoState(Long id);

	

}
