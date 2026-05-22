package com.duoc.futcom.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;


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

    @OneToMany(mappedBy = "grupo")
    @JsonManagedReference
    private List<Seleccion> selecciones;
}