package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.RegistroClaseRequestDto;
import com.imb2025.calificaciones.entity.RegistroClase;
import java.util.List;

public interface IRegistroClaseService {

    public List<RegistroClase> findAll();

    public RegistroClase findById(Long id);

    public RegistroClase create(RegistroClaseRequestDto dto);

    public RegistroClase update(Long id, RegistroClaseRequestDto dto);

    public void deleteById(Long id);

    public RegistroClase fromDto(RegistroClaseRequestDto dto);
}
