package com.imb2025.calificaciones.service.jpa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.entity.Jugador;
import com.imb2025.calificaciones.repository.JugadorRepository;
import com.imb2025.calificaciones.service.IJugadorService;

@Service
public class JugadorServiceImpl implements IJugadorService {
	
	@Autowired
	private JugadorRepository repo;

	@Override
	public List<Jugador> findAll() {
		return repo.findAll();
	}

	@Override
	public Jugador findById(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Jugador save(Jugador jugador) {
		return repo.save(jugador);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
	}

}
