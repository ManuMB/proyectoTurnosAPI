package com.digitalhouse.turnos.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table
public class Turno {

    @Id
    @SequenceGenerator(name = "turno_sequence", sequenceName = "turno_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turno_sequence")
    private Long id;
    private Odontologo odontologo;      //Sería string o odontologo???
    private Date fecha;
    private Time hora;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)       //Varios turnos pertenecen a un solo paciente
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    public Turno() {
    }

    public Turno(Odontologo odontologo, Date fecha, Time hora) {
        this.odontologo = odontologo;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Turno(Long id, Odontologo odontologo, Date fecha, Time hora) {
        this.id = id;
        this.odontologo = odontologo;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


    @Override
    public String toString() {
        return "Turno{" +
                "id=" + id +
                ", odontologo=" + odontologo +
                ", fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                '}';
    }
}
