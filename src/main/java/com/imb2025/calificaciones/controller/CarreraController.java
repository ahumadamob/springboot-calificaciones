package com.imb2025.calificaciones.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
import com.imb2025.calificaciones.dto.CarreraRequestDto;
import com.imb2025.calificaciones.entity.Carrera;
import com.imb2025.calificaciones.service.ICarreraService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/carrera")
public class CarreraController {
    
    @Autowired
    private ICarreraService carreraService;
    
    @GetMapping
    public ResponseEntity<List<Carrera>> getAll() {
        List<Carrera> carreras = carreraService.findAll();
        return carreras.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(carreras);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<Carrera>> getById(@PathVariable Long id) {
        Carrera carrera = carreraService.findById(id);
        ApiResponseSuccessDto<Carrera> response = new ApiResponseSuccessDto<>();
        response.setSuccess(true);
        response.setMessage("Carrera encontrada con éxito");
        response.setData(carrera);
        return ResponseEntity.ok(response);
    }
    
    @PostMapping
    public ResponseEntity<ApiResponseSuccessDto<Carrera>> create(@RequestBody @Valid CarreraRequestDto dto) throws Exception {
        Carrera carrera = carreraService.fromDto(dto);
        Carrera created = carreraService.create(carrera);
        ApiResponseSuccessDto<Carrera> response = new ApiResponseSuccessDto<>();
        response.setSuccess(true);
        response.setMessage("Carrera creada con éxito");
        response.setData(created);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Carrera> update(@PathVariable Long id, @RequestBody @Valid CarreraRequestDto dto) throws Exception {
        Carrera existente = carreraService.findById(id);
        if (existente == null) {
            return ResponseEntity.badRequest().build();
        }
        Carrera carrera = carreraService.fromDto(dto);
        return ResponseEntity.ok(carreraService.update(carrera, id));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            carreraService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
  
    @GetMapping("/buscar/nombre-exacto/{nombre}")
    public ResponseEntity<ApiResponseSuccessDto<List<Carrera>>> buscarPorNombreExacto(@PathVariable String nombre) {
        List<Carrera> carreras = carreraService.buscarPorNombre(nombre);
        
        if (carreras.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        
        ApiResponseSuccessDto<List<Carrera>> response = new ApiResponseSuccessDto<>();
        response.setSuccess(true);
        response.setMessage("Carreras encontradas con nombre exacto");
        response.setData(carreras);
        
        return ResponseEntity.ok(response);
    }
    
  
    @GetMapping("/buscar/nombre/{fragmento}")
    public ResponseEntity<ApiResponseSuccessDto<List<Carrera>>> buscarPorFragmentoNombre(@PathVariable String fragmento) {
        List<Carrera> carreras = carreraService.buscarPorFragmentoNombre(fragmento);
        
        if (carreras.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        
        ApiResponseSuccessDto<List<Carrera>> response = new ApiResponseSuccessDto<>();
        response.setSuccess(true);
        response.setMessage("Se encontraron " + carreras.size() + " carrera(s) que contienen '" + fragmento + "'");
        response.setData(carreras);
        
        return ResponseEntity.ok(response);
    }
    
    
    @GetMapping("/existe/{nombre}")
    public ResponseEntity<ApiResponseSuccessDto<Boolean>> existePorNombre(@PathVariable String nombre) {
        boolean existe = carreraService.existePorNombre(nombre);
        
        ApiResponseSuccessDto<Boolean> response = new ApiResponseSuccessDto<>();
        response.setSuccess(true);
        response.setMessage(existe 
            ? "La carrera '" + nombre + "' ya existe en el sistema" 
            : "La carrera '" + nombre + "' no existe en el sistema");
        response.setData(existe);
        
        return ResponseEntity.ok(response);
    }
}