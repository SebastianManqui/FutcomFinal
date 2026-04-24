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
    private Long id;

    @NotBlank
    private String nombre;
    
    @NotBlank
    private String nombre2;

    @NotBlank
    private String nombre3;

    @NotBlank
    private String nombre4;

   
    @OneToMany(mappedBy = "grupo")
    private List<Seleccion> selecciones;
}