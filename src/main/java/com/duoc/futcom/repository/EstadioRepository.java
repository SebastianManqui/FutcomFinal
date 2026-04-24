package com.duoc.futcom.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository; 
import com.duoc.futcom.model.Estadio;

public interface EstadioRepository extends JpaRepository<Estadio, Integer> {
    
}