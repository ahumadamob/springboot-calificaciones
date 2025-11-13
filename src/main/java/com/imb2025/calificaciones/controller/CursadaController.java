package com.imb2025.calificaciones.controller;

import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
import com.imb2025.calificaciones.dto.mapper.CursadaMapper;
import com.imb2025.calificaciones.dto.request.CursadaRequestDto;
import com.imb2025.calificaciones.dto.response.CursadaResponseDto;
import com.imb2025.calificaciones.entity.Cursada;
import com.imb2025.calificaciones.service.ICursadaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cursada")
public class CursadaController {

    @Autowired
    private ICursadaService cursadaService;

    @Autowired
    private CursadaMapper cursadaMapper;

    @GetMapping
    public ResponseEntity<ApiResponseSuccessDto<List<CursadaResponseDto>>> getAllCursada() {
        List<Cursada> data = cursadaService.findAll();

        List<CursadaResponseDto> responseList = data.stream()
                .map(cursadaMapper::toResponseDto)
                .toList();

        ApiResponseSuccessDto<List<CursadaResponseDto>> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(responseList);
        resp.setMessage("Listado de cursadas");

        return ResponseEntity.ok(resp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<CursadaResponseDto>> getCursadaById(@PathVariable("id") Long id) {
        Cursada data = cursadaService.findById(id);

        ApiResponseSuccessDto<CursadaResponseDto> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(cursadaMapper.toResponseDto(data));
        resp.setMessage("Cursada encontrada");

        return ResponseEntity.ok(resp);
    }

    @GetMapping("/alumno/{nombre}")
    public ResponseEntity<ApiResponseSuccessDto<List<CursadaResponseDto>>> getCursadasByAlumno(@PathVariable String nombre) {
        List<Cursada> data = cursadaService.findByNombreAlumno(nombre);

        List<CursadaResponseDto> dtoList = data.stream()
                .map(cursadaMapper::toResponseDto)
                .toList();

        ApiResponseSuccessDto<List<CursadaResponseDto>> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(dtoList);
        resp.setMessage("Listado de cursadas del alumno: " + nombre);

        return ResponseEntity.ok(resp);
    }

    @GetMapping("/materia/{nombreMateria}/count")
    public ResponseEntity<ApiResponseSuccessDto<Long>> countCursadasByMateria(@PathVariable String nombreMateria) {
        Long cantidad = cursadaService.countByNombreMateria(nombreMateria);

        ApiResponseSuccessDto<Long> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(cantidad);
        resp.setMessage("Cantidad de cursadas de la materia: " + nombreMateria);

        return ResponseEntity.ok(resp);
    }

    @PostMapping
    public ResponseEntity<ApiResponseSuccessDto<CursadaResponseDto>> createCursada(
            @Valid @RequestBody CursadaRequestDto dto) throws Exception {

        
        Cursada cursada = cursadaMapper.fromDto(dto);
        Cursada createdCursada = cursadaService.create(cursada);

        
        ApiResponseSuccessDto<CursadaResponseDto> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(cursadaMapper.toResponseDto(createdCursada));
        resp.setMessage("Cursada creada exitosamente");

        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<CursadaResponseDto>> updateCursada(
            @PathVariable Long id,
            @Valid @RequestBody CursadaRequestDto dto) throws Exception {

        Cursada cursada = cursadaMapper.fromDto(dto);
        Cursada updatedCursada = cursadaService.update(cursada, id);

        ApiResponseSuccessDto<CursadaResponseDto> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(cursadaMapper.toResponseDto(updatedCursada));
        resp.setMessage("Cursada actualizada exitosamente");

        return ResponseEntity.ok(resp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<String>> deleteById(@PathVariable Long id) throws Exception {
        cursadaService.deleteById(id);

        ApiResponseSuccessDto<String> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData("Cursada eliminada");
        resp.setMessage("Eliminación exitosa");

        return ResponseEntity.ok(resp);
    }
}

   // @ExceptionHandler(Exception.class)
    //public ResponseEntity<String> handleException(Exception ex){
    //        return ResponseEntity.badRequest().body(ex.getMessage());
   // }
   
