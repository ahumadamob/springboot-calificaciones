package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.CondicionFinalRequestDto;
import com.imb2025.calificaciones.entity.CondicionFinal;
import java.util.List;

public interface ICondicionFinalService {

    public List<CondicionFinal> findAll();

    public CondicionFinal create(CondicionFinal condicionFinal);

    public CondicionFinal update(CondicionFinal condicionFinal, Long id);

    public CondicionFinal findById(Long id);

    public void deleteById(Long id);

    public CondicionFinal fromDto(CondicionFinalRequestDto dto);
}
