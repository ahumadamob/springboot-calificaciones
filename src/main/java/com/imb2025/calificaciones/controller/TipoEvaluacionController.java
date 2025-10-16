package com.imb2025.calificaciones.controller;


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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
import com.imb2025.calificaciones.dto.TipoEvaluacionRequestDto;
import com.imb2025.calificaciones.entity.TipoEvaluacion;
import com.imb2025.calificaciones.service.ITipoEvaluacionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tipoEvaluacion")
public class TipoEvaluacionController {

    @Autowired
    private ITipoEvaluacionService tipoEvaluacionService;

     @GetMapping
    public ResponseEntity<ApiResponseSuccessDto<List<TipoEvaluacion>>> getTodosTipoEvaluacion() {
        List<TipoEvaluacion> lista = tipoEvaluacionService.findAll();
        var resp = new ApiResponseSuccessDto<>(true,
                lista.isEmpty() ? "No hay registros de TipoEvaluacion" : "Lista obtenida correctamente",
                lista);
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<TipoEvaluacion>> getTipoEvaluacionById(@PathVariable Long id) {
        var tipo = tipoEvaluacionService.findById(id);
        return ResponseEntity.ok(new ApiResponseSuccessDto<>(true, "Tipo de Evaluacion encontrada", tipo));
    }

    @PostMapping
    public ResponseEntity<ApiResponseSuccessDto<TipoEvaluacion>> createTipoEvaluacion(
            @Valid @RequestBody TipoEvaluacionRequestDto dto) {
        var entidad = tipoEvaluacionService.fromDto(dto);
        var creado = tipoEvaluacionService.create(entidad);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponseSuccessDto<>(true, "Tipo de Evaluacion creada exitosamente", creado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<TipoEvaluacion>> updateTipoEvaluacion(
            @PathVariable Long id, @Valid @RequestBody TipoEvaluacionRequestDto dto) {
        var entidad = tipoEvaluacionService.fromDto(dto);
        var actualizado = tipoEvaluacionService.update(entidad, id);
        return ResponseEntity.ok(new ApiResponseSuccessDto<>(true, "Tipo de Evaluacion actualizada", actualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<Void>> deleteTipoEvaluacion(@PathVariable Long id) {
        tipoEvaluacionService.deleteById(id);
        return ResponseEntity.ok(new ApiResponseSuccessDto<>(true, "Tipo de Evaluacion eliminada correctamente", null));
    }

    @GetMapping("/buscar")
    public ResponseEntity<ApiResponseSuccessDto<List<TipoEvaluacion>>> search(@RequestParam String q) {
        var lista = tipoEvaluacionService.buscarNombre(q);
        return ResponseEntity.ok(new ApiResponseSuccessDto<>(true, "OK", lista));
    }

    @GetMapping("/contar")
    public ResponseEntity<ApiResponseSuccessDto<Long>> count(@RequestParam String q) {
        long total = tipoEvaluacionService.contarNombre(q);
        return ResponseEntity.ok(new ApiResponseSuccessDto<>(true, "Se contó", total));
    }
}