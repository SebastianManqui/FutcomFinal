package com.duoc.futcom.controller;
import com.duoc.futcom.model.Partido;
import com.duoc.futcom.service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/partidos")
public class PartidoController {

    @Autowired
    private PartidoService partidoService;

    @GetMapping
    public List<Partido> listar() {
        return partidoService.listarTodos();
    }

    @PostMapping
    public void crear(@RequestBody Partido partido) {
        partidoService.guardarPartido(partido);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        partidoService.eliminarPartido(id);
    }
}