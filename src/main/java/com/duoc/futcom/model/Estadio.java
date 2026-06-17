package com.duoc.futcom.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "estadios")
public class Estadio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_estadio;

    @NotBlank
    private String nombre;

    @NotBlank
    private String ciudad;

    @NotNull
    private Integer capacidad;
    
   

    @OneToMany(mappedBy = "estadio")
    @JsonIgnore
    private List<Partido> partidos;
}