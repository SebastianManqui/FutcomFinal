package com.duoc.futcom.controller;
import com.duoc.futcom.model.Seleccion;
import com.duoc.futcom.service.SeleccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/selecciones") 
public class SeleccionController {

    @Autowired
    private SeleccionService seleccionService;

    @GetMapping
    public List<Seleccion> listar() {
        return seleccionService.listarTodas();
    }

    @GetMapping("/{id}")
    public Seleccion buscar(@PathVariable int id) {
        return seleccionService.buscarSeleccionPorId(id);
    }

    @PostMapping
    public void crear(@RequestBody Seleccion seleccion) {
        seleccionService.guardaSeleccion(seleccion);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        seleccionService.eliminarSeleccion(id);
    }
}