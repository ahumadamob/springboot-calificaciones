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
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
import com.imb2025.calificaciones.entity.TipoEvaluacion;
import com.imb2025.calificaciones.service.ITipoEvaluacionService;

@RestController
@RequestMapping("/api/tipoEvaluacion")
public class TipoEvaluacionController {

    @Autowired
    private ITipoEvaluacionService tipoEvaluacionService;

    @GetMapping("/tipoEvaluacion")
    public ResponseEntity<ApiResponseSuccessDto<List<TipoEvaluacion>>> getTodosTipoEvaluacion() {
        List<TipoEvaluacion> lista = tipoEvaluacionService.findAll();
        
        ApiResponseSuccessDto<List<TipoEvaluacion>> resp = new ApiResponseSuccessDto<>(
                true,
                lista.isEmpty() ? "No hay registros de TipoEvaluacion" : "Lista de TipoEvaluacion obtenida correctamente",
                lista
        );

        return lista.isEmpty()
                ? ResponseEntity.status(HttpStatus.NO_CONTENT).body(resp)
                : ResponseEntity.ok(resp);
    }

    @GetMapping("/tipoEvaluacion/{id}")
    public ResponseEntity<ApiResponseSuccessDto<TipoEvaluacion>> getTipoEvaluacionById(@PathVariable Long id) {
        TipoEvaluacion tipo = tipoEvaluacionService.findById(id);

        ApiResponseSuccessDto<TipoEvaluacion> resp = new ApiResponseSuccessDto<>(
                true, "Tipo de Evaluacion encontrada", 
                tipo
        );

        return ResponseEntity.ok(resp);
    }
    
    @PostMapping("/tipoEvaluacion")
    public ResponseEntity<ApiResponseSuccessDto<TipoEvaluacion>> createTipoEvaluacion(@RequestBody TipoEvaluacion tipoEvaluacion) {
        TipoEvaluacion creado = tipoEvaluacionService.create(tipoEvaluacion);

        ApiResponseSuccessDto<TipoEvaluacion> resp = new ApiResponseSuccessDto<>(
                true, "Tipo de Evaluacion creada exitosamente",
                creado
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }


    @PutMapping("/tipoEvaluacion/{id}")
    public ResponseEntity<ApiResponseSuccessDto<TipoEvaluacion>> updateTipoEvaluacion(
            @PathVariable Long id,
            @RequestBody TipoEvaluacion tipoEvaluacion) throws Exception {

        TipoEvaluacion actualizado = tipoEvaluacionService.update(tipoEvaluacion, id);

        ApiResponseSuccessDto<TipoEvaluacion> resp = new ApiResponseSuccessDto<>(
                true,
                "Tipo de Evaluacion actualizada",
                actualizado
        );

        return ResponseEntity.ok(resp);
    }

    @DeleteMapping("/tipoEvaluacion/{id}")
    public ResponseEntity<ApiResponseSuccessDto<Void>> deleteTipoEvaluacion(@PathVariable Long id) throws Exception {
        tipoEvaluacionService.deleteById(id);

        ApiResponseSuccessDto<Void> resp = new ApiResponseSuccessDto<>(
                true,
                "Tipo de Evaluacion eliminada correctamente",
                null
        );

        return ResponseEntity.ok(resp);
    }
    
   
}
