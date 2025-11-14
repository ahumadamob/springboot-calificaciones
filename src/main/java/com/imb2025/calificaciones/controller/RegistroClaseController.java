package com.imb2025.calificaciones.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
import com.imb2025.calificaciones.dto.mapper.RegistroClaseMapper;
import com.imb2025.calificaciones.dto.request.RegistroClaseRequestDto;
import com.imb2025.calificaciones.dto.response.RegistroClaseResponseDto;
import com.imb2025.calificaciones.entity.RegistroClase;
import com.imb2025.calificaciones.service.IRegistroClaseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/registro")
@Validated
public class RegistroClaseController {

    private final IRegistroClaseService service;

    public RegistroClaseController(IRegistroClaseService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<RegistroClase> registros = service.findAll();

        if (registros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<RegistroClaseResponseDto> response = 
                registros.stream()
                         .map(RegistroClaseMapper::toResponseDto)
                         .toList();

        ApiResponseSuccessDto<List<RegistroClaseResponseDto>> resp =
                new ApiResponseSuccessDto<>(true, "Listado obtenido con éxito", response);

        return ResponseEntity.ok(resp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        RegistroClase registro = service.findById(id);

        RegistroClaseResponseDto response = RegistroClaseMapper.toResponseDto(registro);

        ApiResponseSuccessDto<RegistroClaseResponseDto> resp =
                new ApiResponseSuccessDto<>(true, "Registro encontrado", response);

        return ResponseEntity.ok(resp);
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> getByTema(@RequestParam String tema) {
        List<RegistroClase> registros = service.findByTema(tema);

        if (registros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<RegistroClaseResponseDto> response =
                registros.stream()
                         .map(RegistroClaseMapper::toResponseDto)
                         .toList();

        ApiResponseSuccessDto<List<RegistroClaseResponseDto>> resp =
                new ApiResponseSuccessDto<>(true, "Registros filtrados por tema", response);

        return ResponseEntity.ok(resp);
    }

    @GetMapping("/count")
    public ResponseEntity<?> countByFecha(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha
    ) {
        Long cantidad = service.countByFecha(fecha);

        ApiResponseSuccessDto<Long> resp =
                new ApiResponseSuccessDto<>(true, "Cantidad en la fecha " + fecha, cantidad);

        return ResponseEntity.ok(resp);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody RegistroClaseRequestDto dto) throws Exception {

        RegistroClase creado = service.createFromDto(dto);

        RegistroClaseResponseDto response = RegistroClaseMapper.toResponseDto(creado);

        ApiResponseSuccessDto<RegistroClaseResponseDto> resp =
                new ApiResponseSuccessDto<>(true, "Registro creado con éxito", response);

        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable Long id,
            @Valid @RequestBody RegistroClaseRequestDto dto
    ) throws Exception {

        RegistroClase actualizado = service.updateFromDto(id, dto);

        RegistroClaseResponseDto response = RegistroClaseMapper.toResponseDto(actualizado);

        ApiResponseSuccessDto<RegistroClaseResponseDto> resp =
                new ApiResponseSuccessDto<>(true, "Registro actualizado con éxito", response);

        return ResponseEntity.ok(resp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
        service.deleteById(id);

        ApiResponseSuccessDto<Void> resp =
                new ApiResponseSuccessDto<>(true, "Registro eliminado con éxito", null);

        return ResponseEntity.ok(resp);
    }
}

