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

import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
import com.imb2025.calificaciones.entity.TipoNota;
import com.imb2025.calificaciones.service.ITipoNotaService;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/tiponota")
public class TipoNotaController {

    @Autowired
    private ITipoNotaService tipoNotaService;

    // GET /tiponota - lista todos
    @GetMapping
    public ResponseEntity<ApiResponseSuccessDto<List<TipoNota>>> getAll() {
        List<TipoNota> lista = tipoNotaService.findAll();
        ApiResponseSuccessDto<List<TipoNota>> resp = new ApiResponseSuccessDto<>(
                true,
                "Listado de tipos de nota",
                lista
        );
        return ResponseEntity.ok(resp);
    }

    // GET /tiponota/{id} - buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<TipoNota>> getById(@PathVariable Long id) {
        TipoNota tipoNota = tipoNotaService.findById(id);
        ApiResponseSuccessDto<TipoNota> resp = new ApiResponseSuccessDto<>(
                true,
                "TipoNota encontrada con id " + id,
                tipoNota
        );
        return ResponseEntity.ok(resp);
    }


    // POST /tiponota - crear nuevo
    @PostMapping
    public ResponseEntity<ApiResponseSuccessDto<TipoNota>> create(@RequestBody TipoNota tipoNota) {
        TipoNota created = tipoNotaService.create(tipoNota);
        ApiResponseSuccessDto<TipoNota> resp = new ApiResponseSuccessDto<>(
                true,
                "TipoNota creada correctamente",
                created
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);//usamos el httpsStatus devuelve un 201 Created
    }

    // PUT /tiponota/{id} - actualizar existente
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<TipoNota>> update(@PathVariable Long id, @RequestBody TipoNota tipoNota) {
        TipoNota updated = tipoNotaService.update(tipoNota, id);
        ApiResponseSuccessDto<TipoNota> resp = new ApiResponseSuccessDto<>(
                true,
                "TipoNota actualizada correctamente",
                updated
        );
        return ResponseEntity.ok(resp);
    }

    // DELETE /tiponota/{id} - borrar por id
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<Void>> delete(@PathVariable Long id) {
        tipoNotaService.deleteById(id);
        ApiResponseSuccessDto<Void> resp = new ApiResponseSuccessDto<>(
                true,
                "TipoNota eliminada correctamente",
                null
        );
        return ResponseEntity.ok(resp);
    }
}

