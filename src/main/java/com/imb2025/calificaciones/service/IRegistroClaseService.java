package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.RegistroClaseRequestDto;
import com.imb2025.calificaciones.dto.RegistroClaseDTO;
import com.imb2025.calificaciones.entity.RegistroClase;
import java.util.List;

public interface IRegistroClaseService {

    public List<RegistroClase> findAll();

    public RegistroClase registrarClase(RegistroClaseDTO dto);

    public RegistroClase actualizarRegistro(Long id, RegistroClaseDTO dto);

    public RegistroClase findById(Long id);

    public void eliminarRegistro(Long id);

    public RegistroClase fromDto(RegistroClaseRequestDto dto) throws Exception;
}
