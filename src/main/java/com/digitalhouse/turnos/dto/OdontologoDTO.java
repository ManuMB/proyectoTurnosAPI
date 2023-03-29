package com.digitalhouse.turnos.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter

@JsonIgnoreProperties(ignoreUnknown = true)
public class OdontologoDTO {

    private String apellido;
    private String nombre;
    private int matricula;
}