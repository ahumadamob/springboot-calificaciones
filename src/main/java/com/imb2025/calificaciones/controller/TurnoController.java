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

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
import com.imb2025.calificaciones.dto.mapper.TurnoMapper;
import com.imb2025.calificaciones.dto.request.TurnoRequestDto;
import com.imb2025.calificaciones.dto.response.TurnoResponseDto;
import com.imb2025.calificaciones.entity.Turno;
import com.imb2025.calificaciones.service.ITurnoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/turno")
public class TurnoController {
	
	@Autowired
	private ITurnoService turnoService;
	
	@Autowired
	private TurnoMapper turnoMapper;
	
        @GetMapping
        public ResponseEntity<ApiResponseSuccessDto<List<TurnoResponseDto>>> getAll (){
        	List<Turno> turnos = turnoService.findAll();
        	List<TurnoResponseDto> turnosDto = turnos.stream()
        	    .map(turno -> {
        	        try {
        	            return turnoMapper.toResponseDto(turno);
        	        } catch (Exception e) {
        	            throw new RuntimeException(e);
        	        }
        	    }).toList();

        	ApiResponseSuccessDto<List<TurnoResponseDto>> response = new ApiResponseSuccessDto<>();
        	response.setSuccess(true);
        	response.setData(turnosDto);
        	response.setMessage("Turnos encontrados con éxito");
                return turnosDto.isEmpty()
                                ? ResponseEntity.noContent().build()
                                : ResponseEntity.ok(response);
        }

        @GetMapping("/{id}")
        public ResponseEntity<ApiResponseSuccessDto<TurnoResponseDto>> getById (@PathVariable Long id) throws Exception {
                Turno turno = turnoService.findById(id);
                TurnoResponseDto turnoDto = turnoMapper.toResponseDto(turno);
                ApiResponseSuccessDto<TurnoResponseDto> response = new ApiResponseSuccessDto<>();
                
                response.setSuccess(true);
                response.setMessage("Turno encontrado con éxito");
                response.setData(turnoDto);
                
                return ResponseEntity.ok(response);
        }
        
        @GetMapping("/nombre/{nombre}")
        public ResponseEntity<ApiResponseSuccessDto<List<TurnoResponseDto>>> getTurnosByNombre (@PathVariable String nombre) {
        	List<Turno> turnos = turnoService.mostrarTurnosPorNombre(nombre);
            List<TurnoResponseDto> turnosDto = turnos.stream()
                    .map(t -> {
                        try {
                            return turnoMapper.toResponseDto(t);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .toList();

            ApiResponseSuccessDto<List<TurnoResponseDto>> response = new ApiResponseSuccessDto<>();
            response.setSuccess(true);
                response.setMessage("Turno encontrado con el nombre: " + nombre);
                response.setData(turnosDto);
                
                return ResponseEntity.ok(response);
        }
        @GetMapping("/count/despues/{hora}")
        public ResponseEntity<ApiResponseSuccessDto<Long>> contarTurnosDespuesDe(@PathVariable String hora) {
            LocalTime horaParametro = LocalTime.parse(hora);
            Long cantidad = turnoService.contarTurnosQueTerminanDespuesDe(horaParametro);

            ApiResponseSuccessDto<Long> response = new ApiResponseSuccessDto<>();
            response.setSuccess(true);
            response.setData(cantidad);
            response.setMessage("Cantidad de turnos que terminan después de las " + hora + ": " + cantidad);

            return ResponseEntity.ok(response);
        }

         @PostMapping
          public ResponseEntity<ApiResponseSuccessDto<TurnoResponseDto>> createTurno(@Valid @RequestBody TurnoRequestDto turnoRequestDto) throws Exception {
                 Turno turno = turnoMapper.fromDto(turnoRequestDto);
                 Turno turnoCreado = turnoService.create(turno);
                 
                 TurnoResponseDto turnoDto = turnoMapper.toResponseDto(turnoCreado);
                 ApiResponseSuccessDto<TurnoResponseDto> response = new ApiResponseSuccessDto<>();
                 response.setSuccess(true);
                 response.setData(turnoDto);
                 response.setMessage("El turno ha sido creado con éxito");
                 
                 return ResponseEntity.status(HttpStatus.CREATED).body(response);
            }

         @PutMapping("/{id}")
            public ResponseEntity<ApiResponseSuccessDto<TurnoResponseDto>> updateTurno(@Valid @RequestBody TurnoRequestDto turnoRequestDto, @PathVariable Long id) throws Exception {
                 Turno existente = turnoService.findById(id);
                 if(existente == null){
                        return ResponseEntity.badRequest().build();
                 }
                 Turno turno = turnoMapper.fromDto(turnoRequestDto);
                 Turno turnoActualizado= turnoService.update(turno, id);
                 
                 TurnoResponseDto turnoDto = turnoMapper.toResponseDto(turnoActualizado);
                 
                 ApiResponseSuccessDto<TurnoResponseDto> response = new ApiResponseSuccessDto<>();
                 response.setSuccess(true);
                 response.setData(turnoDto);
                 response.setMessage("El turno ha sido actualizado con éxito");
                 return ResponseEntity.ok(response);
         }


         @DeleteMapping("/{id}")
            public ResponseEntity<ApiResponseSuccessDto<Turno>> deleteTurno(@PathVariable Long id) throws Exception{
                turnoService.deleteById(id);
                
                ApiResponseSuccessDto<Turno> response = new ApiResponseSuccessDto<>();
                response.setMessage("El turno con id: " + id + " fue eliminado con éxito");
                response.setSuccess(true);
                return ResponseEntity.ok(response);
            }
	 
	 @ExceptionHandler(Exception.class)
	 public ResponseEntity<String> handleException(Exception ex) {
		 return ResponseEntity.badRequest().body(ex.getMessage());
	 }
	

}
