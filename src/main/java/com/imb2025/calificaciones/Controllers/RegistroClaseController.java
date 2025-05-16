package com.imb2025.calificaciones.Controllers;


import java.util.List;



import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imb2025.calificaciones.Entity.RegistroClase;
import com.imb2025.calificaciones.Services.IRegistroClaseService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/registro")
public class RegistroClaseController {

	private final IRegistroClaseService iregistroClase;

	public RegistroClaseController(IRegistroClaseService iregistroClase) {
		
		this.iregistroClase = iregistroClase;
	}
	
	@GetMapping("/obteneregistros")
	public List<RegistroClase>obtenerTodosLosRegistros() {
		
		try {
			return iregistroClase.obtenerTodosLosRegistros();
		} catch (Exception e) {
			   throw new RuntimeException("Error al obtener los registros", e);
		}
	}
	 
	@GetMapping("/registroclase/{id}")
	public ResponseEntity<?> obtenerRegistroPorId(@PathVariable Long id) {
	    try {
	        RegistroClase registro = iregistroClase.obtenerRegistro(id);
	        if (registro != null) {
	            return ResponseEntity.ok(registro);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(500).body("Error al buscar el registro: " + e.getMessage());
	    }
	}
	

	
	@PostMapping("/registroclase")
	public ResponseEntity<String> registrarClase(@RequestBody RegistroClase registro) {
	    try {
	        iregistroClase.registrarClase(registro);
	        return ResponseEntity.ok().body("Registro concretado");
	    } catch (Exception e) {
	        return ResponseEntity.status(500).body("Error al registrar la clase: " + e.getMessage());
	    }
	}

	
	
	
	@DeleteMapping("/eliminarregistroclase/{id}")
	public ResponseEntity<String> eliminarRegistro(@PathVariable Long id){
		try {
			iregistroClase.eliminarRegistro(id);
			return ResponseEntity.ok("Eliminado exitosamente");
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Error al eliminar la clase: " + e.getMessage());
		}
	}
	
	
	
	
	
	
}
