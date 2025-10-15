package com.imb2025.calificaciones.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.imb2025.calificaciones.entity.Sede;
import com.imb2025.calificaciones.service.ISedeService;
import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
import com.imb2025.calificaciones.dto.SedeRequestDto;
import com.imb2025.calificaciones.exception.ResourceNotFoundException;
import jakarta.validation.Valid;

@RestController
public class SedeController {

    @Autowired  
    private ISedeService sedeService;

    @GetMapping("/api/sede")
    public ResponseEntity<ApiResponseSuccessDto<List<Sede>>> getAllSedes(){
        List<Sede> lista = sedeService.findAll();
        ApiResponseSuccessDto<List<Sede>> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(lista);
        resp.setMessage(lista.isEmpty() ? "No hay sedes registradas" : "Listado de sedes");
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/api/sede/{idSede}")
    public ResponseEntity<ApiResponseSuccessDto<Sede>> getSedeById(@PathVariable("idSede") Long id){
        Sede sede = sedeService.findById(id);
        ApiResponseSuccessDto<Sede> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(sede);
        resp.setMessage("Sede encontrada");
        return ResponseEntity.ok(resp);
    }

    @PostMapping("/api/sede")
    public ResponseEntity<ApiResponseSuccessDto<Sede>> createSede(@Valid @RequestBody SedeRequestDto dto) throws Exception {
        Sede creado = sedeService.createFromDto(dto);
        ApiResponseSuccessDto<Sede> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(creado);
        resp.setMessage("Sede creada correctamente");
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    @PutMapping("/api/sede/{idSede}")
    public ResponseEntity<ApiResponseSuccessDto<Sede>> updateSede(@PathVariable("idSede") Long id, @Valid @RequestBody Sede sede) throws Exception {
        if (!sedeService.existsById(id)) {
            throw new Exception("Sede con ID " + id + " no encontrada.");
        }
        Sede actualizado = sedeService.update(sede, id);
        ApiResponseSuccessDto<Sede> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(actualizado);
        resp.setMessage("Sede actualizada correctamente");
        return ResponseEntity.ok(resp);
    }

    @DeleteMapping("/api/sede/{idSede}")
    public ResponseEntity<ApiResponseSuccessDto<Void>> deleteSede(@PathVariable("idSede") Long id) throws Exception {
        if (!sedeService.existsById(id)) {
            throw new Exception("Sede con ID " + id + " no encontrada.");
        }
        sedeService.deleteById(id);
        ApiResponseSuccessDto<Void> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setMessage("Sede eliminada correctamente");
        resp.setData(null);
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/api/sede/nombre/{nombre}")
    public ResponseEntity<ApiResponseSuccessDto<List<Sede>>> getSedesByNombre(@PathVariable String nombre) {
        List<Sede> lista = sedeService.findByNombreIgnoreCase(nombre);
        ApiResponseSuccessDto<List<Sede>> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(lista);
        resp.setMessage(lista.isEmpty() ? "No hay sedes con ese nombre" : "Listado filtrado por nombre");
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/api/sede/count/direccion/{direccion}")
    public ResponseEntity<ApiResponseSuccessDto<Long>> countSedesByDireccion(@PathVariable String direccion) {
        long cantidad = sedeService.countByDireccionIgnoreCase(direccion);
        ApiResponseSuccessDto<Long> resp = new ApiResponseSuccessDto<>();
        resp.setSuccess(true);
        resp.setData(cantidad);
        resp.setMessage("Cantidad de sedes con esa dirección");
        return ResponseEntity.ok(resp);
    }
}