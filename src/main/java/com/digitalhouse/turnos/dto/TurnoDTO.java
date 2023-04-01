package com.digitalhouse.turnos.dto;

import com.digitalhouse.turnos.model.Odontologo;
import com.digitalhouse.turnos.model.Paciente;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@Getter
@Setter

@JsonIgnoreProperties(ignoreUnknown = true)
public class TurnoDTO {

    private Timestamp fechaHora;
    private Paciente paciente;
    private Odontologo odontologo;
}
