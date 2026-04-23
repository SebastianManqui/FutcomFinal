package com.duoc.futcom.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@Entity
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_partido;
    
    @NotBlank
    private String nombre;

     @ManyToOne
    @JoinColumn(name = "estadio_id") 
    private Estadio estadio;
  
}