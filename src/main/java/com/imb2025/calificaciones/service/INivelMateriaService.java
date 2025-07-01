package com.imb2025.calificaciones.service;

import java.util.List;
import java.util.Optional;

import com.imb2025.calificaciones.dto.NivelMateriaRequestDTO;
import com.imb2025.calificaciones.dto.NivelMateriaResponseDTO;
import com.imb2025.calificaciones.entity.NivelMateria;

public interface INivelMateriaService {
	
	NivelMateria findById(Long id);

    NivelMateriaResponseDTO crear(NivelMateriaRequestDTO dto);

    NivelMateriaResponseDTO actualizar(Long id, NivelMateriaRequestDTO dto);

    boolean existePorId(Long id);

    NivelMateriaResponseDTO obtenerPorId(Long id);

    List<NivelMateriaResponseDTO> listarTodos();

    void eliminarPorId(Long id);

	void deleteById(Long id);

	List<NivelMateria> findAll();

	NivelMateria save(NivelMateria nuevo);

	
    
    
}