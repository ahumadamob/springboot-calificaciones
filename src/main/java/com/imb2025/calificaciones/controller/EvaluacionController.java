package com.imb2025.calificaciones.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
import com.imb2025.calificaciones.dto.mapper.EvaluacionMapper;
import com.imb2025.calificaciones.dto.request.EvaluacionRequestDto;
import com.imb2025.calificaciones.dto.response.EvaluacionResponseDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import com.imb2025.calificaciones.entity.Evaluacion;
import com.imb2025.calificaciones.service.IEvaluacionService;

import jakarta.validation.Valid;
import jakarta.validation.groups.Default;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/evaluacion")
public class EvaluacionController {

    @Autowired
    private IEvaluacionService evaluacionServiceImp;
    @Autowired
    private EvaluacionMapper evaluacionMapper;

    @GetMapping
    public ResponseEntity<ApiResponseSuccessDto<List<EvaluacionResponseDto>>> getAll() {
        List<Evaluacion> evaluaciones = evaluacionServiceImp.findAll();
        List<EvaluacionResponseDto> evaluacionesDto = evaluaciones.stream()
                .map(evaluacionMapper::toResponseDto)
                .collect(Collectors.toList());

        ApiResponseSuccessDto<List<EvaluacionResponseDto>> response = new ApiResponseSuccessDto<>();
        response.setData(evaluacionesDto);
        response.setMessage(evaluacionesDto.isEmpty()
                ? "No se encontraron evaluaciones"
                : "Lista de evaluaciones obtenida exitosamente");
        response.setSuccess(true);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<EvaluacionResponseDto>> getById(@PathVariable Long id)
            throws Exception {
        Evaluacion evaluacion = evaluacionServiceImp.findById(id);
        EvaluacionResponseDto evaluacionDto = evaluacionMapper.toResponseDto(evaluacion);

        ApiResponseSuccessDto<EvaluacionResponseDto> response = new ApiResponseSuccessDto<>();
        response.setMessage("Evaluación encontrada exitosamente");
        response.setData(evaluacionDto);
        response.setSuccess(true);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponseSuccessDto<EvaluacionResponseDto>> create(
            @Validated({ EvaluacionRequestDto.Creacion.class,
                    Default.class }) @RequestBody EvaluacionRequestDto evaluacionRequestDto)
            throws Exception {

        Evaluacion evaluacion = evaluacionServiceImp.create(evaluacionMapper.fromDto(evaluacionRequestDto));
        EvaluacionResponseDto evaluacionDto = evaluacionMapper.toResponseDto(evaluacion);

        ApiResponseSuccessDto<EvaluacionResponseDto> response = new ApiResponseSuccessDto<>();
        response.setMessage("Evaluación creada exitosamente");
        response.setData(evaluacionDto);
        response.setSuccess(true);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<EvaluacionResponseDto>> update(
            @PathVariable Long id,
            @Valid @RequestBody EvaluacionRequestDto newEvaluacionDTO) throws Exception {

        Evaluacion updatedEvaluacion = evaluacionServiceImp.update(
                evaluacionMapper.fromDto(newEvaluacionDTO), id);
        EvaluacionResponseDto evaluacionDto = evaluacionMapper.toResponseDto(updatedEvaluacion);

        ApiResponseSuccessDto<EvaluacionResponseDto> response = new ApiResponseSuccessDto<>();
        response.setMessage("Evaluación actualizada exitosamente");
        response.setData(evaluacionDto);
        response.setSuccess(true);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<EvaluacionResponseDto>> delete(@PathVariable Long id) throws Exception {
        evaluacionServiceImp.deleteById(id);
        ApiResponseSuccessDto<EvaluacionResponseDto> response = new ApiResponseSuccessDto<>();
        response.setMessage("Evaluacion eliminada exitosamente");
        response.setData(null);
        response.setSuccess(true);

        return ResponseEntity.ok(response);

    }

    @GetMapping("/{fechaInicio}/{fechaFinal}")
    public ResponseEntity<ApiResponseSuccessDto<List<EvaluacionResponseDto>>> getByRangoFechas(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFinal) {

        List<Evaluacion> evaluaciones = evaluacionServiceImp.findByFechaBetween(fechaInicio, fechaFinal);
        List<EvaluacionResponseDto> evaluacionesDto = evaluaciones.stream()
                .map(evaluacionMapper::toResponseDto)
                .collect(Collectors.toList());

        ApiResponseSuccessDto<List<EvaluacionResponseDto>> response = new ApiResponseSuccessDto<>();
        response.setMessage("Evaluaciones encontradas entre las fechas indicadas");
        response.setData(evaluacionesDto);
        response.setSuccess(true);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/materia/{materiaId}/comision/{comisionId}")
    public ResponseEntity<ApiResponseSuccessDto<List<EvaluacionResponseDto>>> getByMateriaAndComision(
            @PathVariable long materiaId,
            @PathVariable long comisionId) {

        List<Evaluacion> evaluaciones = evaluacionServiceImp.findByMateriaIdAndComisionId(materiaId, comisionId);
        List<EvaluacionResponseDto> evaluacionesDto = evaluaciones.stream()
                .map(evaluacionMapper::toResponseDto)
                .collect(Collectors.toList());

        ApiResponseSuccessDto<List<EvaluacionResponseDto>> response = new ApiResponseSuccessDto<>();
        response.setMessage("Evaluaciones encontradas por materia: " + materiaId + " y comisión: " + comisionId);
        response.setData(evaluacionesDto);
        response.setSuccess(true);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/count/materia/{materiaId}/comision/{comisionId}")
    public ResponseEntity<ApiResponseSuccessDto<HashMap<String, Long>>> countByMateriaAndComision(
            @PathVariable Long materiaId,
            @PathVariable Long comisionId) {

        Long count = evaluacionServiceImp.countByMateriaIdAndComisionId(materiaId, comisionId);
        HashMap<String, Long> hash = new HashMap<>();
        hash.put("cantidad", count);

        ApiResponseSuccessDto<HashMap<String, Long>> response = new ApiResponseSuccessDto<>();
        response.setData(hash);
        response.setMessage("Cantidad de evaluaciones encontradas");
        response.setSuccess(true);

        return ResponseEntity.ok(response);
    }


    // @ExceptionHandler(Exception.class)
    // public ResponseEntity<String> handleException(Exception ex){
    // return ResponseEntity.badRequest().body(ex.getMessage());
    // }

}
