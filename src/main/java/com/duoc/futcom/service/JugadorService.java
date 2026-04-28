package com.duoc.futcom.service;
import com.duoc.futcom.model.Jugador;
import com.duoc.futcom.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JugadorService {

    @Autowired
    private JugadorRepository jugadorRepo;

    public List<Jugador> listarTodos() {
        return jugadorRepo.findAll();
    }

    public void guardar(Jugador jugador) {
        jugadorRepo.save(jugador);
    }

    public Jugador buscarPorId(Integer id) {
        return jugadorRepo.findById(id).orElse(null);
    }

    public void eliminar(Integer id) {
        jugadorRepo.deleteById(id);
    }
}