package com.imb2025.calificaciones.controller;


import java.util.List;
import java.util.stream.Collectors;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
import com.imb2025.calificaciones.dto.request.ComisionRequestDto;
import com.imb2025.calificaciones.dto.response.ComisionResponseDto;
import com.imb2025.calificaciones.dto.mapper.ComisionMapper;
import com.imb2025.calificaciones.entity.Comision;
import com.imb2025.calificaciones.service.IComisionService;

@RestController
//Indica que esta clase maneja peticiones REST y devuelve JSON.
@RequestMapping("/api/comision")
//URL Base: localhost:8080/api/comision
public class ComisionController {

    @Autowired 
    private IComisionService service;
 // Inyecta el Servicio (Lógica de Negocio).
    @Autowired
    private ComisionMapper mapper;
 // Inyecta el Mapper (Convertidor Entidad <-> DTO).
    @GetMapping
    public ResponseEntity<ApiResponseSuccessDto<List<ComisionResponseDto>>> getAll() {
        List<Comision> list = service.findAll();
        List<ComisionResponseDto> dtoList = list.stream()
                .map(mapper::toResponseDto)
                .collect(Collectors.toList());

        ApiResponseSuccessDto<List<ComisionResponseDto>> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(dtoList);
        resp.setMessage("Comisiones encontradas con éxito");
        return dtoList.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(resp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<ComisionResponseDto>> getById(@PathVariable Long id) {
        Comision c = service.findById(id);
        ComisionResponseDto body = mapper.toResponseDto(c);
        ApiResponseSuccessDto<ComisionResponseDto> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(body);
        resp.setMessage("Comision encontrada con éxito");
        return ResponseEntity.ok(resp);
    }

    // filtrar por nombre (TP07)
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<ApiResponseSuccessDto<List<ComisionResponseDto>>> getByNombre(@PathVariable String nombre) {
        List<Comision> lista = service.findByNombreContainingIgnoreCase(nombre);
        List<ComisionResponseDto> dtoList = lista.stream()
                .map(mapper::toResponseDto)
                .collect(Collectors.toList());

        ApiResponseSuccessDto<List<ComisionResponseDto>> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(dtoList);
        resp.setMessage("Comisiones filtradas por nombre: " + nombre);
        return dtoList.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(resp);
    }

    @GetMapping("/count/sede/{sedeId}")
    public ResponseEntity<ApiResponseSuccessDto<Long>> countBySede(@PathVariable Long sedeId) {
        long cantidad = service.countBySedeId(sedeId);
        ApiResponseSuccessDto<Long> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(cantidad);
        resp.setMessage("Cantidad de comisiones en la sede: " + sedeId);
        return ResponseEntity.ok(resp);
    }

    @PostMapping
    public ResponseEntity<ApiResponseSuccessDto<ComisionResponseDto>> create(@Valid @RequestBody ComisionRequestDto dto) throws Exception {
        // mapper convierte DTO -> entidad
        Comision entidad = mapper.fromDto(dto);
        Comision c = service.create(entidad);
        ComisionResponseDto body = mapper.toResponseDto(c);
        ApiResponseSuccessDto<ComisionResponseDto> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(body);
        resp.setMessage("Comision creada con éxito");
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<ComisionResponseDto>> update(@PathVariable Long id, @Valid @RequestBody ComisionRequestDto dto) throws Exception {
        if (!service.existsById(id)) {
            ApiResponseSuccessDto<ComisionResponseDto> notFound = new ApiResponseSuccessDto<>();
            notFound.setSuccess(false);
            notFound.setMessage("No se encontró Comision con id " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFound);
        }
        Comision entidad = mapper.fromDto(dto);
        Comision c = service.update(entidad, id);
        ComisionResponseDto body = mapper.toResponseDto(c);
        ApiResponseSuccessDto<ComisionResponseDto> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(body);
        resp.setMessage("Comision actualizada con éxito");
        return ResponseEntity.ok(resp);
    }

    @PutMapping("/{id}/destacar")
    public ResponseEntity<ApiResponseSuccessDto<ComisionResponseDto>> destacar(@PathVariable Long id) throws Exception {
        Comision entidad = service.updateDestacadoState(id, true);
        ComisionResponseDto response = mapper.toResponseDto(entidad);
        
        ApiResponseSuccessDto<ComisionResponseDto> res = new ApiResponseSuccessDto<>();
        res.setSuccess(true);
        res.setData(response);
        res.setMessage("Destacar");
        
        return ResponseEntity.ok(res);
    }

    @PutMapping("/{id}/destacado")
    public ResponseEntity<ApiResponseSuccessDto<ComisionResponseDto>> quitarDestacado(@PathVariable Long id) throws Exception {
        Comision entidad = service.updateDestacadoState(id, false);
        ComisionResponseDto response = mapper.toResponseDto(entidad);
        
        ApiResponseSuccessDto<ComisionResponseDto> res = new ApiResponseSuccessDto<>();
        res.setSuccess(true);
        res.setData(response);
        res.setMessage("destacado");
        
        return ResponseEntity.ok(res);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<Void>> delete(@PathVariable Long id) throws Exception {
        service.deleteById(id);
        ApiResponseSuccessDto<Void> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(null);
        resp.setMessage("Comision con id " + id + " eliminada con éxito");
        return ResponseEntity.ok(resp);
    }

    // No hay handler local: GlobalExceptionHandler centralizará errores
}


