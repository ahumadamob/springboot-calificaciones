package com.imb2025.calificaciones.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.imb2025.calificaciones.dto.TipoEvaluacionRequestDTO;
import com.imb2025.calificaciones.entity.TipoEvaluacion;
import com.imb2025.calificaciones.service.ITipoEvaluacionService;

@RestController
public class TipoEvaluacionController {
	
	@Autowired
	private ITipoEvaluacionService tipoEvaluacionService;
	
	@GetMapping ("/todosTipoEvaluacion")
	public List<TipoEvaluacion>getTodosTipoEvaluacion() {
		return tipoEvaluacionService.findAll();
	}
	
	@GetMapping ("/tipoEvaluacionById/{idtipoevaluacion}")
	public TipoEvaluacion getTipoEvaluacionById(@PathVariable("idtipoevaluacion") Long id) {
		return tipoEvaluacionService.findById(id);
	}
	
	@PostMapping ("/createTipoEvaluacion")
	public TipoEvaluacion createTipoEvaluacion(@RequestBody TipoEvaluacion tipoEvaluacion) {
		return tipoEvaluacionService.save(tipoEvaluacion);
	}
	
	@PutMapping ("/updateTipoEvaluacion")
	public TipoEvaluacion updateTipoEvaluacion(@RequestBody TipoEvaluacion tipoEvaluacion) {
		return tipoEvaluacionService.save(tipoEvaluacion);
	}
	
	@DeleteMapping ("/deleteTipoEvaluacion/{idtipoevaluacion}")
	public void deleteTipoEvaluacion(@PathVariable("idtipoevaluacion") Long id) {
		tipoEvaluacionService.deleteById(id);
	}
	
	@PutMapping("/tipoEvaluacion/{id}")
	public ResponseEntity<?> actualizarTipoEvaluacion(@PathVariable Long id, @RequestBody TipoEvaluacionRequestDTO dto) {
	    
		TipoEvaluacion tipo = tipoEvaluacionService.findById(id);

	    if (tipo == null) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                             .body("No se encontró el TipoEvaluacion con ID " + id);
	    }

	    tipoEvaluacionService.update(id, dto);
	    return ResponseEntity.ok("Actualizado correctamente");
	}
}
