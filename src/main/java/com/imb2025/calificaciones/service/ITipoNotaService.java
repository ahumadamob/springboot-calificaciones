package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.TipoNotaRequestDto;
import com.imb2025.calificaciones.entity.TipoNota;
import java.util.List;

public interface ITipoNotaService {

    public List<TipoNota> findAll();

    public TipoNota findById(Long id);

    public TipoNota create(TipoNotaRequestDto dto);

    public TipoNota update(Long id, TipoNotaRequestDto dto);

    public void deleteById(Long id);

    public TipoNota fromDto(TipoNotaRequestDto dto);
}
