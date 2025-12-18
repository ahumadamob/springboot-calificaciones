package com.imb2025.calificaciones.service.jpa;

import com.imb2025.calificaciones.entity.Comision;
import com.imb2025.calificaciones.exception.ResourceNotFoundException;
import com.imb2025.calificaciones.repository.ComisionRepository;
import com.imb2025.calificaciones.service.IComisionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComisionServiceImpl implements IComisionService {

    @Autowired
    private ComisionRepository repo;

    @Override
    public List<Comision> findAll() {
        return repo.findAll();
    }

    @Override
    public Comision findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comision no encontrada con id " + id));
    }

    @Override
    public boolean existsById(Long id) {
        return repo.existsById(id);
    }

    @Override
    public Comision create(Comision comision) throws Exception {
        // la validación y conversión DTO->Entidad se hace en el controlador (mapper)
        return repo.save(comision);
    }

    @Override
    public Comision update(Comision comision, Long id) throws Exception {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("Comision con id " + id + " no existe");
        }
        comision.setId(id);
        return repo.save(comision);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("No se puede eliminar el id: " + id + " porque no existe");
        }
        repo.deleteById(id);
    }

    @Override
    public List<Comision> findByNombreContainingIgnoreCase(String nombre) {
        return repo.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public long countBySedeId(Long sedeId) {
        return repo.countBySedeId(sedeId);
    }
    
    @Override 
    
    public java.util.List<Comision> findByDestacadoTrue(){
    	return repo.findByDestacadoTrue();
    }
    
    @Override
    
    public java.util.List<Comision> findByDestacadoFalse(){
    	return repo.findByDestacadoTrue();
    }

	@Override
	public boolean updateDestacadoState(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Comision updateDestacadoState(Long id, boolean b) {
		// TODO Auto-generated method stub
		return null;
	}
}
