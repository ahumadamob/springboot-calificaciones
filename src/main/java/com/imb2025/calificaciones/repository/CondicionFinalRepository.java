package com.imb2025.calificaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.imb2025.calificaciones.entity.CondicionFinal;
import java.util.List;

@Repository
public interface CondicionFinalRepository extends JpaRepository<CondicionFinal, Long> {

 
    List<CondicionFinal> findByNombre(String nombre);

    
    long countByNombre(String nombre);
    
    
    List<CondicionFinal> findByEsVigenteTrue(); 
    
    List<CondicionFinal> findByEsVigenteFalse(); 
}