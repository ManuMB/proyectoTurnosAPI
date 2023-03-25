package com.digitalhouse.turnos.dto;

import com.digitalhouse.turnos.model.Odontologo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Date;
import java.sql.Time;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TurnoDTO {

    private Odontologo odontologo;
    private Date fecha;
    private Time hora;

    public TurnoDTO(Odontologo odontologo, Date fecha, Time hora) {
        this.odontologo = odontologo;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }
}
