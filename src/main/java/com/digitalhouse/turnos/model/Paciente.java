package com.digitalhouse.turnos.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Paciente {

    @Id
    @SequenceGenerator(name = "paciente_sequence", sequenceName = "paciente_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente_sequence")
    private Long id;
    private String apellido;
    private String nombre;
    private int dni;
    private Date fechaAlta;

    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)       //Un paciente puede tener varios domicilios.
    private Set<Domicilio> domicilios = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)       //Varios odontologos pertenecen a un solo paciente
    @JoinColumn(name = "odontologo_id")
    private Odontologo odontologo;

    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)       //Un paciente puede tener varios turnos.
    private Set<Domicilio> turnos = new HashSet<>();

    public Paciente() {
    }

    public Paciente(String apellido, String nombre, int dni, Date fechaAlta) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.fechaAlta = fechaAlta;
    }

    public Paciente(Long id, String apellido, String nombre, int dni, Date fechaAlta) {
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

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
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
