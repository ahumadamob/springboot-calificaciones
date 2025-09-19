package com.imb2025.calificaciones.controller;

import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
import com.imb2025.calificaciones.dto.CursadaRequestDto;
import com.imb2025.calificaciones.entity.Cursada;
import com.imb2025.calificaciones.service.ICursadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
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

    @GetMapping
    public ResponseEntity<ApiResponseSuccessDto<List<Cursada>>> getAllCursada() {
        List<Cursada> data = cursadaService.findAll();

        ApiResponseSuccessDto<List<Cursada>> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(data);
        resp.setMessage("Listado de cursadas");

        return ResponseEntity.ok(resp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<Cursada>> getCursadaById(@PathVariable("id") Long id) {
        Cursada data = cursadaService.findById(id);

        ApiResponseSuccessDto<Cursada> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(data);
        resp.setMessage("Cursada encontrada");

        return ResponseEntity.ok(resp);
    }

    @PostMapping
    public ResponseEntity<ApiResponseSuccessDto<Cursada>> createCursada(@RequestBody CursadaRequestDto dto) throws Exception {
        Cursada cursada = cursadaService.fromDto(dto);
        Cursada createdCursada = cursadaService.create(cursada);

        ApiResponseSuccessDto<Cursada> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(createdCursada);
        resp.setMessage("Cursada creada exitosamente");

        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<Cursada>> updateCursada(@PathVariable Long id, @RequestBody CursadaRequestDto dto) throws Exception {
        Cursada cursada = cursadaService.fromDto(dto);
        Cursada updatedCursada = cursadaService.update(cursada, id);

        ApiResponseSuccessDto<Cursada> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(updatedCursada);
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
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
    }
    }
