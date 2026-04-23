package com.duoc.futcom.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "estadios")
public class Estadio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_estadio;

    @NotBlank
    private String nombre;

    @NotBlank
    private String ciudad;

    @NotNull
    private Integer capacidad;
    
    @NotBlank
    private String fotoEscudo; 
   

    @OneToMany(mappedBy = "estadio")
    private List<Partido> partidos;
}