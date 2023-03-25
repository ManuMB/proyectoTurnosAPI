package com.digitalhouse.turnos.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Odontologo {

    @Id
    @SequenceGenerator(name = "odontologo_sequence", sequenceName = "odontologo_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "odontologo_sequence")
    private Long id;
    private String apellido;
    private String nombre;
    private int matricula;

    @OneToMany(mappedBy = "odontologo", fetch = FetchType.LAZY)     //Un odontologo puede tener varios pacientes. Lazy es que va cargando a medida que vas pidiendo en vez de cargar todos de una.
    private Set<Domicilio> pacientes = new HashSet<>();

    public Odontologo() {
    }

    public Odontologo(String apellido, String nombre, int matricula) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.matricula = matricula;
    }

    public Odontologo(Long id, String apellido, String nombre, int matricula) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.matricula = matricula;
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

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }


    @Override
    public String toString() {
        return "Odontologo{" +
                "id=" + id +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", matricula=" + matricula +
                '}';
    }
}
