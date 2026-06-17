package com.duoc.futcom.controller;
import com.duoc.futcom.dto.SeleccionDto;
import com.duoc.futcom.model.Seleccion;
import com.duoc.futcom.service.SeleccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/api/v1/selecciones") 
public class SeleccionController {

    @Autowired
    private SeleccionService seleccionService;

    @GetMapping 
    public List<SeleccionDto> listarSeleccionDtos() {
        System.out.println("DEBUG: Listando todas las selecciones (vía DTO)");
        List<Seleccion> listaEntidades = seleccionService.listarTodas();

        return listaEntidades.stream().map(s -> {
            SeleccionDto dto = new SeleccionDto();
            dto.setId(s.getId());
            dto.setNombre(s.getNombre());
            dto.setConfederacion(s.getConfederacion());
            if (s.getGrupo() != null) {
                dto.setIdGrupo(s.getGrupo().getId());
                dto.setNombreGrupo(s.getGrupo().getGrupo()); 
            }
            return dto;
        }).collect(Collectors.toList());
    }
        

   
    @GetMapping("/{id}")
    public ResponseEntity<Seleccion> buscar(@PathVariable Integer id) {
        System.out.println("DEBUG: [SeleccionController] -> Buscando selección con ID: " + id);
        Seleccion seleccion = seleccionService.buscarSeleccionPorId(id);
        if (seleccion == null) {
            return ResponseEntity.notFound().build(); 
        }
        
        return ResponseEntity.ok(seleccion);
    }

    @PostMapping
    public void crear(@RequestBody Seleccion seleccion) {
        System.out.println("DEBUG: Guardando nueva seleccion: " + seleccion.getNombre());
        seleccionService.guardaSeleccion(seleccion);
    }

    //@DeleteMapping("/{id}")
    //public void eliminar(@PathVariable int id) {
      //  System.out.println("DEBUG: Eliminando seleccion ID: " + id);
     //   seleccionService.eliminarSeleccion(id);
    //}


    @PutMapping("/{id}")
    public ResponseEntity<Seleccion> actualizar(@PathVariable Integer id, @RequestBody Seleccion seleccionDetalles) {
        System.out.println("DEBUG: [SeleccionController] -> Intentando actualizar selección con ID: " + id);
        
        Seleccion seleccionExistente = seleccionService.buscarSeleccionPorId(id);
        if (seleccionExistente == null) {
            return ResponseEntity.notFound().build();
        }

        seleccionExistente.setNombre(seleccionDetalles.getNombre());
        seleccionExistente.setRankingFifa(seleccionDetalles.getRankingFifa());
        seleccionExistente.setConfederacion(seleccionDetalles.getConfederacion());
        seleccionExistente.setCodigoIso(seleccionDetalles.getCodigoIso());
        seleccionExistente.setDirectorTecnico(seleccionDetalles.getDirectorTecnico());
        seleccionExistente.setTitulosMundiales(seleccionDetalles.getTitulosMundiales());
        seleccionExistente.setGrupo(seleccionDetalles.getGrupo());
        seleccionService.guardaSeleccion(seleccionExistente);
        return ResponseEntity.ok(seleccionExistente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar2(@PathVariable int id) {
         System.out.println("DEBUG: Eliminando seleccion ID: " + id);
          Seleccion seleccionExistente = seleccionService.buscarSeleccionPorId(id);
          if (seleccionExistente == null) {
             return ResponseEntity.notFound().build(); 
        }
        seleccionService.eliminarSeleccion(id);
        return ResponseEntity.noContent().build(); 
    }
}
