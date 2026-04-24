package com.duoc.futcom.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository; 
import com.duoc.futcom.model.Jugador;

public interface PartidoRepository extends JpaRepository<Jugador, Integer> {
    
}