package com.duoc.futcom.controller;
import com.duoc.futcom.model.Estadio;
import com.duoc.futcom.service.EstadioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


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
    public ResponseEntity<Estadio> guardar(@Valid @RequestBody Estadio estadio) { 
        System.out.println("DEBUG: [EstadioController] -> Intentando crear un nuevo estadio: " + estadio.getNombre());
        
        // Ejecuta el método void del servicio
        estadioService.guardar(estadio);
        
        // Retornamos el estado 201 Created junto con el objeto recibido
        return new ResponseEntity<>(estadio, HttpStatus.CREATED);
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
        
       
        estadioService.guardar(estadioExistente);
        
        
        return ResponseEntity.ok(estadioExistente);
        //revisar
    }
    //DeleteMapping("/{id}") 
    //public ResponseEntity<Void> eliminar3(@PathVariable("id") Integer idEstadio) {
      //  System.out.println("DEBUG: [EstadioController] -> Intentando eliminar estadio ID: " + idEstadio);
        
        
        //Estadio estadioExistente = estadioService.buscarEstadioPorId(idEstadio);
        //if (estadioExistente == null) {
         //   return ResponseEntity.notFound().build(); 
        //}
        
        
        //estadioService.eliminar(idEstadio);
        //return ResponseEntity.noContent().build(); 
    //}
}