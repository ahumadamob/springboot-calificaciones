package com.imb2025.calificaciones.controller;


import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
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

import java.util.List;

import com.imb2025.calificaciones.dto.CalendarioMateriaRequestDto;
import org.springframework.beans.factory.annotation.Autowired;

import com.imb2025.calificaciones.entity.CalendarioMateria;
import com.imb2025.calificaciones.service.ICalendarioMateriaService;

@RestController
@RequestMapping("/api/calendario-materia")
public class CalendarioMateriaController {

	@Autowired
	private ICalendarioMateriaService calMatSer;
	
	
    @GetMapping
    public ResponseEntity<ApiResponseSuccessDto<CalendarioMateria>> getAll (){
        List<CalendarioMateria> calendarios = calMatSer.findAll();

        ApiResponseSuccessDto response = new ApiResponseSuccessDto<CalendarioMateria>();

        response.setSuccess(true);
        response.setData(calendarios);
        response.setMessage("Calendarios Materias encontrados con éxito");

        return calendarios.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<CalendarioMateria>> getById(@PathVariable Long id){

        CalendarioMateria calendario = calMatSer.findById(id);

        ApiResponseSuccessDto response = new ApiResponseSuccessDto<CalendarioMateria>();

        response.setSuccess(true);
        response.setData(calendario);
        response.setMessage("Calendario Materia encontrado con éxito");

        return ResponseEntity.ok(response);
    }
	
	@PostMapping
	public ResponseEntity<ApiResponseSuccessDto<CalendarioMateria>> create(@RequestBody CalendarioMateriaRequestDto calendarioMateriaDto) throws Exception {

        CalendarioMateria calendarioMateria;
        calendarioMateria = calMatSer.fromDto(calendarioMateriaDto);
        calendarioMateria = calMatSer.create(calendarioMateria);

        ApiResponseSuccessDto response = new ApiResponseSuccessDto<>();
        response.setSuccess(true);
        response.setData(calendarioMateria);
        response.setMessage("Calendario Materia creado con éxito");

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ApiResponseSuccessDto<CalendarioMateria>> update(@PathVariable Long id,
													@RequestBody CalendarioMateriaRequestDto calendarioMateriaDto) throws Exception {
        CalendarioMateria calendarioMateria;
        calendarioMateria = calMatSer.fromDto(calendarioMateriaDto);
        calendarioMateria = calMatSer.update(calendarioMateria, id);

        ApiResponseSuccessDto response = new ApiResponseSuccessDto<>();
        response.setSuccess(true);
        response.setData(calendarioMateria);
        response.setMessage("Calendario Materia actualizado con éxito");

        return ResponseEntity.status(HttpStatus.OK).body(response);

	}
	
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<CalendarioMateria>> delete(@PathVariable Long id) throws Exception {
        calMatSer.deleteById(id);
        ApiResponseSuccessDto response = new ApiResponseSuccessDto<>();
        response.setMessage("Calendario Materia con id: " + id + " eliminado con éxito");
        response.setSuccess(true);
        return ResponseEntity.ok(response);
    }
	
}






