package com.duoc.futcom.controller;
import com.duoc.futcom.model.Grupo;
import com.duoc.futcom.service.GrupoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController 
@RequestMapping("/api/v1/grupos") 
public class GrupoController {

    @Autowired
    private GrupoService grupoService;

    @GetMapping
    public List<Grupo> listar() {
        return grupoService.listarTodo();
    }
    @PostMapping
    public ResponseEntity<Grupo> crearGrupo(@RequestBody Grupo grupo) {
        System.out.println("DEBUG: [GrupoController] -> Creando un nuevo grupo");
        grupoService.guardar(grupo);
        return new ResponseEntity<>(grupo, HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
    System.out.println("DEBUG: Iniciando proceso de eliminación para el Grupo ID: " + id);
    grupoService.eliminar(id);
    System.out.println("DEBUG: Grupo eliminado correctamente.");
}
    @GetMapping("/{id}")
    public Grupo buscar(@PathVariable Integer id) {
        System.out.println("DEBUG: Buscando info del Grupo ID: " + id);
        return grupoService.buscarPorId(id); 
}
    //revisar
    @PutMapping("/{id}")
    public ResponseEntity<Grupo> actualizar(@PathVariable Integer id, @Valid @RequestBody Grupo grupoDetalles) {
        System.out.println("DEBUG: [GrupoController] -> Intentando actualizar Grupo ID: " + id);
        
        Grupo grupoExistente = grupoService.buscarPorId(id);
        if (grupoExistente == null) {
            return ResponseEntity.notFound().build(); 
        }
       
        grupoExistente.setGrupo(grupoDetalles.getGrupo());
        grupoService.guardar(grupoExistente);
                return ResponseEntity.ok(grupoExistente);
    }
}
   