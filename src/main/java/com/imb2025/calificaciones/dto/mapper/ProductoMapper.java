package com.imb2025.calificaciones.dto.mapper;

import com.imb2025.calificaciones.dto.request.ProductoRequestDto;
import com.imb2025.calificaciones.dto.response.ProductoResponseDto;
import com.imb2025.calificaciones.entity.Producto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductoMapper {

    
    public Producto fromDto(ProductoRequestDto dto) {
        if (dto == null) {
            return null;
        }

        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());
        

        if (dto.getFechaVigencia() != null && dto.getFechaVigencia().matches("^\\d{4}-\\d{2}-\\d{2}$")) {
            producto.setFechaVigencia(LocalDate.parse(dto.getFechaVigencia()));
        }

        return producto;
    }

    
    public ProductoResponseDto toResponseDto(Producto producto) {
        if (producto == null) {
            return null;
        }

        ProductoResponseDto dto = new ProductoResponseDto();
        dto.setId(producto.getId());
        dto.setNombre(producto.getNombre());
        dto.setPrecio(producto.getPrecio());
        dto.setStock(producto.getStock());
        dto.setFechaVigencia(producto.getFechaVigencia());
        dto.setVersion(producto.getVersion());
        
        return dto;
    }

   
    public List<ProductoResponseDto> toResponseDtoList(List<Producto> productos) {
        return productos.stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }
}