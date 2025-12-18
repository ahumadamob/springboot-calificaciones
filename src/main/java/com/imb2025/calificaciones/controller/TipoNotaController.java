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

import com.imb2025.calificaciones.dto.ApiResponseSuccessDto;
import com.imb2025.calificaciones.dto.mapper.TipoNotaMapper;
import com.imb2025.calificaciones.dto.request.TipoNotaRequestDto;
import com.imb2025.calificaciones.dto.response.TipoNotaResponseDto;
import com.imb2025.calificaciones.entity.TipoNota;
import com.imb2025.calificaciones.service.ITipoNotaService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tiponota")
public class TipoNotaController {

    @Autowired
    private ITipoNotaService tipoNotaService;
    
    @Autowired
    private TipoNotaMapper tipoNotaMapper;

    // GET /tiponota - lista todos
    @GetMapping
    public ResponseEntity<ApiResponseSuccessDto<List<TipoNotaResponseDto>>> getAll() {
        List<TipoNota> lista = tipoNotaService.findAll();
        List<TipoNotaResponseDto>tiponotasDtoList = new ArrayList<TipoNotaResponseDto>();
        TipoNotaMapper mapper = new TipoNotaMapper();
        
        for(TipoNota n: lista) {
        	tiponotasDtoList.add(mapper.toResponse(n));
        }
        
        ApiResponseSuccessDto<List<TipoNotaResponseDto>> resp = new ApiResponseSuccessDto<>();
        		resp.setSuccess(true);
        		resp.setData(tiponotasDtoList);
        		resp.setMessage("Listado de tipos de nota");
                
        return ResponseEntity.ok(resp);
    }
    
    @GetMapping("/ordenado")
    public ResponseEntity<ApiResponseSuccessDto<List<TipoNotaResponseDto>>> getAllNotaOrder() {
        List<TipoNota> lista = tipoNotaService.findAllOrder();
        
        List<TipoNotaResponseDto> listaDto = new ArrayList<>();
        for (TipoNota n : lista) {
            listaDto.add(tipoNotaMapper.toResponse(n));
        }
        
        ApiResponseSuccessDto<List<TipoNotaResponseDto>> resp = new ApiResponseSuccessDto<>(
                true,
                "Listado de los nombres de las notas",
                listaDto
        );
        return ResponseEntity.ok(resp);
    }
    
    @GetMapping("/cantidad/{nombre}")
    public ResponseEntity<ApiResponseSuccessDto<Long>> countByNombre(@PathVariable String nombre) {
        long cantidad= tipoNotaService.countByNombre(nombre);
        ApiResponseSuccessDto<Long> resp = new ApiResponseSuccessDto<>(
                true,
                "Cantidad de TipoNota con nombre: " +nombre,
                cantidad
        );
        return ResponseEntity.ok(resp);
    }
    

    // GET /tiponota/{id} - buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<TipoNotaResponseDto>> getById(@PathVariable Long id) {
    	
    	TipoNota tipoNota =tipoNotaService.findById(id);
        TipoNotaResponseDto responseDto = new TipoNotaMapper().toResponse(tipoNota);
        ApiResponseSuccessDto<TipoNotaResponseDto> resp = new ApiResponseSuccessDto<>(
                true,
                "TipoNota encontrada con id " + id,
                responseDto
        );
        return ResponseEntity.ok(resp);
    }


    // POST /tiponota - crear nuevo

    @PostMapping
    public ResponseEntity<ApiResponseSuccessDto<TipoNotaResponseDto>> create(
            @Valid @RequestBody TipoNotaRequestDto tipoNotaDto) {
        
        TipoNota entity = tipoNotaMapper.fromDto(tipoNotaDto);
        
        TipoNota created = tipoNotaService.create(entity);
        
        TipoNotaResponseDto createdDto = tipoNotaMapper.toResponse(created);
        
        ApiResponseSuccessDto<TipoNotaResponseDto> resp = new ApiResponseSuccessDto<>(  // preparar la respuesta
                true,
                "TipoNota creada correctamente",
                createdDto
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    // PUT /tiponota/{id} - actualizar existente
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<TipoNotaResponseDto>> update(@PathVariable Long id, @Valid @RequestBody TipoNotaRequestDto tipoNotaDto) {
       
    	
        TipoNota entity = tipoNotaMapper.fromDto(tipoNotaDto);
    	TipoNota updated = tipoNotaService.update(entity, id); 
    	TipoNotaResponseDto updatedDto = tipoNotaMapper.toResponse(updated);
    	ApiResponseSuccessDto<TipoNotaResponseDto> resp = new ApiResponseSuccessDto<>(
                true,
                "TipoNota actualizada correctamente",
                updatedDto
        );
        return ResponseEntity.ok(resp);
    }

    // DELETE /tiponota/{id} - borrar por id
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<Void>> delete(@PathVariable Long id) {
        tipoNotaService.deleteById(id);
        ApiResponseSuccessDto<Void> resp = new ApiResponseSuccessDto<>(
                true,
                "TipoNota eliminada correctamente",
                null
        );
        return ResponseEntity.ok(resp);
    }
    
    @GetMapping("/descripCorta")
    public ResponseEntity<ApiResponseSuccessDto<List<TipoNotaResponseDto>>> descriCorta(@PathVariable String texto) {
        
    	List<TipoNota> listaDescrCor = tipoNotaService.descriCorta(texto);
       
        List<TipoNotaResponseDto> descripcionCorta = new ArrayList<>();
        for (TipoNota n : listaDescrCor) {
            descripcionCorta.add(tipoNotaMapper.toResponse(n));
        }
        
        ApiResponseSuccessDto<List<TipoNotaResponseDto>> resp = new ApiResponseSuccessDto<>(
                true,
                "Listado de descripcionCorta",
                descripcionCorta
        );
        return ResponseEntity.ok(resp);
    }
    
    

    
}

