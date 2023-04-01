package com.digitalhouse.turnos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)       //Varios turnos pertenecen a un solo paciente
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)       //Varios turnos pertenecen a un solo odontologo
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "odontologo_id")
    private Odontologo odontologo;
}
