package com.digitalhouse.turnos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "Pacientes")
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
    @JsonIgnore
    private Set<Domicilio> domicilios = new HashSet<>();

    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)       //Un paciente puede tener varios turnos.
    @JsonIgnore
    private Set<Turno> turnos = new HashSet<>();
}
