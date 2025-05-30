package com.imb2025.calificaciones.controller;

import com.imb2025.calificaciones.service.IAlumnoServices;
import com.imb2025.calificaciones.entity.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AlumnoController {

   @Autowired
   IAlumnoServices IAlumnoServices;



    @GetMapping("/entidad")
    public List<Alumno> obtenerTodos(){
        return IAlumnoServices.getAll();
    }
    @GetMapping("/entidad/{id}")
    public Alumno obtenerPorId(@PathVariable Long id){
     return IAlumnoServices.findById(id);
    }
    @PostMapping("/entidad")
    public Alumno crear(@RequestBody Alumno nuevoAlumno) {
        return IAlumnoServices.save(nuevoAlumno);
    }

    @PutMapping("/entidad/{id}")
    public Alumno actualizar(@PathVariable Long id, @RequestBody Alumno datosActualizados) {
        return IAlumnoServices.update(id, datosActualizados);
    }

    @DeleteMapping("/entidad/{id}")
    public void eliminar(@PathVariable Long id) {
        IAlumnoServices.delete(id);
    }

}
