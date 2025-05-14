package com.imb2025.calificaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AlumnoController {

   @Autowired
   AlumnoServices alumnoServices;



    @GetMapping("/entidad")
    public List<Alumno> obtenerTodos(){
        return alumnoServices.getAll();
    }
    @GetMapping("/entidad/{id}")
    public Optional<Alumno> obtenerPorId(@PathVariable Long id){
     return alumnoServices.findById(id);
    }
    @PostMapping("/entidad")
    public Alumno crear(@RequestBody Alumno nuevoAlumno) {
        return alumnoServices.save(nuevoAlumno);
    }

    @PutMapping("/entidad/{id}")
    public Alumno actualizar(@PathVariable Long id, @RequestBody Alumno datosActualizados) {
        return alumnoServices.update(id, datosActualizados);
    }

    @DeleteMapping("/entidad/{id}")
    public void eliminar(@PathVariable Long id) {
        alumnoServices.delete(id);
    }

}
