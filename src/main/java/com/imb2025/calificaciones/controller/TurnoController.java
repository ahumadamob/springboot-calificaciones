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
import com.imb2025.calificaciones.dto.TurnoRequestDto;
import com.imb2025.calificaciones.entity.Turno;
import com.imb2025.calificaciones.service.ITurnoService;

@RestController
@RequestMapping("/api/turno")
public class TurnoController {
	
	@Autowired
	private ITurnoService turnoService;
	
        @GetMapping
        public ResponseEntity<ApiResponseSuccessDto<Turno>> getAll (){
                List<Turno> turnos = turnoService.findAll();
                ApiResponseSuccessDto response = new  ApiResponseSuccessDto<Turno>();
                
                response.setSuccess(true);
                response.setData(turnos);
                response.setMessage("Turnos encontrados con éxito");
                return turnos.isEmpty()
                                ? ResponseEntity.noContent().build()
                                : ResponseEntity.ok(response);
        }

        @GetMapping("/{id}")
        public ResponseEntity<ApiResponseSuccessDto<Turno>> getById (@PathVariable Long id) {
                Turno turno = turnoService.findById(id);
                ApiResponseSuccessDto<Turno> response = new ApiResponseSuccessDto<>();
                
                response.setSuccess(true);
                response.setMessage("Turno encontrado con éxito");
                response.setData(turno);
                
                return ResponseEntity.ok(response);
        }

         @PostMapping
          public ResponseEntity<ApiResponseSuccessDto<Turno>> createTurno(@RequestBody TurnoRequestDto turnoRequestDto) throws Exception {
                 Turno turno = turnoService.fromDto(turnoRequestDto);
                 turno = turnoService.create(turno);
                 
                 ApiResponseSuccessDto<Turno> response = new ApiResponseSuccessDto<>();
                 response.setSuccess(true);
                 response.setData(turno);
                 response.setMessage("El turno ha sido creado con éxito");
                 
                 return ResponseEntity.status(HttpStatus.CREATED).body(response);
            }

         @PutMapping("/{id}")
            public ResponseEntity<ApiResponseSuccessDto<Turno>> updateTurno(@RequestBody TurnoRequestDto turnoRequestDto, @PathVariable Long id) throws Exception {
                 Turno existente = turnoService.findById(id);
                 if(existente == null){
                        return ResponseEntity.badRequest().build();
                 }
                 Turno turno = turnoService.fromDto(turnoRequestDto);
                 turno = turnoService.update(turno, id);
                 
                 ApiResponseSuccessDto<Turno> response = new ApiResponseSuccessDto<>();
                 response.setSuccess(true);
                 response.setData(turno);
                 response.setMessage("El turno ha sido actulizado con éxito");
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
