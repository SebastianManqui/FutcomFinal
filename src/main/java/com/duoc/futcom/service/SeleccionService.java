package com.duoc.futcom.service;
import com.duoc.futcom.model.Seleccion;
import com.duoc.futcom.repository.SeleccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SeleccionService {

    @Autowired
    private SeleccionRepository seleccionRepo;


    public List<Seleccion> listarTodas() {
        return seleccionRepo.findAll();
    }

    public void guardaSeleccion(Seleccion seleccion) {
        seleccionRepo.save(seleccion);
    }
    
    public Seleccion buscarSeleccionPorId(int id) {
        return seleccionRepo.findById(id).orElse(null);
    }

    public void eliminarSeleccion(int id) {
        seleccionRepo.deleteById(id);
    }
}