package com.imb2025.calificaciones.controller;

import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
import com.imb2025.calificaciones.dto.mapper.AlumnoMapper;
import com.imb2025.calificaciones.dto.request.AlumnoRequestDto;
import com.imb2025.calificaciones.dto.response.AlumnoResponseDto;
import com.imb2025.calificaciones.entity.Alumno;
import com.imb2025.calificaciones.service.IAlumnoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    private IAlumnoService alumnoService;

    @Autowired
    private AlumnoMapper alumnoMapper;

    @GetMapping
    public ResponseEntity<List<AlumnoResponseDto>> obtenerTodos() {
        List<Alumno> alumnos = alumnoService.findAll();
        List<AlumnoResponseDto> responseDtos = alumnoMapper.toResponseDtoList(alumnos);

        return responseDtos.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(responseDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<AlumnoResponseDto>> obtenerAlumnoPorId(@PathVariable Long id) {
        Alumno alumno = alumnoService.findById(id);

        AlumnoResponseDto responseDto = alumnoMapper.toResponseDto(alumno);

        ApiResponseSuccessDto<AlumnoResponseDto> response = new ApiResponseSuccessDto<>(
                true, "Alumno encontrado con éxito", responseDto);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponseSuccessDto<AlumnoResponseDto>> crear(@Valid @RequestBody AlumnoRequestDto dto)
            throws Exception {

        // La validación de DTO (@Valid) ocurre antes de esta línea.
        // El mapper convierte y lanza RuntimeException si el formato de fecha es incorrecto.
        Alumno alumnoToCreate = alumnoMapper.fromDto(dto);

        Alumno createdAlumno = alumnoService.create(alumnoToCreate);

        AlumnoResponseDto responseDto = alumnoMapper.toResponseDto(createdAlumno);

        ApiResponseSuccessDto<AlumnoResponseDto> response = new ApiResponseSuccessDto<>(
                true, "Alumno creado con éxito", responseDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<AlumnoResponseDto>> actualizar(@PathVariable Long id,
                                                                               @Valid @RequestBody AlumnoRequestDto dto) throws Exception {

        Alumno alumnoToUpdate = alumnoMapper.fromDto(dto);

        Alumno updatedAlumno = alumnoService.update(alumnoToUpdate, id);

        AlumnoResponseDto responseDto = alumnoMapper.toResponseDto(updatedAlumno);

        ApiResponseSuccessDto<AlumnoResponseDto> response = new ApiResponseSuccessDto<>(
                true, "Alumno actualizado con éxito", responseDto);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/buscar/{apellido}")
    public ResponseEntity<ApiResponseSuccessDto<List<AlumnoResponseDto>>> findByApellido(@PathVariable String apellido) {
        List<Alumno> alumnos = alumnoService.findByApellido(apellido);

        List<AlumnoResponseDto> responseDtos = alumnoMapper.toResponseDtoList(alumnos);

        ApiResponseSuccessDto<List<AlumnoResponseDto>> response = new ApiResponseSuccessDto<>(
                true,
                "Alumnos encontrados con apellido: " + apellido,
                responseDtos
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/contar/{email}")
    public ResponseEntity<ApiResponseSuccessDto<Long>> contarPorEmail(@PathVariable String email) {
        long count = alumnoService.countByEmail(email);
        String message = String.format("Se encontraron %d alumnos con el email: %s", count, email);

        ApiResponseSuccessDto<Long> response = new ApiResponseSuccessDto<>(
                true,
                message,
                count
        );
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Obtiene alumnos donde el atributoBooleano es TRUE")
    @GetMapping("/listado/true")
    public ResponseEntity<List<AlumnoResponseDto>> obtenerListadoTrue() {
        List<Alumno> alumnos = alumnoService.findByAtributoBooleanoTrue();

        List<AlumnoResponseDto> responseDtos = alumnoMapper.toResponseDtoList(alumnos);

        return ResponseEntity.ok(responseDtos);
    }

    @Operation(summary = "Obtiene alumnos donde el atributoBooleano es FALSE")
    @GetMapping("/listado/false")
    public ResponseEntity<List<AlumnoResponseDto>> obtenerListadoFalse() {
        List<Alumno> alumnos = alumnoService.findByAtributoBooleanoFalse();

        List<AlumnoResponseDto> responseDtos = alumnoMapper.toResponseDtoList(alumnos);

        return ResponseEntity.ok(responseDtos);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}