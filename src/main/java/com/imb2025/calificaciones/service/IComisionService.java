package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.ComisionRequestDto;
import com.imb2025.calificaciones.entity.Comision;
import java.util.List;

public interface IComisionService {

    public List<Comision> findAll();

    public Comision create(Comision comision);

    public Comision update(Comision comision, Long id) throws Exception;

    public Comision findById(Long id);

    public void deleteById(Long id) throws Exception;

    public Comision fromDto(ComisionRequestDto dto) throws Exception;
}
