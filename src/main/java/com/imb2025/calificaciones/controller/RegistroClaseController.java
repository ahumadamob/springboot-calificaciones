package com.imb2025.calificaciones.controller;


import java.util.List;


import com.imb2025.calificaciones.dto.RegistroClaseDTO;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.imb2025.calificaciones.entity.RegistroClase;
import com.imb2025.calificaciones.service.IRegistroClaseService;


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
                return ResponseEntity.status(404).body("No existe ese registro");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al buscar el registro: " + e.getMessage());
        }
    }



    @PostMapping("/registroclase")
    public ResponseEntity<String> registrarClase(@RequestBody RegistroClaseDTO registro) {
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

    @PutMapping("/validarexistencia/{id}")
    public ResponseEntity<String> validarexistencia(@PathVariable Long id, @RequestBody RegistroClaseDTO registroClaseDTO){
        try {
            iregistroClase.validarIds(id,registroClaseDTO);
            return ResponseEntity.ok("IDs validados");
        }catch (Exception e) {
            return ResponseEntity.status(404).body("Error al eliminar la clase: " + e.getMessage());
        }
    }
}
