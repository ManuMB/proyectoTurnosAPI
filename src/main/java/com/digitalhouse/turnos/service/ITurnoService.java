package com.digitalhouse.turnos.service;

import com.digitalhouse.turnos.dto.TurnoDTO;
import com.digitalhouse.turnos.model.Turno;

import java.util.List;
import java.util.Set;

public interface ITurnoService{

    void guardarTurno(TurnoDTO turnoDTO);
    TurnoDTO buscarTurno(Long id);
    void eliminarTurno(Long id);
    void actualizarTurno(TurnoDTO turnoDTO);
    Set<TurnoDTO> listarTurnos();

}
