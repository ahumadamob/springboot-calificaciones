package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.RegistroClaseRequestDto;
import com.imb2025.calificaciones.entity.RegistroClase;
import java.util.List;

public interface IRegistroClaseService {

    public List<RegistroClase> findAll();

    public RegistroClase create(RegistroClase registroClase);

    public RegistroClase update(RegistroClase registroClase, Long id) throws Exception;

    public RegistroClase findById(Long id);

    public void deleteById(Long id) throws Exception;

    public RegistroClase fromDto(RegistroClaseRequestDto dto) throws Exception;
}
