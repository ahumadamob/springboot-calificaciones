package com.imb2025.calificaciones.service.jpa;

import com.imb2025.calificaciones.dto.request.ProductoRequestDto;
import com.imb2025.calificaciones.dto.response.ProductoResponseDto;
import com.imb2025.calificaciones.entity.Producto;
import com.imb2025.calificaciones.dto.mapper.ProductoMapper;
import com.imb2025.calificaciones.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;


    public ProductoService(ProductoRepository productoRepository, ProductoMapper productoMapper) {
        this.productoRepository = productoRepository;
        this.productoMapper = productoMapper;
    }

    @Transactional
    public ProductoResponseDto create(ProductoRequestDto requestDto) {
        Producto producto = productoMapper.fromDto(requestDto);
        Producto savedProducto = productoRepository.save(producto);
        return productoMapper.toResponseDto(savedProducto);
    }
    
   
    @Transactional(readOnly = true)
    public List<ProductoResponseDto> findVigentes() {
        LocalDate hoy = LocalDate.now();
        List<Producto> vigentes = productoRepository.findByFechaVigenciaGreaterThanEqual(hoy);
        return productoMapper.toResponseDtoList(vigentes);
    }

    @Transactional(readOnly = true)
    public List<ProductoResponseDto> findVencidos() {
        LocalDate hoy = LocalDate.now();
        List<Producto> vencidos = productoRepository.findByFechaVigenciaLessThan(hoy);
        return productoMapper.toResponseDtoList(vencidos);
    }
}