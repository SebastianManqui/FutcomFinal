package com.duoc.futcom.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor 
@NoArgsConstructor

public class GrupoDto {
    private Integer id;
    @NotBlank
    private String grupo; 

    
    private List<String> nombresSelecciones;
}
