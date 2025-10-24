package com.imb2025.calificaciones.service.jpa;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.dto.CarreraRequestDto;
import com.imb2025.calificaciones.dto.response.CarreraResponseDto;
import com.imb2025.calificaciones.entity.Carrera;
import com.imb2025.calificaciones.exception.ResourceNotFoundException;
import com.imb2025.calificaciones.repository.CarreraRepository;
import com.imb2025.calificaciones.service.ICarreraService;

@Service
public class CarreraServiceImpl implements ICarreraService {

     @Autowired
        private CarreraRepository repo;

    @Override
    public List<Carrera> findAll() {

    return repo.findAll();

    }

    @Override
    public Carrera findById(Long id) {
        return repo.findById(id)
        	    .orElseThrow(() -> new ResourceNotFoundException(
        	        "Carrera no encontrada con id " + id));
    }

    
    @Override
    public Carrera create(Carrera carrera) throws Exception {
        if(carrera.getActiva() == null) {
            throw new Exception("activa no puede ser nulo");
        }
        return repo.save(carrera);
    }

    @Override
    public Carrera update(Carrera carrera, Long id) throws Exception {
        if(repo.existsById(id)) {
            carrera.setId(id);
            return repo.save(carrera);
        }else {
            throw new Exception("No se encontró jugador con id" + id);
        }

    }

    @Override
    public void deleteById(Long id) throws Exception {
        if (!repo.existsById(id)) {
            throw new Exception("No se puede eliminar el id: " + id + " porque no existe");
        }
        repo.deleteById(id);
    }

    @Override
    public Carrera fromDto(CarreraRequestDto dto) throws Exception {
        if (dto == null) {
            return null;
        }
        Carrera carrera = new Carrera();
        carrera.setNombre(dto.getNombre());
        carrera.setTituloOtorgado(dto.getTituloOtorgado());
        carrera.setActiva(dto.getActiva());
        return carrera;
    }
    
    @Override
    public CarreraResponseDto toResponseDto(Carrera carrera) {
        if (carrera == null) {
            return null;
        }
        CarreraResponseDto dto = new CarreraResponseDto();
        dto.setId(carrera.getId());
        dto.setNombre(carrera.getNombre());
        dto.setTituloOtorgado(carrera.getTituloOtorgado());
        dto.setActiva(carrera.getActiva());
        return dto;
    }
    
    @Override
    public List<Carrera> buscarPorNombre(String nombre) {
        // Usa el método del repo para búsqueda exacta
        return repo.findByNombre(nombre);
    }

    /**
     * Busca carreras por un FRAGMENTO de nombre (ignora mayúsculas/minúsculas).*/
    @Override
    public List<Carrera> buscarPorFragmentoNombre(String fragmento) {
        return repo.findByNombreContainingIgnoreCase(fragmento);
    
    }

    /**
     * Verifica si una carrera ya existe por su nombre (ignora mayúsculas/minúsculas).*/
    @Override
    public boolean existePorNombre(String nombre) {
        return repo.existsByNombreIgnoreCase(nombre);
    }
    
    @Override
    public List<CarreraResponseDto> obtenerCarrerasActivas() {
        List<Carrera> carreras = repo.findByActivaTrue();
        return carreras.stream()
            .map(this::toResponseDto)
            .collect(Collectors.toList());
    }
    
    @Override
    public List<CarreraResponseDto> obtenerCarrerasInactivas() {
        List<Carrera> carreras = repo.findByActivaFalse();
        return carreras.stream()
            .map(this::toResponseDto)
            .collect(Collectors.toList());
    }
}

