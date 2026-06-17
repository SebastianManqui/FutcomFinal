package com.duoc.futcom.model;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data 
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "partido")
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_partido")
    private Integer id_partido;
    
    @ManyToOne 
    @JoinColumn(name = "local_id") 
    @NotNull
    private Seleccion local;

    @ManyToOne 
    @JoinColumn(name = "visitante_id") 
    @NotNull
    private Seleccion visitante;

    @ManyToOne 
    @JoinColumn(name = "estadio_id") 

    @NotNull
    private Estadio estadio;
}