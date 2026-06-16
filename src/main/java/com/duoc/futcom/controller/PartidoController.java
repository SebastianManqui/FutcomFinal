package com.duoc.futcom.controller;
import com.duoc.futcom.model.Partido;
import com.duoc.futcom.service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    
    @PutMapping("/{id}")
    public ResponseEntity<Partido> actualizar(@PathVariable("id") Integer id, @RequestBody Partido partidoDetalles) {
        System.out.println("DEBUG: [PartidoController] -> Intentando actualizar partido con ID: " + id);
        
      
        Partido partidoExistente = partidoService.buscarPorId(id);
        if (partidoExistente == null) {
            return ResponseEntity.notFound().build();
        }

        partidoExistente.setSeleccionLocal(partidoDetalles.getSeleccionLocal());
        partidoExistente.setSeleccionVisitante(partidoDetalles.getSeleccionVisitante());
        partidoExistente.setEstadio(partidoDetalles.getEstadio());
        
        
        Partido partidoActualizado = partidoService.guardarPartido(partidoExistente);
        
        return ResponseEntity.ok(partidoActualizado); 
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) {
        System.out.println("DEBUG: [PartidoController] -> Intentando eliminar partido con ID: " + id);
        
       
        Partido partidoExistente = partidoService.buscarPorId(id);
        if (partidoExistente == null) {
            return ResponseEntity.notFound().build(); 
        }
        
        
        partidoService.eliminarPartido(id);
        
        return ResponseEntity.noContent().build(); 
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partido> buscarPorId(@PathVariable("id") Integer id) {
         System.out.println("DEBUG: [PartidoController] -> Buscando partido con ID: " + id);
         Partido partido = partidoService.buscarPorId(id);
         return ResponseEntity.ok(partido);
}
}