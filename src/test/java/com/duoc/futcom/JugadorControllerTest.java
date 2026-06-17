package com.duoc.futcom;
import com.duoc.futcom.model.Jugador;
import com.duoc.futcom.model.Seleccion;
import com.duoc.futcom.service.JugadorService;
import com.duoc.futcom.controller.JugadorController;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class JugadorControllerTest {

    @Mock
    private JugadorService jugadorService;

    @InjectMocks
    private JugadorController jugadorController;

    @Test
    void crearJugador_retorna201_cuandoJugadorEsValido() {

        // Vamos a verificar que el método crear del controlador funciona correctamente.
        // Para ello crearemos un jugador válido y simularemos el comportamiento del servicio.

        Seleccion seleccion = new Seleccion();

        Jugador jugador = new Jugador(1,"Lionel Messi",37,850,380,"Argentina","Inter Miami",10,1100,seleccion);

        // ""Simulamos"" el comportamiento del servicio (mock):
        // Así evitamos acceder a base de datos en una prueba unitaria.
        // Cuando el servicio intente guardar el libro, le decimos que devuelva el mismo libro (como si lo hubiera guardado).
        // Cuando el controlador invoque saveLibro con ese libro, Mockito devolverá ese mismo libro al instante, sin ejecutar lógica real, sin repositorio, sin DB

        when(jugadorService.guardar(jugador)).thenReturn(jugador);

        // Llamamos al método del controlador que queremos probar.
        // El resultado es un ResponseEntity<Libro> con estado HTTP y cuerpo.

        var respuesta = jugadorController.crear(jugador);
        // Para que el test sea completo, verificamos varios aspectos de la respuesta:

        // 1) La respuesta no debe ser nula.
        assertNotNull(respuesta);

        // 2) El estado HTTP esperado al crear un recurso es 201 (CREATED).
        assertEquals(HttpStatus.CREATED, respuesta.getStatusCode());

        // 3) El cuerpo de la respuesta debe existir.
        var body = respuesta.getBody();
        assertNotNull(body);

        // 4) Validamos un dato clave del cuerpo para confirmar
        // que se devolvió el jugador correcto.
        assertEquals("Lionel Messi", body.getNombre());
    }
    
    @Test
    void buscarPorId_retorna200_cuandoJugadorExiste() {
        // // Arrange (Preparar los datos)
        Integer idBuscado = 1;
        Seleccion seleccion = new Seleccion();
        Jugador jugadorExistente = new Jugador(idBuscado,"Lionel Messi", 37,850, 380,"Argentina","Inter Miami", 10, 160, seleccion
        );

       
        when(jugadorService.buscarPorId(idBuscado)).thenReturn(jugadorExistente);

        
        Jugador respuesta = jugadorController.buscarPorId(idBuscado);

        
        assertNotNull(respuesta);
        assertEquals(idBuscado, respuesta.getIdJugador());
        assertEquals("Lionel Messi", respuesta.getNombre());
    }
    @Test
    void actualizarJugador_retorna200_cuandoJugadorExiste() {
        Integer idActualizar = 1;
        Seleccion seleccion = new Seleccion();
        
        
        Jugador jugadorEnBD = new Jugador(idActualizar, "Alexis Sánchez", 35, 51, 40, "Chileno", "Inter", 10, 160, seleccion);
        
       
        Jugador datosNuevos = new Jugador(idActualizar, "Alexis Sánchez", 37, 52, 41, "Chileno", "Udinese", 10, 165, seleccion);

        
        when(jugadorService.buscarPorId(idActualizar)).thenReturn(jugadorEnBD);
        when(jugadorService.guardar(jugadorEnBD)).thenReturn(datosNuevos);

    
        ResponseEntity<Jugador> respuesta = jugadorController.actualizar(idActualizar, datosNuevos);

       
        assertNotNull(respuesta);
        assertEquals(HttpStatus.OK, respuesta.getStatusCode()); 
        assertNotNull(respuesta.getBody());
        assertEquals("Udinese", respuesta.getBody().getClubActual()); 
        assertEquals(37, respuesta.getBody().getEdad()); 
    }

    @Test
    void listar_retornaListaDeJugadores_cuandoExistenJugadores() {
        // // Arrange (Preparar los datos)
        Integer idBuscado = 1;
        Seleccion seleccion = new Seleccion();
        
        
        Jugador jugador1 = new Jugador(idBuscado, "Lionel Messi", 37, 850, 380, "Argentina", "Inter Miami", 10, 160, seleccion);
        
       
        List<Jugador> listaSimulada = new ArrayList<>();
        listaSimulada.add(jugador1);

        when(jugadorService.listarTodos()).thenReturn(listaSimulada);

       
        List<Jugador> respuesta = jugadorController.listar();

       
        assertNotNull(respuesta);
        assertEquals(1, respuesta.size()); 
        assertEquals("Lionel Messi", respuesta.get(0).getNombre()); 
    }
}