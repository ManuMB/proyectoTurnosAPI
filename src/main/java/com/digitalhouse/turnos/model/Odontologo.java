package com.digitalhouse.turnos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "Odontologos")
public class Odontologo {

    @Id
    @SequenceGenerator(name = "odontologo_sequence", sequenceName = "odontologo_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "odontologo_sequence")
    private Long id;
    private String apellido;
    private String nombre;
    private int matricula;

    @OneToMany(mappedBy = "odontologo", fetch = FetchType.LAZY)     //Un odontologo puede tener varios pacientes. Lazy es que va cargando a medida que vas pidiendo en vez de cargar todos de una.
    @JsonIgnore
    private Set<Paciente> pacientes = new HashSet<>();

    @OneToMany(mappedBy = "odontologo", fetch = FetchType.LAZY)       //Un odontologo puede tener varios turnos.
    @JsonIgnore
    private Set<Turno> turnos = new HashSet<>();
}
