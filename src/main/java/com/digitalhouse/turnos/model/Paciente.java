package com.digitalhouse.turnos.model;

import java.time.LocalDate;
import java.util.Date;

public class Paciente {

    private Long id;
    private String apellido;
    private String nombre;
    private int dni;
    private String fechaAlta;

    public Paciente() {
    }

    public Paciente(String apellido, String nombre, int dni, String fechaAlta) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.fechaAlta = fechaAlta;
    }

    public Paciente(Long id, String apellido, String nombre, int dni, String fechaAlta) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.fechaAlta = fechaAlta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }


    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", dni=" + dni +
                ", fechaAlta=" + fechaAlta +
                '}';
    }
}
