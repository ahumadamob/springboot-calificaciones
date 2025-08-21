package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.CarreraRequestDto;
import com.imb2025.calificaciones.entity.Carrera;
import java.util.List;

public interface ICarreraService {

    public List<Carrera> findAll();

    public Carrera create(Carrera carrera);

    public Carrera update(Carrera carrera, Long id) throws Exception;

    public Carrera findById(Long id);

    public void deleteById(Long id) throws Exception;

    public Carrera fromDto(CarreraRequestDto dto) throws Exception;
}
