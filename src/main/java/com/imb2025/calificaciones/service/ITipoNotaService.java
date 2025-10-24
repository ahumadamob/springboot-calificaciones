package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.request.TipoNotaRequestDto;
import com.imb2025.calificaciones.entity.TipoNota;
import java.util.List;

public interface ITipoNotaService {

    public List<TipoNota> findAll();
    
    public List<TipoNota>findAllOrder();
    
    public long countByNombre(String nombre);

    public TipoNota create(TipoNota tipoNota);

    public TipoNota update(TipoNota tipoNota, Long id);

    public TipoNota findById(Long id);

    public void deleteById(Long id);
    
    public TipoNota fromDto(TipoNotaRequestDto dto);
    
    List<TipoNota> findAllActivoTrue();
    
    List<TipoNota> findAllActivoFalse();
    

}
