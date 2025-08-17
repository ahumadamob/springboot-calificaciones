package com.imb2025.calificaciones.service.jpa;

import java.util.List;

import org.springframework.stereotype.Service;
import com.imb2025.calificaciones.exception.EntidadNoEncontradaException;
import com.imb2025.calificaciones.dto.RegistroClaseRequestDto;
import com.imb2025.calificaciones.entity.Comision;
import com.imb2025.calificaciones.entity.Docente;
import com.imb2025.calificaciones.entity.RegistroClase;

import com.imb2025.calificaciones.repository.ComisionRepository;
import com.imb2025.calificaciones.repository.DocenteRepository;
import com.imb2025.calificaciones.repository.RegistroClaseRepository;
import com.imb2025.calificaciones.service.IRegistroClaseService;

@Service
public class RegistroClaseServiceImpl implements IRegistroClaseService {

    private final RegistroClaseRepository registroClaseRepository;
    private final DocenteRepository docenteRepository;
    private final ComisionRepository comisionRepository;

    public RegistroClaseServiceImpl(RegistroClaseRepository registroClaseRepository,
                                    DocenteRepository docenteRepository,
                                    ComisionRepository comisionRepository) {
        this.registroClaseRepository = registroClaseRepository;
        this.docenteRepository = docenteRepository;
        this.comisionRepository = comisionRepository;
    }

    @Override
    public List<RegistroClase> findAll() {
        return registroClaseRepository.findAll();
    }

    @Override
    public RegistroClase findById(Long id) {
        return registroClaseRepository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradaException("RegistroClase no encontrado con ID: " + id));
    }

    @Override
    public RegistroClase create(RegistroClase registroClase) {
        return registroClaseRepository.save(registroClase);
    }

    @Override
    public void deleteById(Long id) {
        if (!registroClaseRepository.existsById(id)) {
            throw new EntidadNoEncontradaException("RegistroClase no encontrado con ID: " + id);
        }
        registroClaseRepository.deleteById(id);
    }

    @Override
    public RegistroClase update(RegistroClase registroClase, Long id) throws Exception {
        if (!registroClaseRepository.existsById(id)) {
            throw new Exception("RegistroClase no encontrado con ID: " + id);
        }
        registroClase.setId(id);
        return registroClaseRepository.save(registroClase);
    }

    @Override
    public RegistroClase fromDto(RegistroClaseRequestDto dto) throws Exception {
        Docente docente = docenteRepository.findById(dto.getDocenteId())
                .orElseThrow(() -> new Exception("Docente no encontrado con ID: " + dto.getDocenteId()));
        Comision comision = comisionRepository.findById(dto.getComisionId())
                .orElseThrow(() -> new Exception("Comisión no encontrada con ID: " + dto.getComisionId()));
        RegistroClase registro = new RegistroClase();
        registro.setFecha(dto.getFecha());
        registro.setTema(dto.getTema());
        registro.setDocente(docente);
        registro.setComision(comision);
        return registro;
    }
}
