package com.imb2025.calificaciones.dto.mapper;

import com.imb2025.calificaciones.dto.request.AlumnoRequestDto;
import com.imb2025.calificaciones.dto.response.AlumnoResponseDto;
import com.imb2025.calificaciones.entity.Alumno;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AlumnoMapper {

    public Alumno fromDto(AlumnoRequestDto alumnoDto) {
        Alumno alumno = new Alumno();
        alumno.setNombre(alumnoDto.getNombre());
        alumno.setApellido(alumnoDto.getApellido());
        alumno.setEmail(alumnoDto.getEmail());
        alumno.setDni(alumnoDto.getDni());

        if (alumnoDto.getAtributoBooleano() != null) {
            alumno.setAtributoBooleano(alumnoDto.getAtributoBooleano());
        }

        try {
            // Conversión de String a Date. Si falla, lanza ParseException.
            Date fechaNacimiento = new SimpleDateFormat("yyyy-MM-dd").parse(alumnoDto.getFechaNacimiento());
            alumno.setFechaNacimiento(fechaNacimiento);
        } catch (ParseException e) {
            // Se lanza una RuntimeException para que el ControllerAdvice lo capture.
            // Esto es un error de CONVERSIÓN, no de validación de negocio.
            throw new RuntimeException("Error de formato al convertir la fecha de nacimiento. Se esperaba 'yyyy-MM-dd'.", e);
        }

        return alumno;
    }

    public AlumnoResponseDto toResponseDto(Alumno alumno) {
        AlumnoResponseDto dto = new AlumnoResponseDto();
        dto.setId(alumno.getId());
        dto.setNombre(alumno.getNombre());
        dto.setApellido(alumno.getApellido());
        dto.setEmail(alumno.getEmail());
        dto.setDni(alumno.getDni());
        dto.setVersion(alumno.getVersion());
        dto.setAtributoBooleano(alumno.getAtributoBooleano());
        return dto;
    }

    public List<AlumnoResponseDto> toResponseDtoList(List<Alumno> alumnos) {
        return alumnos.stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }
}