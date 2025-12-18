package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.request.AlumnoRequestDto;
import com.imb2025.calificaciones.entity.Alumno;

import jakarta.validation.Valid;

import java.time.LocalDate;
import java.util.List;

public interface IAlumnoService {

    public List<Alumno> findAll();

    public Alumno create(Alumno alumno);

    public Alumno update(Alumno alumno, Long id) throws Exception;

    public Alumno findById(Long id);

    public Alumno deleteById(@Valid AlumnoRequestDto dto, Long id) throws Exception;

    public boolean existsById(Long id);

    List<Alumno> findByApellido(String apellido);

    long countByEmail(String email);
    List<Alumno> findByAtributoBooleanoTrue();

    List<Alumno> findByAtributoBooleanoFalse();

	public List<Alumno> findByFechaBajaNotNull(LocalDate fechaBaja);

	public List<Alumno> findByFechaBajasIsNull(LocalDate fechaBaja);
}