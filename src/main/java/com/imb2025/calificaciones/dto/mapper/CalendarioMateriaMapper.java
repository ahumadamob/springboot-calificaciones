package com.imb2025.calificaciones.dto.mapper;

import com.imb2025.calificaciones.dto.request.CalendarioMateriaRequestDto;
import com.imb2025.calificaciones.dto.response.CalendarioMateriaResponseDto;
import com.imb2025.calificaciones.entity.CalendarioMateria;
import com.imb2025.calificaciones.entity.Comision;
import com.imb2025.calificaciones.entity.Materia;
import com.imb2025.calificaciones.repository.ComisionRepository;
import com.imb2025.calificaciones.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalendarioMateriaMapper {

    @Autowired
    private ComisionRepository comisionRepository;
    @Autowired
    private MateriaRepository materiaRepository;

    public CalendarioMateria fromDto(CalendarioMateriaRequestDto calMatDto) throws Exception {

        CalendarioMateria calendarioMateria = new CalendarioMateria();

        if (calMatDto.getFechaInicio().isAfter(calMatDto.getFechaFin())){
            throw new Exception("La fecha de inicio no puede ser posterior a la fecha de fin");
        }
        Materia materia = materiaRepository.findById(calMatDto.getMateriaId())
                .orElseThrow(() -> new Exception ("Materia no encontrada con el id: " + calMatDto.getMateriaId()));

        Comision comision = comisionRepository.findById(calMatDto.getComisionId())
                .orElseThrow(() -> new Exception ("Comision no encontrada con el id: " + calMatDto.getComisionId()));

        calendarioMateria.setFechaInicio(calMatDto.getFechaInicio());
        calendarioMateria.setFechaFin(calMatDto.getFechaFin());
        calendarioMateria.setMateria(materia);
        calendarioMateria.setComision(comision);
        calendarioMateria.setEstado(calMatDto.getEstado());

        return calendarioMateria;
    }

    public CalendarioMateriaResponseDto toResponseDto(CalendarioMateria calendarioMateria){

        CalendarioMateriaResponseDto response = new CalendarioMateriaResponseDto();

        response.setFechaInicio(calendarioMateria.getFechaInicio());
        response.setFechaFin(calendarioMateria.getFechaFin());
        response.setId(calendarioMateria.getId());
        response.setMateria(calendarioMateria.getMateria().getId());
        response.setComision(calendarioMateria.getComision().getId());
        response.setVersion(calendarioMateria.getVersion());
        response.setEstado(calendarioMateria.getEstado());

        return response;
    }


}
