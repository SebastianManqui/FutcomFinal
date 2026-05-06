package com.duoc.futcom.controller;
import com.duoc.futcom.model.Estadio;
import com.duoc.futcom.service.EstadioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/estadios")
public class EstadioController {

    @Autowired
    private EstadioService estadioService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("estadios", estadioService.listarTodos());
        return "estadios/lista";
    }

    
    @GetMapping("/nuevo")
    public String formulario(Model model) {
        model.addAttribute("estadio", new Estadio());
        return "estadios/formulario";
    }

   
    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute("estadio") Estadio estadio, 
                          BindingResult result) {
        if (result.hasErrors()) {
            return "estadios/formulario";
        }
        estadioService.guardar(estadio);
        return "redirect:/estadios";
    }


    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Integer id, Model model) {
        Estadio estadio = estadioService.buscarEstadioPorId(id);
        model.addAttribute("estadio", estadio);
        return "estadios/formulario";
    }


    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer id) {
        estadioService.eliminar(id);
        return "redirect:/estadios";
    }
}