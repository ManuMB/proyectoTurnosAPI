package com.digitalhouse.turnos.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@AllArgsConstructor
@Getter
@Setter

@JsonIgnoreProperties(ignoreUnknown = true)
public class PacienteDTO {

    private String apellido;
    private String nombre;
    private int dni;
    private Date fechaAlta;
}
