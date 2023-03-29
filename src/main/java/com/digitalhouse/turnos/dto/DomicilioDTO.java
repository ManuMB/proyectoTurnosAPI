package com.digitalhouse.turnos.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

@JsonIgnoreProperties(ignoreUnknown = true)
public class DomicilioDTO {

    private String calle;
    private String numero;
    private String localidad;
    private String provincia;
}
