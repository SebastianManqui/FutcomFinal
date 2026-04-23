package com.duoc.futcom.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jugadores")
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idJugador; 

    @NotBlank
    private String nombre;

    @NotNull
    private int edad;

    @NotNull
    private int goles;

    @NotNull   
    private int asistencias;

    @NotBlank
    private String nacionalidad;

    @NotBlank
    private String clubActual; 
    
    @NotNull
    private int numero;

    @NotNull
    private int partidos_jugados;

}