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



   @PutMapping("/{id}")
    public ResponseEntity<Jugador> actualizar(@PathVariable("id") Integer idJugador, @RequestBody Jugador jugadorDetalles) {
        System.out.println("DEBUG: Intentando actualizar ID: " + idJugador);
        
        Jugador jugadorExistente = jugadorService.buscarPorId(idJugador);
        
        if (jugadorExistente == null) {
            return ResponseEntity.notFound().build(); 
        }
        
        jugadorExistente.setNombre(jugadorDetalles.getNombre());
        jugadorExistente.setEdad(jugadorDetalles.getEdad());
        jugadorExistente.setGoles(jugadorDetalles.getGoles());
        jugadorExistente.setAsistencias(jugadorDetalles.getAsistencias());
        jugadorExistente.setNacionalidad(jugadorDetalles.getNacionalidad());
        jugadorExistente.setClubActual(jugadorDetalles.getClubActual());
        jugadorExistente.setNumero(jugadorDetalles.getNumero());
        jugadorExistente.setPartidos_jugados(jugadorDetalles.getPartidos_jugados());
    
        jugadorExistente.setSeleccion(jugadorDetalles.getSeleccion());
        
        Jugador jugadorActualizado = jugadorService.guardar(jugadorExistente);
        return ResponseEntity.ok(jugadorActualizado); 
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer idJugador) {
        System.out.println("DEBUG: Intentando eliminar ID: " + idJugador);
        
        Jugador jugadorExistente = jugadorService.buscarPorId(idJugador);
        
        if (jugadorExistente == null) {
            return ResponseEntity.notFound().build(); 
        }
        
        
        jugadorService.eliminar(idJugador);
        
        return ResponseEntity.noContent().build(); 
    }
 
}