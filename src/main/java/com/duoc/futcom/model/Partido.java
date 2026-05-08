package com.duoc.futcom.model;
import lombok.Data; 
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data 
@Entity
@Table(name = "partido")
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_partido")
    private int id_partido;
    
    @NotBlank
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "estadio_id") 
    private Estadio estadio;
    
}