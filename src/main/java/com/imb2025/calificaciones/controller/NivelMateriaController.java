package com.imb2025.calificaciones.controller;

import java.util.List;
import com.imb2025.calificaciones.dto.ApiResponseDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.imb2025.calificaciones.dto.NivelMateriaRequestDTO;
import com.imb2025.calificaciones.dto.NivelMateriaResponseDTO;
import com.imb2025.calificaciones.service.INivelMateriaService;
import com.imb2025.calificaciones.entity.NivelMateria;

@RestController
@RequestMapping("/api/nivelmateria")  // o el endpoint que vos estés usando
public class NivelMateriaController {

    @Autowired
    private INivelMateriaService nivelMateriaService;

    // ✅ GET - Listar todos
    @GetMapping
    public ResponseEntity<List<NivelMateriaResponseDTO>> listarTodos() {
        List<NivelMateriaResponseDTO> lista = nivelMateriaService.listarTodos();
        return ResponseEntity.ok(lista);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<NivelMateria>> getById(@PathVariable Long id) {
        // usar SIEMPRE la variable correcta del servicio:
        NivelMateria entidad = nivelMateriaService.findById(id);

        ApiResponseDTO<NivelMateria> resp = new ApiResponseDTO<>();
        resp.setSuccess(true);
        resp.setData(entidad);
        resp.setMessage("NivelMateria encontrada correctamente");

        return ResponseEntity.ok(resp);
    }
 

    @PutMapping("/{id}")
    public ResponseEntity<NivelMateriaResponseDTO> actualizar(@PathVariable Long id, @RequestBody NivelMateriaRequestDTO dto) {
        if (!nivelMateriaService.existePorId(id)) {
            return ResponseEntity.notFound().build(); // Devuelve 404 si no existe
        }

        NivelMateriaResponseDTO actualizado = nivelMateriaService.actualizar(id, dto);
        return ResponseEntity.ok(actualizado); // Devuelve 200 OK si todo salió bien
    }

    @PostMapping
    public ResponseEntity<NivelMateriaResponseDTO> crear(@RequestBody NivelMateriaRequestDTO dto) {
        NivelMateriaResponseDTO creado = nivelMateriaService.crear(dto);
        return ResponseEntity.ok(creado);
    }
    

    // ✅ DELETE - Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (!nivelMateriaService.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }
        nivelMateriaService.eliminarPorId(id);
        return ResponseEntity.noContent().build();  // 204 sin contenido
    }
}