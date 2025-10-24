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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
import com.imb2025.calificaciones.dto.mapper.InscripcionMateriaMapper;
import com.imb2025.calificaciones.dto.request.InscripcionMateriaRequestDto;
import com.imb2025.calificaciones.dto.response.InscripcionMateriaResponseDto;
import com.imb2025.calificaciones.entity.InscripcionMateria;
import com.imb2025.calificaciones.repository.InscripcionMateriaRepository;
import com.imb2025.calificaciones.service.IInscripcionMateriaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/inscripcion-materia")
public class InscripcionMateriaController {

    @Autowired
    private IInscripcionMateriaService inscripcionMateriaService;
    private final InscripcionMateriaMapper mapper;

    public InscripcionMateriaController(InscripcionMateriaMapper inscripcionMateriaMapper) {
        this.mapper = inscripcionMateriaMapper;
    }

    @GetMapping
    public ResponseEntity<ApiResponseSuccessDto<List<InscripcionMateriaResponseDto>>> getAll() {
        List<InscripcionMateria> inscripciones = inscripcionMateriaService.findAll();
        List<InscripcionMateriaResponseDto> inscripcionMateriaDtoList = new ArrayList<InscripcionMateriaResponseDto>();

        for (InscripcionMateria n : inscripciones) {
            inscripcionMateriaDtoList.add(mapper.toResponseDto(n));
        }

        ApiResponseSuccessDto<List<InscripcionMateriaResponseDto>> response = new ApiResponseSuccessDto<>();
        response.setData(inscripcionMateriaDtoList);
        if (inscripcionMateriaDtoList.isEmpty()) {
            response.setMessage("Lista Vacía");
            response.setSuccess(false);
        } else {
            response.setMessage("Lista de Inscripciones");
            response.setSuccess(true);
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/AlumnosInscriptos/{idAlumno}")
    public ResponseEntity<ApiResponseSuccessDto<List<InscripcionMateriaResponseDto>>> getByAlumno(
            @PathVariable Long idAlumno) {
        List<InscripcionMateria> inscripciones = inscripcionMateriaService.findByAlumno_Id(idAlumno);
        List<InscripcionMateriaResponseDto> inscripcionMateriaDtoList = new ArrayList<InscripcionMateriaResponseDto>();

        for (InscripcionMateria n : inscripciones) {
            inscripcionMateriaDtoList.add(mapper.toResponseDto(n));
            ;
        }

        ApiResponseSuccessDto<List<InscripcionMateriaResponseDto>> response = new ApiResponseSuccessDto<>();
        response.setData(inscripcionMateriaDtoList);
        if (inscripcionMateriaDtoList.isEmpty()) {
            response.setMessage("Lista Vacía");
            response.setSuccess(false);
        } else {
            response.setMessage("Lista de Inscripciones del alumno");
            response.setSuccess(true);
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/count/{idAlumno}")
    public ResponseEntity<ApiResponseSuccessDto<Long>> getMethodName(@PathVariable long idAlumno) {
        Long cantidad = inscripcionMateriaService.countByAlumno_Id(idAlumno);
        ApiResponseSuccessDto<Long> response = new ApiResponseSuccessDto<>();
        response.setData(cantidad);
        if (cantidad == 0) {
            response.setMessage("Alumno no inscripto en ninguna materia");
            response.setSuccess(false);
        } else {
            response.setMessage("Cantidad de inscripciones del alumno");
            response.setSuccess(true);
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idInscripcionMateria}")
    public ResponseEntity<ApiResponseSuccessDto<InscripcionMateriaResponseDto>> getById(
            @PathVariable("idInscripcionMateria") Long id) {
        InscripcionMateria inscripcionMateria = inscripcionMateriaService.findById(id);
        ApiResponseSuccessDto<InscripcionMateriaResponseDto> response = new ApiResponseSuccessDto<InscripcionMateriaResponseDto>(
                true, "Lista encontrada con exito", mapper.toResponseDto(inscripcionMateria));
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponseSuccessDto<InscripcionMateriaResponseDto>> create(
            @Valid @RequestBody InscripcionMateriaRequestDto dto) throws Exception {

        try {
            InscripcionMateria inscripcion = inscripcionMateriaService.create(mapper.fromDto(dto));
            ApiResponseSuccessDto<InscripcionMateriaResponseDto> response = new ApiResponseSuccessDto<>();
            response.setData(mapper.toResponseDto(inscripcion));
            response.setMessage("Inscripción creada con éxito");
            response.setSuccess(true);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (BadRequestException ex) {
            ApiResponseSuccessDto<InscripcionMateriaResponseDto> response = new ApiResponseSuccessDto<>();
            response.setSuccess(false);
            response.setMessage(ex.getMessage());
            response.setData(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @PutMapping("/{idInscripcionMateria}")
    public ResponseEntity<ApiResponseSuccessDto<InscripcionMateriaResponseDto>> update(
            @PathVariable Long id, @Valid @RequestBody InscripcionMateriaRequestDto dto) throws Exception {

        InscripcionMateria entity = mapper.fromDto(dto);
        InscripcionMateria updated = inscripcionMateriaService.update(entity, id);

        ApiResponseSuccessDto<InscripcionMateriaResponseDto> response = new ApiResponseSuccessDto<>();
        response.setData(mapper.toResponseDto(updated));
        response.setMessage("Modificación realizada exitosamente");
        response.setSuccess(true);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/inscriptos")
    public ResponseEntity<ApiResponseSuccessDto<List<InscripcionMateriaResponseDto>>> listarInscriptos() {
        List<InscripcionMateriaResponseDto> listaDto = inscripcionMateriaService.findByInscriptoTrue()
                .stream().map(mapper::toResponseDto).toList();
        ApiResponseSuccessDto<List<InscripcionMateriaResponseDto>> response = new ApiResponseSuccessDto<>();
        response.setData(listaDto);
        response.setMessage(listaDto.isEmpty() ? "Lista Vacía" : "Alumnos inscriptos");
        response.setSuccess(!listaDto.isEmpty());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/no-inscriptos")
    public ResponseEntity<ApiResponseSuccessDto<List<InscripcionMateriaResponseDto>>> listarNoInscriptos() {
        List<InscripcionMateria> inscripciones = inscripcionMateriaService.findByInscriptoFalse();
        List<InscripcionMateriaResponseDto> inscripcionMateriaDtoList = new ArrayList<>();

        for (InscripcionMateria n : inscripciones) {
            inscripcionMateriaDtoList.add(mapper.toResponseDto(n));
        }

        ApiResponseSuccessDto<List<InscripcionMateriaResponseDto>> response = new ApiResponseSuccessDto<>();
        response.setData(inscripcionMateriaDtoList);

        if (inscripcionMateriaDtoList.isEmpty()) {
            response.setMessage("Lista Vacía");
            response.setSuccess(false);
        } else {
            response.setMessage("Alumnos no inscriptos");
            response.setSuccess(true);
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/vigentes")
    public ResponseEntity<ApiResponseSuccessDto<List<InscripcionMateriaResponseDto>>> listarVigentes() {
        List<InscripcionMateria> inscripciones = inscripcionMateriaService
                .findByFechaVigenciaGreaterThanEqual(LocalDate.now());
        List<InscripcionMateriaResponseDto> dtoList = new ArrayList<>();
        for (InscripcionMateria im : inscripciones) {
            dtoList.add(mapper.toResponseDto(im));
        }

        ApiResponseSuccessDto<List<InscripcionMateriaResponseDto>> response = new ApiResponseSuccessDto<>();
        response.setData(dtoList);
        response.setMessage(dtoList.isEmpty() ? "Lista Vacía" : "Inscripciones vigentes");
        response.setSuccess(!dtoList.isEmpty());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/vencidos")
    public ResponseEntity<ApiResponseSuccessDto<List<InscripcionMateriaResponseDto>>> listarVencidos() {
        List<InscripcionMateria> inscripciones = inscripcionMateriaService.findByFechaVigenciaLessThan(LocalDate.now());
        List<InscripcionMateriaResponseDto> dtoList = new ArrayList<>();
        for (InscripcionMateria im : inscripciones) {
            dtoList.add(mapper.toResponseDto(im));
        }

        ApiResponseSuccessDto<List<InscripcionMateriaResponseDto>> response = new ApiResponseSuccessDto<>();
        response.setData(dtoList);
        response.setMessage(dtoList.isEmpty() ? "Lista Vacía" : "Inscripciones vencidas");
        response.setSuccess(!dtoList.isEmpty());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/stats/activos")
    public ResponseEntity<ApiResponseSuccessDto<Long>> contarActivos() {
        long total = inscripcionMateriaService.countActivos();
        ApiResponseSuccessDto<Long> response = new ApiResponseSuccessDto<>();
        response.setData(total);
        response.setMessage("Total de inscripciones activas");
        response.setSuccess(true);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/stats/inactivos")
    public ResponseEntity<ApiResponseSuccessDto<Long>> contarInactivos() {
        long total = inscripcionMateriaService.countInactivos();
        ApiResponseSuccessDto<Long> response = new ApiResponseSuccessDto<>();
        response.setData(total);
        response.setMessage("Total de inscripciones inactivas");
        response.setSuccess(true);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{idInscripcionMateria}")
    public ResponseEntity<ApiResponseSuccessDto<String>> delete(@PathVariable("idInscripcionMateria") Long id)
            throws Exception {
        inscripcionMateriaService.deleteById(id);
        ApiResponseSuccessDto<String> response = new ApiResponseSuccessDto<String>(true, "Inscripcion Eliminada",
                "Eliminación exitosa con id " + id);
        return ResponseEntity.ok(response);
    }

}
