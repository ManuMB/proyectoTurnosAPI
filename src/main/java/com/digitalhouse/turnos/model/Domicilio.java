package com.digitalhouse.turnos.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "Domicilios")
public class Domicilio {

    @Id
    @SequenceGenerator(name = "domicilio_sequence", sequenceName = "domicilio_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "domicilio_sequence")
    private Long id;
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)       //Varios domicilios pertenecen a un solo paciente
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
}
