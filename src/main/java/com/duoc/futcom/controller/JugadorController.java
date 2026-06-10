package com.duoc.futcom.controller;
import com.duoc.futcom.model.Jugador;
import com.duoc.futcom.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
    public ResponseEntity<Jugador> crear(@RequestBody Jugador jugador) {
        Jugador nuevoJugador = jugadorService.guardar(jugador);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoJugador);
}

   @GetMapping("/{id}")
    public Jugador buscarPorId(@PathVariable("id") Integer id) {
        System.out.println("DEBUG: Buscando ID: " + id);
        return jugadorService.buscarPorId(id);
    }
 
}