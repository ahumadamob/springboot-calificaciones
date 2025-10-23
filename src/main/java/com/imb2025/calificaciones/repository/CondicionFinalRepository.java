package com.imb2025.calificaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.imb2025.calificaciones.entity.CondicionFinal;
import java.util.List;

@Repository
public interface CondicionFinalRepository extends JpaRepository<CondicionFinal, Long> {

    // 1) Buscar todas las condiciones finales por nombre
    List<CondicionFinal> findByNombre(String nombre);

    // 2) Contar cuántas condiciones finales existen con ese nombre
    long countByNombre(String nombre);
    
    // 3) Nuevo: Listado de condiciones finales vigentes (True)
    List<CondicionFinal> findByEsVigenteTrue(); // findByAtributoBooleanoTrue()
    
    // 4) Nuevo: Listado de condiciones finales no vigentes (False)
    List<CondicionFinal> findByEsVigenteFalse(); // findByAtributoBooleanoFalse()
}