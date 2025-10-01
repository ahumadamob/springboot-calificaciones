package com.imb2025.calificaciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
import com.imb2025.calificaciones.dto.ObraSocialRequestDto;
import com.imb2025.calificaciones.entity.ObraSocial;
import com.imb2025.calificaciones.service.IObraSocialService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/obras-sociales")
public class ObraSocialController {

    @Autowired
    private IObraSocialService obraSocialService;

    @GetMapping
    public ResponseEntity<ApiResponseSuccessDto<List<ObraSocial>>> getAll() {
        List<ObraSocial> obrasSociales = obraSocialService.findAll();

        ApiResponseSuccessDto<List<ObraSocial>> response = new ApiResponseSuccessDto<>();
        response.setSuccess(true);
        response.setMessage("Obras sociales obtenidas con éxito");
        response.setData(obrasSociales);

        return obrasSociales.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<ObraSocial>> getById(@PathVariable Long id) {
        ObraSocial obraSocial = obraSocialService.findById(id);

        ApiResponseSuccessDto<ObraSocial> response = new ApiResponseSuccessDto<>();
        response.setSuccess(true);
        response.setMessage("Obra social encontrada con éxito");
        response.setData(obraSocial);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponseSuccessDto<ObraSocial>> create(@Valid @RequestBody ObraSocialRequestDto dto) {
        ObraSocial obraSocial = obraSocialService.fromDto(dto);
        obraSocial = obraSocialService.create(obraSocial);

        ApiResponseSuccessDto<ObraSocial> response = new ApiResponseSuccessDto<>();
        response.setSuccess(true);
        response.setMessage("Obra social creada con éxito");
        response.setData(obraSocial);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<ObraSocial>> update(@PathVariable Long id,
            @Valid @RequestBody ObraSocialRequestDto dto) throws Exception {

        ObraSocial obraSocial = obraSocialService.fromDto(dto);
        obraSocial = obraSocialService.update(obraSocial, id);

        ApiResponseSuccessDto<ObraSocial> response = new ApiResponseSuccessDto<>();
        response.setSuccess(true);
        response.setMessage("Obra social actualizada con éxito");
        response.setData(obraSocial);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<Void>> delete(@PathVariable Long id) {
        obraSocialService.deleteById(id);

        ApiResponseSuccessDto<Void> response = new ApiResponseSuccessDto<>();
        response.setSuccess(true);
        response.setMessage("Obra social eliminada con éxito");
        response.setData(null);

        return ResponseEntity.ok(response);
    }
}
