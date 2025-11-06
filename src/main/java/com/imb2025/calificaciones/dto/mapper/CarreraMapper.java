package com.imb2025.calificaciones.dto.mapper;

import com.imb2025.calificaciones.dto.request.CarreraRequestDto;
import com.imb2025.calificaciones.dto.response.CarreraResponseDto;
import com.imb2025.calificaciones.entity.Carrera;

public class CarreraMapper {

    public static Carrera fromDto(CarreraRequestDto dto) {
        Carrera carrera = new Carrera();
        carrera.setNombre(dto.getNombre());
        carrera.setTituloOtorgado(dto.getTituloOtorgado());
        
        return carrera;
    }

    
    public static CarreraResponseDto toResponseDto(Carrera carrera) {
        CarreraResponseDto dto = new CarreraResponseDto();
        dto.setId(carrera.getId());
        dto.setNombre(carrera.getNombre());
        dto.setTituloOtorgado(carrera.getTituloOtorgado());
        dto.setVersion(carrera.getVersion());
        
        return dto;
    }
}