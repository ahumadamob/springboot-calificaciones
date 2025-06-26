package com.imb2025.calificaciones.service;

import java.util.List;
import com.imb2025.calificaciones.entity.Horario;

public interface IHorarioService {

	public List<Horario> getAll();

	public Horario save(Horario nuevoHorario);

	public Horario update(Long id, Horario datosActualizados);

	public void delete(Long id);

	public Horario findById(Long id);

}
