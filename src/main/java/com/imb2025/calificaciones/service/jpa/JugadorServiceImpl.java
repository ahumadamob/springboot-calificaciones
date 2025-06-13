package com.imb2025.calificaciones.service.jpa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.dto.JugadorRequestDTO;
import com.imb2025.calificaciones.entity.Club;
import com.imb2025.calificaciones.entity.Jugador;
import com.imb2025.calificaciones.repository.ClubRepository;
import com.imb2025.calificaciones.repository.JugadorRepository;
import com.imb2025.calificaciones.service.IJugadorService;

@Service
public class JugadorServiceImpl implements IJugadorService {
	
	@Autowired
	private JugadorRepository repo;
	
	@Autowired
	private ClubRepository repoClub;

	@Override
	public List<Jugador> findAll() {
		return repo.findAll();
	}

	@Override
	public Jugador findById(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Jugador create(Jugador jugador) {
		return repo.save(jugador);
	}
	
	@Override
	public Jugador update(Jugador jugador, Long id) throws Exception {
		if(repo.existsById(id)) {
			jugador.setId(id);
			return repo.save(jugador);
		}else {
			throw new Exception("No se encontró jugador con id" + id);
		}
		
	}	

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
	}

	@Override
	public Jugador mapFromDto(JugadorRequestDTO jugadorRequestDto) throws Exception {
		Jugador jugador = new Jugador();
		jugador.setApellido(jugadorRequestDto.getApellido());
		jugador.setNombre(jugadorRequestDto.getNombre());
		
		
		Club club = repoClub.findById(jugadorRequestDto.getClubId())
				.orElseThrow(() -> new Exception("Club no encontrado"));
		
		jugador.setClub(club);
		
		return jugador;
	}

}
