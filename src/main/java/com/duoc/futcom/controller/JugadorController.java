package com.duoc.futcom.controller;
import com.duoc.futcom.model.Jugador;
import com.duoc.futcom.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @GetMapping
    public List<Jugador> listar() {
        return jugadorService.listarTodos();
    }

    @PostMapping
    public void crear(@RequestBody Jugador jugador) {
        jugadorService.guardar(jugador);
    }
}