package com.imb2025.calificaciones.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imb2025.calificaciones.dto.RegistroClaseDTO;
import com.imb2025.calificaciones.entity.RegistroClase;
import com.imb2025.calificaciones.service.IRegistroClaseService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/registro")
public class RegistroClaseController {

    private final IRegistroClaseService iregistroClase;

    public RegistroClaseController(IRegistroClaseService iregistroClase) {
        this.iregistroClase = iregistroClase;
    }

    @GetMapping("/obteneregistros")
    public ResponseEntity<List<RegistroClase>> obtenerTodosLosRegistros() {
        List<RegistroClase> registros = iregistroClase.obtenerTodosLosRegistros();
        if (registros.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 No Content
        }
        return ResponseEntity.ok(registros); // 200 OK
    }

    @GetMapping("/registroclase/{id}")
    public ResponseEntity<RegistroClase> obtenerRegistroPorId(@PathVariable Long id) {
        RegistroClase registro = iregistroClase.obtenerRegistro(id);
        return ResponseEntity.ok(registro); // Si no existe, el servicio debe lanzar excepción
    }

    @PostMapping("/registroclase")
    public ResponseEntity<RegistroClase> registrarClase(@RequestBody RegistroClaseDTO registroDTO) {
        RegistroClase creado = iregistroClase.registrarClase(registroDTO);
        return ResponseEntity.ok(creado);
    }

    @PutMapping("/registroclase/{id}")
    public ResponseEntity<RegistroClase> actualizarRegistro(
            @PathVariable Long id,
            @RequestBody RegistroClaseDTO registroDTO) {
        RegistroClase actualizado = iregistroClase.actualizarRegistro(id, registroDTO);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/eliminarregistroclase/{id}")
    public ResponseEntity<Void> eliminarRegistro(@PathVariable Long id) {
        iregistroClase.eliminarRegistro(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }

}
