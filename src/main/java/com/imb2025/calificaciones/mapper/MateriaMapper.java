package com.imb2025.calificaciones.mapper;

import com.imb2025.calificaciones.dto.request.MateriaRequestDto;
import com.imb2025.calificaciones.dto.response.MateriaResponseDto;
import com.imb2025.calificaciones.entity.Materia;

public class MateriaMapper {
	
	 
	    public Materia fromDto(MateriaRequestDto materiaRequestDto) {
	        Materia materia = new Materia();
	        materia.setNombre(materiaRequestDto.getNombre());
	        materia.setCargaHoraria(materiaRequestDto.getCargaHoraria());
	        materia.setCodigo(materiaRequestDto.getCodigo());
	        materia.setNivel(materiaRequestDto.getNivel());
	        materia.setEstado(materiaRequestDto.getEstado());
	      

	        return materia;
	    }
	    
	    public MateriaResponseDto toResponseDto(Materia materia) {
	    	MateriaResponseDto dto = new MateriaResponseDto();
	    	dto.setId(materia.getId());
	    	dto.setNombre(materia.getNombre());
	    	dto.setNivel(materia.getNivel());
	    	dto.setVersion(materia.getVersion());
	    	dto.setEstado(materia.getEstado());
	    	
	    	return dto;
	    	
	    			
	    }

}
