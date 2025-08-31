package com.imb2025.calificaciones.service.jpa;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.imb2025.calificaciones.entity.Materia;
import com.imb2025.calificaciones.dto.NivelMateriaRequestDTO;
import com.imb2025.calificaciones.dto.NivelMateriaResponseDTO;
import com.imb2025.calificaciones.entity.Nivel;
import com.imb2025.calificaciones.entity.NivelMateria;
import com.imb2025.calificaciones.exception.EntidadNoEncontradaException;
import com.imb2025.calificaciones.repository.MateriaRepository;
import com.imb2025.calificaciones.repository.NivelMateriaRepository;
import com.imb2025.calificaciones.repository.NivelRepository;
import com.imb2025.calificaciones.service.INivelMateriaService;

import jakarta.transaction.Transactional;

@Service
public class NivelMateriaServiceImpl implements INivelMateriaService {

    @Autowired
    private NivelMateriaRepository repo;

    @Autowired
    private NivelRepository nivelRepository;

    @Autowired
    private MateriaRepository materiaRepository;
    @Override
    @Transactional
    public NivelMateriaResponseDTO crear(NivelMateriaRequestDTO dto) {
        Materia materia = materiaRepository.findById(dto.getMateriaId())
                .orElseThrow(() -> new EntidadNoEncontradaException("Materia no encontrada con ID: " + dto.getMateriaId()));

        Nivel nivel = nivelRepository.findById(dto.getNivelId())
                .orElseThrow(() -> new EntidadNoEncontradaException("Nivel no encontrado con ID: " + dto.getNivelId()));

        NivelMateria nueva = new NivelMateria();
        nueva.setNombre(dto.getNombre());
        nueva.setMateria(materia);
        nueva.setNivel(nivel);

        NivelMateria guardada = repo.save(nueva);

        return mapToResponseDTO(guardada);
    }

    @Override
    public boolean existePorId(Long id) {
        return repo.existsById(id);
    }

    @Override
    public NivelMateriaResponseDTO obtenerPorId(Long id) {
        NivelMateria entidad = repo.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradaException("NivelMateria no encontrada con ID: " + id));

        return mapToResponseDTO(entidad);
    }

    @Override
    public List<NivelMateriaResponseDTO> listarTodos() {
        List<NivelMateria> lista = repo.findAll();

        return lista.stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarPorId(Long id) {
        if (!repo.existsById(id)) {
            throw new EntidadNoEncontradaException("NivelMateria no encontrada con ID: " + id);
        }
        repo.deleteById(id);
    }

    // Método auxiliar para convertir entidad a DTO
    private NivelMateriaResponseDTO mapToResponseDTO(NivelMateria entidad) {
        NivelMateriaResponseDTO dto = new NivelMateriaResponseDTO();
        dto.setId(entidad.getId());
        dto.setNombre(entidad.getNombre());
        dto.setNivelId(entidad.getNivel().getId());
        dto.setNivelNombre(entidad.getNivel().getNombre());
        dto.setMateriaId(entidad.getMateria().getId());
        dto.setMateriaNombre(entidad.getMateria().getNombre());
        return dto;
    }

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<NivelMateria> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NivelMateria save(NivelMateria nuevo) {
		return null;
	}
	@Override
	public NivelMateriaResponseDTO actualizar(Long id, NivelMateriaRequestDTO dto) {
	    NivelMateria existente = repo.findById(id)
	        .orElseThrow(() -> new EntidadNoEncontradaException("NivelMateria no encontrada con ID: " + id));

	    Nivel nivel = nivelRepository.findById(dto.getNivelId())
	        .orElseThrow(() -> new EntidadNoEncontradaException("Nivel no encontrado con ID: " + dto.getNivelId()));

	    Materia materia = materiaRepository.findById(dto.getMateriaId())
	        .orElseThrow(() -> new EntidadNoEncontradaException("Materia no encontrada con ID: " + dto.getMateriaId()));

	    existente.setNombre(dto.getNombre());
	    existente.setDescripcion(dto.getDescripcion());
	    existente.setNivel(nivel);
	    existente.setMateria(materia);

	    NivelMateria guardado = repo.save(existente);

	    return mapToResponseDTO(guardado); // ✅ convertir a DTO de respuesta
	}
	@Override
	public NivelMateria findById(Long id) {
	    return repo.findById(id)
	        .orElseThrow(() -> new EntidadNoEncontradaException(
	            "NivelMateria no encontrada con ID: " + id));
	}
	    }
