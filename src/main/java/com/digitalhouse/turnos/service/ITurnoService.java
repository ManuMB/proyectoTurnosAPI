package com.digitalhouse.turnos.service;

import com.digitalhouse.turnos.model.Turno;

import java.util.List;

public interface ITurnoService{

    Turno guardarTurno(Turno turno);
    Turno buscarTurno(Long id);
    void eliminarTurno(Long id);
    Turno actualizarTurno(Turno turno);
    List<Turno> listarTurnos();

}
