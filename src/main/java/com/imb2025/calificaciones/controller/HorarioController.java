package com.imb2025.calificaciones.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imb2025.calificaciones.entity.Horario;
import com.imb2025.calificaciones.service.IHorarioService;

@RestController
@RequestMapping("/api/horario")
public class HorarioController {
	
	@Autowired
	private IHorarioService horarioService;
	@GetMapping ("/entidad")
    public List<Horario> obtenerTodos() {
        return horarioService.getAll();
    }
	
	@PostMapping("/entidad")
	public Horario crear(@RequestBody Horario nuevoHorario) {
	    return horarioService.save(nuevoHorario);
	}
	
	@PutMapping("/entidad/{id}")
	public Horario actualizar(@PathVariable Long id, @RequestBody Horario datosActualizados) {
	    return horarioService.update(id, datosActualizados);
	}
	
	@DeleteMapping("/entidad/{id}")
	public void eliminar(@PathVariable Long id) {
	    horarioService.delete(id);
	}
	
	@GetMapping("/entidad/{id}")
    public Horario obtenerPorId(@PathVariable Long id){
     return horarioService.findById(id);
    }
	
	
	
	
	
}
