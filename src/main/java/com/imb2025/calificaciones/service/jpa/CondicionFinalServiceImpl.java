package com.imb2025.calificaciones.service.jpa;

import com.imb2025.calificaciones.dto.CondicionFinalRequestDto;
import com.imb2025.calificaciones.entity.CondicionFinal;
import com.imb2025.calificaciones.repository.CondicionFinalRepository;
import com.imb2025.calificaciones.service.ICondicionFinalService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CondicionFinalServiceImpl implements ICondicionFinalService {

    @Autowired
    private CondicionFinalRepository repository;

    @Override
    public List<CondicionFinal> findAll() {
        return repository.findAll();
    }

    @Override
    public CondicionFinal create(CondicionFinal condicionFinal) {
        return repository.save(condicionFinal);
    }

    @Override
    public CondicionFinal update(CondicionFinal condicionFinal, Long id) throws Exception {
        if (!repository.existsById(id)) {
            throw new Exception("CondicionFinal not found");
        }
        condicionFinal.setId(id);
        return repository.save(condicionFinal);
    }

    @Override
    public CondicionFinal findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public CondicionFinal fromDto(CondicionFinalRequestDto dto) {
        if (dto == null) {
            return null;
        }
        CondicionFinal condicionFinal = new CondicionFinal();
        condicionFinal.setNombre(dto.getNombre());
        return condicionFinal;
    }
}
