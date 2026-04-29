package com.duoc.futcom.service;
import com.duoc.futcom.model.Grupo;
import com.duoc.futcom.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GrupoService {

    @Autowired
    private GrupoRepository grupoRepo;

    public List<Grupo> listarTodo() {
        return grupoRepo.findAll();
    }

    public void guardar(Grupo grupo) {
        grupoRepo.save(grupo);
    }

    public Grupo buscarPorId(Integer id) {
        return grupoRepo.findById(id).orElse(null);
    }

    public void eliminar(Integer id) {
        grupoRepo.deleteById(id);
    }
}