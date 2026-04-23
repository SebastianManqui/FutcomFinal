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
@Table(name = "selecciones")

public class Seleccion { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String nombre;

    @NotNull
    private Integer rankingFifa; 

    @NotBlank
    private String confederacion;

    @NotNull
    private String codigoIso;

    @NotNull
    private String directorTecnico;

    @NotNull
    private Integer titulosMundiales;

    @NotNull
    private String escudoUrl;


    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private Grupo grupo; 
}