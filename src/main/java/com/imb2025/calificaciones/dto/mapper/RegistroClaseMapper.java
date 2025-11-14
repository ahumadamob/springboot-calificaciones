package com.imb2025.calificaciones.dto.mapper;

import com.imb2025.calificaciones.dto.request.RegistroClaseRequestDto;
import com.imb2025.calificaciones.dto.response.RegistroClaseResponseDto;
import com.imb2025.calificaciones.entity.Comision;
import com.imb2025.calificaciones.entity.Docente;
import com.imb2025.calificaciones.entity.RegistroClase;

public class RegistroClaseMapper {

    public static RegistroClase fromDto(
            RegistroClaseRequestDto dto,
            Docente docente,
            Comision comision
    ) {
        RegistroClase registro = new RegistroClase();
        registro.setFecha(dto.getFecha());
        registro.setTema(dto.getTema());
        registro.setDocente(docente);
        registro.setComision(comision);
        return registro;
    }

    public static RegistroClaseResponseDto toResponseDto(RegistroClase registro) {
        RegistroClaseResponseDto dto = new RegistroClaseResponseDto();
        dto.setId(registro.getId());
        dto.setFecha(registro.getFecha());
        dto.setTema(registro.getTema());
        dto.setDocenteId(registro.getDocente().getId());
        dto.setComisionId(registro.getComision().getId());
        dto.setVersion(registro.getVersion());
        return dto;
    }
}
