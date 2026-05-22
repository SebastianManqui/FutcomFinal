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
    private int id_partido;
    
    @ManyToOne
    @JoinColumn(name = "local_id") 
    @NotNull
    private Seleccion seleccionLocal;

    @ManyToOne
    @JoinColumn(name = "visitante_id") 
    @NotNull
    private Seleccion seleccionVisitante;

    @ManyToOne
    @JoinColumn(name = "estadio_id") 
    @JsonIgnore
    @NotNull
    private Estadio estadio;
    
}