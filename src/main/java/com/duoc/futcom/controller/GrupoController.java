package com.duoc.futcom.controller;
import com.duoc.futcom.model.Grupo;
import com.duoc.futcom.service.GrupoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController 
@RequestMapping("/api/v1/grupos") 
public class GrupoController {

    @Autowired
    private GrupoService grupoService;

    @GetMapping
    public List<Grupo> listar() {
        return grupoService.listarTodo();
    }

    @PostMapping
    public void guardar(@Valid @RequestBody Grupo grupo) {
        grupoService.guardar(grupo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        grupoService.eliminar(id);
    }
}