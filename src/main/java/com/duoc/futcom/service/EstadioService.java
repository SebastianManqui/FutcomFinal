package com.duoc.futcom.service;
import com.duoc.futcom.model.Estadio;
import com.duoc.futcom.repository.EstadioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EstadioService {

    @Autowired
    private EstadioRepository estadioRepo;

    public List<Estadio> listarTodos() {
        return estadioRepo.findAll();
    }


    public void guardar(Estadio estadio) {
        estadioRepo.save(estadio);
    }

    
    public Estadio buscarEstadioPorId(int id) {
        return estadioRepo.findById(id).orElse(null);
    }

    
    public void eliminar(int id) {
        estadioRepo.deleteById(id);
    }
}