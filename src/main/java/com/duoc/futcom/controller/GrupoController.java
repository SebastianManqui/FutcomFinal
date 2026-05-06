package com.duoc.futcom.controller;
import com.duoc.futcom.model.Grupo;
import com.duoc.futcom.service.GrupoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/grupos")
public class GrupoController {

    @Autowired
    private GrupoService grupoService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("listaGrupos", grupoService.listarTodo());
        return "grupos/lista"; 
    }


    @GetMapping("/nuevo")
    public String formulario(Model model) {
        model.addAttribute("grupo", new Grupo());
        return "grupos/formulario";
    }


    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute("grupo") Grupo grupo, 
     BindingResult result) {
        if (result.hasErrors()) {
            return "grupos/formulario";
        }
        grupoService.guardar(grupo);
        return "redirect:/grupos";
    }

    
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer id) {
        grupoService.eliminar(id);
        return "redirect:/grupos";
    }
}