package com.duoc.futcom.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.duoc.futcom.model.Jugador;
import com.duoc.futcom.service.JugadorService;
import java.util.List;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @GetMapping
    public ResponseEntity<List<Jugador>> listar() {
        return ResponseEntity.ok(jugadorService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Void> agregar(@Valid @RequestBody Jugador jugador) {
        jugadorService.guardar(jugador);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // 3. Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Jugador> obtener(@PathVariable Integer id) {
        Jugador jugador = jugadorService.buscarPorId(id);
        return (jugador != null) 
            ? ResponseEntity.ok(jugador) 
            : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable Integer id) {
        jugadorService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}