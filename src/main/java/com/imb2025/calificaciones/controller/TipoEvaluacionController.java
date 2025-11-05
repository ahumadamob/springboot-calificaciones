package com.imb2025.calificaciones.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
import com.imb2025.calificaciones.dto.mapper.TipoEvaluacionMapper;    
import com.imb2025.calificaciones.dto.request.TipoEvaluacionRequestDto;      
import com.imb2025.calificaciones.dto.response.TipoEvaluacionResponseDto;      
import com.imb2025.calificaciones.entity.TipoEvaluacion;
import com.imb2025.calificaciones.service.ITipoEvaluacionService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tipoEvaluacion")
@Validated
public class TipoEvaluacionController {

    @Autowired
    private ITipoEvaluacionService tipoEvaluacionService;

    @Autowired
    private TipoEvaluacionMapper mapper;

    @GetMapping
    public ResponseEntity<ApiResponseSuccessDto<List<TipoEvaluacionResponseDto>>> getTodosTipoEvaluacion() {
        List<TipoEvaluacion> lista = tipoEvaluacionService.findAll();
        var data = lista.stream().map(mapper::toResponse).toList();
        var resp = new ApiResponseSuccessDto<>(
                true,
                data.isEmpty() ? "No hay registros de TipoEvaluacion" : "Lista obtenida correctamente",
                data
        );
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<TipoEvaluacionResponseDto>> getTipoEvaluacionById(@PathVariable Long id) {
        var entidad = tipoEvaluacionService.findById(id);
        var dto = mapper.toResponse(entidad);
        return ResponseEntity.ok(new ApiResponseSuccessDto<>(true, "Tipo de Evaluacion encontrada", dto));
    }

    @PostMapping
    public ResponseEntity<ApiResponseSuccessDto<TipoEvaluacionResponseDto>> createTipoEvaluacion(
            @Valid @RequestBody TipoEvaluacionRequestDto dto) {

        var entidad = mapper.fromRequest(dto);
        var creado = tipoEvaluacionService.create(entidad);
        var respDto = mapper.toResponse(creado);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponseSuccessDto<>(true, "Tipo de Evaluacion creada exitosamente", respDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<TipoEvaluacionResponseDto>> updateTipoEvaluacion(
            @PathVariable Long id, @Valid @RequestBody TipoEvaluacionRequestDto dto) {

        var entidad = mapper.fromRequest(dto);
        var actualizado = tipoEvaluacionService.update(entidad, id);
        var respDto = mapper.toResponse(actualizado);

        return ResponseEntity.ok(new ApiResponseSuccessDto<>(true, "Tipo de Evaluacion actualizada", respDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<Void>> deleteTipoEvaluacion(@PathVariable Long id) {
        tipoEvaluacionService.deleteById(id);
        return ResponseEntity.ok(new ApiResponseSuccessDto<>(true, "Tipo de Evaluacion eliminada correctamente", null));
    }

    @GetMapping("/buscar/{q}")
    public ResponseEntity<ApiResponseSuccessDto<List<TipoEvaluacionResponseDto>>> search(@PathVariable String q) {
        var lista = tipoEvaluacionService.buscarNombre(q);
        var data = lista.stream().map(mapper::toResponse).toList();
        return ResponseEntity.ok(new ApiResponseSuccessDto<>(true, "Búsqueda realizada correctamente", data));
    }

    @GetMapping("/contar/{q}")
    public ResponseEntity<ApiResponseSuccessDto<Long>> count(@PathVariable String q) {
        long total = tipoEvaluacionService.contarNombre(q);
        return ResponseEntity.ok(new ApiResponseSuccessDto<>(true, "Total", total));
    }
}
