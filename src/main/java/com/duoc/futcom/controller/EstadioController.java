package com.duoc.futcom.controller;
import com.duoc.futcom.model.Estadio;
import com.duoc.futcom.service.EstadioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
}