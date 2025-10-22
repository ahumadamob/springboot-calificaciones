package com.imb2025.calificaciones.controller;


import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
import com.imb2025.calificaciones.dto.mapper.CalendarioMateriaMapper;
import com.imb2025.calificaciones.dto.response.CalendarioMateriaResponseDto;
import jakarta.validation.Valid;
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

import java.util.ArrayList;
import java.util.List;

import com.imb2025.calificaciones.dto.request.CalendarioMateriaRequestDto;
import org.springframework.beans.factory.annotation.Autowired;

import com.imb2025.calificaciones.entity.CalendarioMateria;
import com.imb2025.calificaciones.service.ICalendarioMateriaService;

@RestController
@RequestMapping("/api/calendario-materia")
public class CalendarioMateriaController {

	@Autowired
	private ICalendarioMateriaService calMatSer;
    @Autowired
    private CalendarioMateriaMapper mapper;

    @GetMapping
    public ResponseEntity<ApiResponseSuccessDto<CalendarioMateriaResponseDto>> getAll (){
        List<CalendarioMateria> calendarios = calMatSer.findAll();
        List<CalendarioMateriaResponseDto> calMatResponseDto= new ArrayList<>();

        for(CalendarioMateria n : calendarios){
            calMatResponseDto.add(mapper.toResponseDto(n));
        }

        ApiResponseSuccessDto response = new ApiResponseSuccessDto<>();

        response.setSuccess(true);
        response.setData(calMatResponseDto);
        response.setMessage("Calendarios Materias encontrados con éxito");

        return calendarios.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<CalendarioMateriaResponseDto>> getById(@PathVariable Long id){

        CalendarioMateria calendario = calMatSer.findById(id);
        CalendarioMateriaResponseDto calendarioDto = mapper.toResponseDto(calendario);
        ApiResponseSuccessDto response = new ApiResponseSuccessDto<>();

        response.setSuccess(true);
        response.setData(calendarioDto);
        response.setMessage("Calendario Materia encontrado con éxito");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/materia/{id}")
    public ResponseEntity<ApiResponseSuccessDto<CalendarioMateriaResponseDto>> getCalendarioMateriaByMateriaId(@PathVariable Long id){
        List<CalendarioMateria> calendarioMaterias = calMatSer.findByMateriaId(id);

        List<CalendarioMateriaResponseDto> calendarioDto = new ArrayList<>();

        for(CalendarioMateria n: calendarioMaterias){
            calendarioDto.add(mapper.toResponseDto(n));
        }

        ApiResponseSuccessDto response = new ApiResponseSuccessDto<>();

        response.setSuccess(true);
        response.setData(calendarioDto);
        response.setMessage("Busqueda encontrada de Calendario Materia por Materia ID");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/comision/{comisionId}")
    public ResponseEntity<ApiResponseSuccessDto<CalendarioMateriaResponseDto>> countByComisionId(@PathVariable Long comisionId){

        Long result = calMatSer.countByComisionId(comisionId);

        ApiResponseSuccessDto response = new ApiResponseSuccessDto<>();

        response.setSuccess(true);
        response.setData(result);
        response.setMessage("Contados con exito");

        return ResponseEntity.ok(response);
    }
	
	@PostMapping
	public ResponseEntity<ApiResponseSuccessDto<CalendarioMateriaResponseDto>> create(@Valid @RequestBody CalendarioMateriaRequestDto calendarioMateriaDto) throws Exception {

        CalendarioMateria calendarioMateria;
        calendarioMateria = mapper.fromDto(calendarioMateriaDto);
        calendarioMateria = calMatSer.create(calendarioMateria);
        CalendarioMateriaResponseDto responseDto = mapper.toResponseDto(calendarioMateria);

        ApiResponseSuccessDto response = new ApiResponseSuccessDto<>();
        response.setSuccess(true);
        response.setData(responseDto);
        response.setMessage("Calendario Materia creado con éxito");

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ApiResponseSuccessDto<CalendarioMateriaResponseDto>> update(@Valid @PathVariable Long id,
													@RequestBody CalendarioMateriaRequestDto calendarioMateriaDto) throws Exception {
        CalendarioMateria calendarioMateria = mapper.fromDto(calendarioMateriaDto);
        calendarioMateria = calMatSer.update(calendarioMateria, id);
        CalendarioMateriaResponseDto responseDto = mapper.toResponseDto(calendarioMateria);

        ApiResponseSuccessDto response = new ApiResponseSuccessDto<>();
        response.setSuccess(true);
        response.setData(responseDto);
        response.setMessage("Calendario Materia actualizado con éxito");

        return ResponseEntity.status(HttpStatus.OK).body(response);

	}
	
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<CalendarioMateriaResponseDto>> delete(@PathVariable Long id) throws Exception {
        calMatSer.deleteById(id);
        ApiResponseSuccessDto response = new ApiResponseSuccessDto<>();
        response.setMessage("Calendario Materia con id: " + id + " eliminado con éxito");
        response.setSuccess(true);
        return ResponseEntity.ok(response);
    }
	
}






