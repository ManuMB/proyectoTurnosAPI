package com.digitalhouse.turnos.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PacienteDTO {

    private String apellido;
    private String nombre;
    private int dni;
    private Date fechaAlta;

    public PacienteDTO(String apellido, String nombre, int dni, Date fechaAlta) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.fechaAlta = fechaAlta;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
}
