package com.duoc.futcom.service;
import com.duoc.futcom.model.Partido;
import com.duoc.futcom.repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PartidoService {

    @Autowired
    private PartidoRepository partidoRepo;

    public List<Partido> listarTodos() {
        return partidoRepo.findAll();
    }

    public void guardarPartido(Partido partido) {
        partidoRepo.save(partido);
    }

    public Partido buscarPartidoPorId(int id) {
        return partidoRepo.findById(id).orElse(null);
    }

    public void eliminar(int id) {
        partidoRepo.deleteById(id);
    }
}