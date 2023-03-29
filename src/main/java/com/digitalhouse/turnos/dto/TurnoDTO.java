package com.digitalhouse.turnos.dto;

import com.digitalhouse.turnos.model.Odontologo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@AllArgsConstructor
@Getter
@Setter

@JsonIgnoreProperties(ignoreUnknown = true)
public class TurnoDTO {

    private Odontologo odontologo;
    private Date fecha;
    private Time hora;
}
