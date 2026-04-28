package com.duoc.futcom.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "grupos")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String grupo;   

    @NotBlank
    private String Seleccion ;
    
    @NotBlank
    private String Seleccion2 ;

    @NotBlank
    private String Seleccion3;

    @NotBlank
    private String Seleccion4;

   
    @OneToMany(mappedBy = "grupo")
    private List<Seleccion> selecciones;
}