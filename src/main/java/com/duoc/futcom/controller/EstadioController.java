package com.duoc.futcom.controller;
import com.duoc.futcom.model.Estadio;
import com.duoc.futcom.service.EstadioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/api/v1/estadios") 
public class EstadioController {

    @Autowired
    private EstadioService estadioService;

  
    @GetMapping
    public List<Estadio> listar() {
        return estadioService.listarTodos();
    }

   
    @GetMapping("/{id}")
    public Estadio buscar(@PathVariable Integer id) {
        return estadioService.buscarEstadioPorId(id);
    }

    @PostMapping
    public void guardar(@Valid @RequestBody Estadio estadio) { 
        estadioService.guardar(estadio);
    }


    @DeleteMapping("/{id}") 
    public void eliminar(@PathVariable Integer id) {
        estadioService.eliminar(id);
    }
    //revisar
    @PutMapping("/{id}")
    public ResponseEntity<Estadio> actualizar(@PathVariable("id") Integer idEstadio, @Valid @RequestBody Estadio estadioDetalles) {
        System.out.println("DEBUG: [EstadioController] -> Intentando actualizar estadio ID: " + idEstadio);
        
        
        Estadio estadioExistente = estadioService.buscarEstadioPorId(idEstadio);
        if (estadioExistente == null) {
            return ResponseEntity.notFound().build(); 
        }
        
        estadioExistente.setNombre(estadioDetalles.getNombre());
        estadioExistente.setCiudad(estadioDetalles.getCiudad());
        estadioExistente.setCapacidad(estadioDetalles.getCapacidad());
        Estadio estadioActualizado = estadioService.guardar(estadioExistente);
        return ResponseEntity.ok(estadioActualizado);
        }
        //revisar
    @DeleteMapping("/{id}") 
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer idEstadio) {
        System.out.println("DEBUG: [EstadioController] -> Intentando eliminar estadio ID: " + idEstadio);
        
        
        Estadio estadioExistente = estadioService.buscarEstadioPorId(idEstadio);
        if (estadioExistente == null) {
            return ResponseEntity.notFound().build(); 
        }
        
        
        estadioService.eliminar(idEstadio);
        return ResponseEntity.noContent().build(); 
    }
}