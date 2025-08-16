package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.CarreraRequestDto;
import com.imb2025.calificaciones.entity.Carrera;
import java.util.List;

public interface ICarreraService {

    public List<Carrera> findAll();

    public Carrera findById(Long id);

    public Carrera create(CarreraRequestDto dto);

    public Carrera update(Long id, CarreraRequestDto dto) throws Exception;

    public void deleteById(Long id);

    public Carrera fromDto(CarreraRequestDto dto) throws Exception;
}

