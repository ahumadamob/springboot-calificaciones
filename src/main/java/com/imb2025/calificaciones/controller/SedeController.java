package com.imb2025.calificaciones.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.imb2025.calificaciones.entity.Sede;
import com.imb2025.calificaciones.service.ISedeService;
import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;

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
    public ResponseEntity<ApiResponseSuccessDto<Sede>> createSede(@RequestBody Sede sede){
        try {
            Sede creado = sedeService.create(sede);
            ApiResponseSuccessDto<Sede> resp = new ApiResponseSuccessDto<>();
            resp.setSuccess(true);
            resp.setData(creado);
            resp.setMessage("Sede creada correctamente");
            return ResponseEntity.status(HttpStatus.CREATED).body(resp);
        } catch (Exception ex) {
            ApiResponseSuccessDto<Sede> resp = new ApiResponseSuccessDto<>();
            resp.setSuccess(false);
            resp.setMessage(ex.getMessage());
            resp.setData(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
        }
    }

    @PutMapping("/api/sede/{idSede}")
    public ResponseEntity<ApiResponseSuccessDto<Sede>> updateSede(@PathVariable("idSede") Long id, @RequestBody Sede sede){
        try {
            Sede actualizado = sedeService.update(sede, id);
            ApiResponseSuccessDto<Sede> resp = new ApiResponseSuccessDto<>();
            resp.setSuccess(true);
            resp.setData(actualizado);
            resp.setMessage("Sede actualizada correctamente");
            return ResponseEntity.ok(resp);
        } catch (Exception ex) {
            ApiResponseSuccessDto<Sede> resp = new ApiResponseSuccessDto<>();
            resp.setSuccess(false);
            resp.setMessage(ex.getMessage());
            resp.setData(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
        }
    }

    @DeleteMapping("/api/sede/{idSede}")
    public ResponseEntity<ApiResponseSuccessDto<Void>> deleteSede(@PathVariable("idSede") Long id){
        try {
            sedeService.deleteById(id);
            ApiResponseSuccessDto<Void> resp = new ApiResponseSuccessDto<>();
            resp.setSuccess(true);
            resp.setMessage("Sede eliminada correctamente");
            resp.setData(null);
            return ResponseEntity.ok(resp);
        } catch (Exception ex) {
            ApiResponseSuccessDto<Void> resp = new ApiResponseSuccessDto<>();
            resp.setSuccess(false);
            resp.setMessage(ex.getMessage());
            resp.setData(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}

