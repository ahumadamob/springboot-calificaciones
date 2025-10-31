package com.imb2025.calificaciones.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.imb2025.calificaciones.entity.Sede;
import com.imb2025.calificaciones.service.ISedeService;
import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
import com.imb2025.calificaciones.dto.request.SedeRequestDto;
import com.imb2025.calificaciones.dto.response.SedeResponseDto;
import com.imb2025.calificaciones.dto.mapper.SedeMapper;

import jakarta.validation.Valid;

@RestController
public class SedeController {

    @Autowired  
    private ISedeService sedeService;

    @Autowired
    private SedeMapper sedeMapper;

    @GetMapping("/api/sede")
    public ResponseEntity<ApiResponseSuccessDto<List<SedeResponseDto>>> getAllSedes(){
        List<Sede> lista = sedeService.findAll();
        List<SedeResponseDto> datos = lista.stream().map(sedeMapper::toResponse).collect(Collectors.toList());
        ApiResponseSuccessDto<List<SedeResponseDto>> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(datos);
        resp.setMessage(datos.isEmpty() ? "No hay sedes registradas" : "Listado de sedes");
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/api/sede/{idSede}")
    public ResponseEntity<ApiResponseSuccessDto<SedeResponseDto>> getSedeById(@PathVariable("idSede") Long id){
        Sede sede = sedeService.findById(id);
        SedeResponseDto dto = sedeMapper.toResponse(sede);
        ApiResponseSuccessDto<SedeResponseDto> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(dto);
        resp.setMessage("Sede encontrada");
        return ResponseEntity.ok(resp);
    }

    @PostMapping("/api/sede")
    public ResponseEntity<ApiResponseSuccessDto<SedeResponseDto>> createSede(@Valid @RequestBody SedeRequestDto dto) throws Exception {
        Sede entidad = sedeMapper.fromDto(dto);
        Sede creado = sedeService.create(entidad);
        SedeResponseDto respDto = sedeMapper.toResponse(creado);
        ApiResponseSuccessDto<SedeResponseDto> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(respDto);
        resp.setMessage("Sede creada correctamente");
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    @PutMapping("/api/sede/{idSede}")
    public ResponseEntity<ApiResponseSuccessDto<SedeResponseDto>> updateSede(@PathVariable("idSede") Long id, @Valid @RequestBody SedeRequestDto dto) throws Exception {
        if (!sedeService.existsById(id)) {
            throw new Exception("Sede con ID " + id + " no encontrada.");
        }
        Sede entidad = sedeMapper.fromDto(dto);
        Sede actualizado = sedeService.update(entidad, id);
        SedeResponseDto respDto = sedeMapper.toResponse(actualizado);
        ApiResponseSuccessDto<SedeResponseDto> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(respDto);
        resp.setMessage("Sede actualizada correctamente");
        return ResponseEntity.ok(resp);
    }

    @DeleteMapping("/api/sede/{idSede}")
    public ResponseEntity<ApiResponseSuccessDto<Void>> deleteSede(@PathVariable("idSede") Long id) throws Exception {
        if (!sedeService.existsById(id)) {
            throw new Exception("Sede con ID " + id + " no encontrada.");
        }
        sedeService.deleteById(id);
        ApiResponseSuccessDto<Void> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setMessage("Sede eliminada correctamente");
        resp.setData(null);
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/api/sede/nombre/{nombre}")
    public ResponseEntity<ApiResponseSuccessDto<List<SedeResponseDto>>> getSedesByNombre(@PathVariable String nombre) {
        List<Sede> lista = sedeService.findByNombreIgnoreCase(nombre);
        List<SedeResponseDto> datos = lista.stream().map(sedeMapper::toResponse).collect(Collectors.toList());
        ApiResponseSuccessDto<List<SedeResponseDto>> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(datos);
        resp.setMessage(datos.isEmpty() ? "No hay sedes con ese nombre" : "Listado filtrado por nombre");
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/api/sede/count/direccion/{direccion}")
    public ResponseEntity<ApiResponseSuccessDto<Long>> countSedesByDireccion(@PathVariable String direccion) {
        long cantidad = sedeService.countByDireccionIgnoreCase(direccion);
        ApiResponseSuccessDto<Long> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(cantidad);
        resp.setMessage("Cantidad de sedes con esa dirección");
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/api/sede/activas")
    public ResponseEntity<ApiResponseSuccessDto<List<SedeResponseDto>>> getSedesActivas() {
        List<Sede> lista = sedeService.findByActivaTrue();
        List<SedeResponseDto> datos = lista.stream().map(sedeMapper::toResponse).collect(Collectors.toList());
        ApiResponseSuccessDto<List<SedeResponseDto>> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(datos);
        resp.setMessage(datos.isEmpty() ? "No hay sedes activas" : "Listado de sedes activas");
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/api/sede/inactivas")
    public ResponseEntity<ApiResponseSuccessDto<List<SedeResponseDto>>> getSedesInactivas() {
        List<Sede> lista = sedeService.findByActivaFalse();
        List<SedeResponseDto> datos = lista.stream().map(sedeMapper::toResponse).collect(Collectors.toList());
        ApiResponseSuccessDto<List<SedeResponseDto>> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(datos);
        resp.setMessage(datos.isEmpty() ? "No hay sedes inactivas" : "Listado de sedes inactivas");
        return ResponseEntity.ok(resp);
    }
}
