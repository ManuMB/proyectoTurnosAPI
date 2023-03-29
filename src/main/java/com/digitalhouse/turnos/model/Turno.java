package com.digitalhouse.turnos.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "Turnos")
public class Turno {

    @Id
    @SequenceGenerator(name = "turno_sequence", sequenceName = "turno_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turno_sequence")
    private Long id;
    private Timestamp fechaHora;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)       //Varios turnos pertenecen a un solo paciente
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)       //Varios turnos pertenecen a un solo odontologo
    @JoinColumn(name = "odontologo_id")
    private Odontologo odontologo;
}
