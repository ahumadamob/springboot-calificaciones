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
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;

import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
import com.imb2025.calificaciones.dto.InscripcionMateriaRequestDto;
import com.imb2025.calificaciones.entity.InscripcionMateria;
import com.imb2025.calificaciones.service.IInscripcionMateriaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/inscripcion-materia")
public class InscripcionMateriaController {

    @Autowired
    private IInscripcionMateriaService inscripcionMateriaService;

    @GetMapping
    public ResponseEntity<ApiResponseSuccessDto<List<InscripcionMateria>>> getAll() {
        List<InscripcionMateria> inscripciones = inscripcionMateriaService.findAll();
        ApiResponseSuccessDto<List<InscripcionMateria>> response = new ApiResponseSuccessDto<>();
        if(inscripciones.isEmpty()){
            response.setData(inscripciones);
            response.setMessage("Lista Vacía");
            response.setSuccess(false);
        }else{
            response.setData(inscripciones);
            response.setMessage("Lista de Inscripciones");
            response.setSuccess(true);
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idInscripcionMateria}")
    public ResponseEntity<ApiResponseSuccessDto<InscripcionMateria>> getById(@PathVariable("idInscripcionMateria") Long id) {
        InscripcionMateria inscripcionMateria = inscripcionMateriaService.findById(id);
        ApiResponseSuccessDto<InscripcionMateria> response = new ApiResponseSuccessDto<InscripcionMateria>(
            true, "Lista encontrada con exito",inscripcionMateria);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponseSuccessDto<InscripcionMateria>> create(@Valid @RequestBody InscripcionMateriaRequestDto dto) throws Exception {
            InscripcionMateria inscripcionMateria = inscripcionMateriaService.create(inscripcionMateriaService.fromDto(dto));
            ApiResponseSuccessDto<InscripcionMateria> response = new ApiResponseSuccessDto<InscripcionMateria>(true, "Incripcion creada con exito", inscripcionMateria);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{idInscripcionMateria}")
    public ResponseEntity<ApiResponseSuccessDto<InscripcionMateria>> update(
            @PathVariable("idInscripcionMateria") Long id,
            @RequestBody InscripcionMateriaRequestDto dto) throws Exception {

            InscripcionMateria entity = inscripcionMateriaService.fromDto(dto);
            InscripcionMateria updated = inscripcionMateriaService.update(entity, id);
            ApiResponseSuccessDto<InscripcionMateria> response = new ApiResponseSuccessDto<InscripcionMateria>(true,"Modificacion realizada exitosamente", updated);
            return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{idInscripcionMateria}")
    public ResponseEntity<ApiResponseSuccessDto<String>> delete(@PathVariable("idInscripcionMateria") Long id) throws Exception {
            inscripcionMateriaService.deleteById(id);
            ApiResponseSuccessDto<String> response = new ApiResponseSuccessDto<String>(true, "Inscripcion Eliminada", "Eliminación exitosa con id "+id);
        return ResponseEntity.ok(response);
    }

}
