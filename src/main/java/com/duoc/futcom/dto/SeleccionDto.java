package com.duoc.futcom.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeleccionDto{
    private String nombre;
    private String Confederacion;
    private Integer id;
    private int idGrupo;
    private String nombreGrupo;

}
