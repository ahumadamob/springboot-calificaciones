package com.imb2025.calificaciones;

import java.util.List;
import java.util.Optional;

public interface HorarioServices {

	public List<Horario> getAll();

	public Horario save(Horario nuevoHorario);

	public Horario update(Long id, Horario datosActualizados);

	public void delete(Long id);

	public Horario findById(Long id);

}
