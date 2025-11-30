package com.imb2025.calificaciones.dto.mapper;



import org.springframework.stereotype.Component;

import com.imb2025.calificaciones.dto.request.PlanEstudioRequestDto;
import com.imb2025.calificaciones.dto.response.PlanEstudioResponseDto;
import com.imb2025.calificaciones.entity.PlanEstudio;


@Component	
public class PlanEstudioMapper {
	
	    
	    public static PlanEstudio fromDto(PlanEstudioRequestDto dto) {
	        PlanEstudio plan = new PlanEstudio();
	        plan.setNombre(dto.getNombre());
	        
	        return plan;
	    }

	    
	    public static PlanEstudioResponseDto toResponseDto(PlanEstudio plan) {
	        PlanEstudioResponseDto dto = new PlanEstudioResponseDto();
	        dto.setID(plan.getId());
	        dto.setNombre(plan.getNombre());
	        dto.setVersion(plan.getVersion());
	        return dto;
}



}
