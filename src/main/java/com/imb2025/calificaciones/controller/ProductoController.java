package com.imb2025.calificaciones.controller;

import com.imb2025.calificaciones.dto.request.ProductoRequestDto;
import com.imb2025.calificaciones.dto.response.ProductoResponseDto;
import com.imb2025.calificaciones.service.jpa.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;


    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

  
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody ProductoRequestDto requestDto, BindingResult bindingResult) {
        
        
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.toList());
            
            Map<String, List<String>> responseBody = new HashMap<>();
            responseBody.put("errors", errors);
            return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
        }


        try {
            ProductoResponseDto response = productoService.create(requestDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("error", "Error interno al crear el producto"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

   
    @GetMapping("/vigentes")
    public ResponseEntity<List<ProductoResponseDto>> getVigentes() {
        List<ProductoResponseDto> productosVigentes = productoService.findVigentes();
        return new ResponseEntity<>(productosVigentes, HttpStatus.OK);
    }

    
    @GetMapping("/vencidos")
    public ResponseEntity<List<ProductoResponseDto>> getVencidos() {
        List<ProductoResponseDto> productosVencidos = productoService.findVencidos();
        return new ResponseEntity<>(productosVencidos, HttpStatus.OK);
    }
}