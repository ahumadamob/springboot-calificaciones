package com.imb2025.calificaciones.service.jpa;

import com.imb2025.calificaciones.dto.RequisitoMateriaRequestDto;
import com.imb2025.calificaciones.entity.Materia;
import com.imb2025.calificaciones.entity.RequisitoMateria;
import com.imb2025.calificaciones.repository.MateriaRepository;
import com.imb2025.calificaciones.repository.RequisitoMateriaRepository;
import com.imb2025.calificaciones.service.IRequisitoMateriaService;
import com.imb2025.calificaciones.exception.EntidadNoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequisitoMateriaServiceImpl implements IRequisitoMateriaService {

    @Autowired
    private RequisitoMateriaRepository requisitoRepository;

    @Autowired
    private MateriaRepository materiaRepository;

    @Override
    public List<RequisitoMateria> findAll() {
        return requisitoRepository.findAll();
    }

    @Override
    public Optional<RequisitoMateria> findById(Long id) {
        return requisitoRepository.findById(id);
    }

    @Override
    public RequisitoMateria save(RequisitoMateriaRequestDto dto) {
        try {
            // 🆕 Línea 38 → se delega la conversión del DTO a entidad
            RequisitoMateria requisito = mapearDesdeDto(dto);
            return requisitoRepository.save(requisito); // Línea 39
        } catch (EntidadNoEncontradaException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar requisito: " + e.getMessage());
        }
    }

    @Override
    public RequisitoMateria update(RequisitoMateriaRequestDto dto, Long id) {
        try {
            RequisitoMateria existente = requisitoRepository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradaException("Requisito con ID " + id + " no encontrado."));

            RequisitoMateria actualizado = mapearDesdeDto(dto); // 🆕 Línea 53
            existente.setMateria(actualizado.getMateria());
            existente.setMateriaCorrelativa(actualizado.getMateriaCorrelativa());

            return requisitoRepository.save(existente);
        } catch (EntidadNoEncontradaException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar requisito: " + e.getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        requisitoRepository.deleteById(id);
    }

    //  Método nuevo prueba
    private RequisitoMateria mapearDesdeDto(RequisitoMateriaRequestDto dto) {
        Materia materia = materiaRepository.findById(dto.getMateriaId())
            .orElseThrow(() -> new EntidadNoEncontradaException("Materia con ID " + dto.getMateriaId() + " no encontrada."));

        Materia correlativa = materiaRepository.findById(dto.getMateriaRequeridaId())
            .orElseThrow(() -> new EntidadNoEncontradaException("Materia correlativa con ID " + dto.getMateriaRequeridaId() + " no encontrada."));

        RequisitoMateria entidad = new RequisitoMateria();
        entidad.setMateria(materia);
        entidad.setMateriaCorrelativa(correlativa);
        return entidad;
    }
}
