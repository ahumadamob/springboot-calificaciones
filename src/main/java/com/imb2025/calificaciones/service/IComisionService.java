package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.request.ComisionRequestDto;
import com.imb2025.calificaciones.entity.Comision;
import java.util.List;

public interface IComisionService {

    public List<Comision> findAll();

    // ahora create/update reciben el DTO request directamente
    public Comision create(ComisionRequestDto dto) throws Exception;

    public Comision update(ComisionRequestDto dto, Long id) throws Exception;

    public Comision findById(Long id);

    public void deleteById(Long id) throws Exception;

    public boolean existsById(Long id);

    // Métodos añadidos para TP07 (sin cambios)
    public List<Comision> findByNombreContainingIgnoreCase(String nombre);

    public long countBySedeId(Long sedeId);
}
