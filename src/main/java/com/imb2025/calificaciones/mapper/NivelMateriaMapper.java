package com.imb2025.calificaciones.mapper;

import com.imb2025.calificaciones.dto.request.NivelMateriaRequestDto;
import com.imb2025.calificaciones.dto.response.NivelMateriaResponseDto;
import com.imb2025.calificaciones.entity.NivelMateria;

public class NivelMateriaMapper {
	
    public NivelMateria fromDto(NivelMateriaRequestDto dto) throws Exception {
        if (dto == null) {
            throw new Exception("El dto de nivel materia no puede ser nulo");
        }
        NivelMateria nivelMateria = new NivelMateria();
        nivelMateria.setNombre(dto.getNombre());
        nivelMateria.setDescripcion(dto.getDescripcion());
        return nivelMateria;
    }
    
    public NivelMateriaResponseDto toResponseDto(NivelMateria nivelMateria){
    	NivelMateriaResponseDto dto = new NivelMateriaResponseDto();
    	dto.setId(nivelMateria.getId());
    	dto.setNombre(nivelMateria.getNombre());
    	dto.setVersion(nivelMateria.getVersion());
    	
    	return dto;    	
    }  
    

}
