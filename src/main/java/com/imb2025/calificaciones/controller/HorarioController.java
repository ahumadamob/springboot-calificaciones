package com.imb2025.calificaciones.controller;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.imb2025.calificaciones.entity.Horario;
import com.imb2025.calificaciones.service.IHorarioService;

@RestController
@RequestMapping("/api/horario")
public class HorarioController {
	
	@Autowired
	private IHorarioService horarioService;
        @GetMapping ("/entidad")
    public List<Horario> obtenerTodos() {
        return horarioService.findAll();
    }
	
    @PostMapping("/entidad")
    public Horario crear(@RequestBody Horario nuevoHorario) {
        return horarioService.create(nuevoHorario);
    }

    @PutMapping("/entidad/{id}")
    public Horario actualizar(@PathVariable Long id, @RequestBody Horario datosActualizados) {
        try {
            return horarioService.update(datosActualizados, id);
        } catch (Exception e) {
            return null;
        }
    }
	
    @DeleteMapping("/entidad/{id}")
    public void eliminar(@PathVariable Long id) {
            try {
                    horarioService.deleteById(id);
            } catch (Exception e) {
                    // manejar excepción
            }
    }
	
	@GetMapping("/entidad/{id}")
    public Horario obtenerPorId(@PathVariable Long id){
     return horarioService.findById(id);
    }
	
	
	
	
	
}
