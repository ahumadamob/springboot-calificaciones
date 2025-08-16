package com.imb2025.calificaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imb2025.calificaciones.entity.Sede;

/* INTERFACE REPOSITORY EXTENDIENDO JPA REPOSITORY
 	Esta interface lleva dos parámetros:
  1° Tipo de dato creado(Sede)
  2° Tipo de dato que usamos para el Id(Long --> sedeID*/

public interface SedeRepository extends JpaRepository<Sede,Long>  {

}
