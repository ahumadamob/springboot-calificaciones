package com.imb2025.calificaciones.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
import com.imb2025.calificaciones.dto.mapper.AsistenciaMapper;
import com.imb2025.calificaciones.dto.request.AsistenciaRequestDto;
import com.imb2025.calificaciones.dto.response.AsistenciaResponseDto;
import com.imb2025.calificaciones.entity.Asistencia;
import com.imb2025.calificaciones.service.IAsistenciaService;
import com.imb2025.calificaciones.service.IAlumnoService;
import com.imb2025.calificaciones.service.IRegistroClaseService;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.Valid;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/asistencia")
public class AsistenciaController {

    @Autowired
    private IAsistenciaService asistenciaService;

    @Autowired
    private IAlumnoService alumnoService; // Necesario para buscar Alumno

    @Autowired
    private IRegistroClaseService registroClaseService; // Necesario para buscar RegistroClase

    @Autowired
    private AsistenciaMapper asistenciaMapper;

    // GET - listar todas las asistencias
    @GetMapping
    public ResponseEntity<ApiResponseSuccessDto<List<AsistenciaResponseDto>>> getAll() {
        List<Asistencia> asistencias = asistenciaService.findAll();
        List<AsistenciaResponseDto> dtos = asistencias.stream() //para conversiones de lista
                .map(asistenciaMapper::toResponse)
                .collect(Collectors.toList());
        
        ApiResponseSuccessDto<List<AsistenciaResponseDto>> resp = new ApiResponseSuccessDto<>(true, "Listado de asistencias obtenido correctamente", dtos);
        
        return dtos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(resp);
    }

    // GET - buscar una asistencia por ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<AsistenciaResponseDto>> getById(@PathVariable Long id) {
        Asistencia asistencia = asistenciaService.findById(id);
        AsistenciaResponseDto dto = asistenciaMapper.toResponse(asistencia);
        ApiResponseSuccessDto<AsistenciaResponseDto> resp = new ApiResponseSuccessDto<>(true, "Asistencia encontrada correctamente", dto);
        return ResponseEntity.ok(resp);
    }

    // POST - crear nueva asistencia
    @PostMapping
    public ResponseEntity<ApiResponseSuccessDto<AsistenciaResponseDto>> create(@RequestBody @Valid AsistenciaRequestDto dto) throws Exception {
        Asistencia asistencia = new Asistencia();
        asistencia.setAlumno(alumnoService.findById(dto.getAlumnoId()));
        asistencia.setRegistroClase(registroClaseService.findById(dto.getRegistroClaseId()));
        asistencia.setPresente(dto.getPresente());
        asistencia.setObservaciones(dto.getObservaciones());
        asistencia.setTardanza(dto.getTardanza()); 

        Asistencia nueva = asistenciaService.create(asistencia);
        AsistenciaResponseDto respDto = asistenciaMapper.toResponse(nueva);
        ApiResponseSuccessDto<AsistenciaResponseDto> resp = new ApiResponseSuccessDto<>(true, "Asistencia creada correctamente", respDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    // PUT - actualizar asistencia existente
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<AsistenciaResponseDto>> update(@PathVariable Long id, @RequestBody @Valid AsistenciaRequestDto dto) throws Exception {
        Asistencia asistencia = new Asistencia();
        asistencia.setAlumno(alumnoService.findById(dto.getAlumnoId()));
        asistencia.setRegistroClase(registroClaseService.findById(dto.getRegistroClaseId()));
        asistencia.setPresente(dto.getPresente());
        asistencia.setObservaciones(dto.getObservaciones());
        asistencia.setTardanza(dto.getTardanza());

        Asistencia actualizada = asistenciaService.update(asistencia, id);
        AsistenciaResponseDto respDto = asistenciaMapper.toResponse(actualizada);
        ApiResponseSuccessDto<AsistenciaResponseDto> resp = new ApiResponseSuccessDto<>(true, "Asistencia actualizada correctamente", respDto);
        return ResponseEntity.ok(resp);
    }

    // DELETE - eliminar una asistencia
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception {
        asistenciaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/count/presentes")
    public long countPresentes(@RequestParam boolean presente) {
        return asistenciaService.countByPresente(presente);
    }

    @GetMapping("/by-nombre")
    public ResponseEntity<ApiResponseSuccessDto<List<AsistenciaResponseDto>>> findByNombre(@RequestParam String nombre) {
        List<Asistencia> asistencias = asistenciaService.findByAlumnoNombreIgnoreCase(nombre);
        List<AsistenciaResponseDto> dtos = asistencias.stream()
                .map(asistenciaMapper::toResponse)
                .collect(Collectors.toList());
        
        ApiResponseSuccessDto<List<AsistenciaResponseDto>> resp = new ApiResponseSuccessDto<>(true, "Asistencias encontradas", dtos);

        return dtos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(resp);
    }

    // Nuevos endpoints: listar por tardanza true / false
    @GetMapping("/tardanza/true")
    public ResponseEntity<ApiResponseSuccessDto<List<AsistenciaResponseDto>>> listTardanzaTrue() {
        List<Asistencia> lista = asistenciaService.findByTardanzaTrue();
        List<AsistenciaResponseDto> dtos = lista.stream().map(asistenciaMapper::toResponse).collect(Collectors.toList());
        ApiResponseSuccessDto<List<AsistenciaResponseDto>> resp = new ApiResponseSuccessDto<>(true, "Asistencias con tardanza=true", dtos);
        return dtos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(resp);
    }

    @GetMapping("/tardanza/false")
    public ResponseEntity<ApiResponseSuccessDto<List<AsistenciaResponseDto>>> listTardanzaFalse() {
        List<Asistencia> lista = asistenciaService.findByTardanzaFalse();
        List<AsistenciaResponseDto> dtos = lista.stream().map(asistenciaMapper::toResponse).collect(Collectors.toList());
        ApiResponseSuccessDto<List<AsistenciaResponseDto>> resp = new ApiResponseSuccessDto<>(true, "Asistencias con tardanza=false", dtos);
        return dtos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(resp);
    }
}

