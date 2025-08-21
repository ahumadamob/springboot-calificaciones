package com.imb2025.calificaciones.service.jpa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.dto.CarreraRequestDto;
import com.imb2025.calificaciones.entity.Carrera;
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

        return repo.findById(id).orElse(null);
    }

    @Override
    public Carrera create(Carrera carrera) {
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
        return carrera;
    }

}
