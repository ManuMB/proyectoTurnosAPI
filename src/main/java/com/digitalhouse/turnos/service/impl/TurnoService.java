package com.digitalhouse.turnos.service.impl;

import com.digitalhouse.turnos.model.Turno;
import com.digitalhouse.turnos.repository.ITurnoRepository;
import com.digitalhouse.turnos.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService implements ITurnoService {

    @Autowired
    private ITurnoRepository iTurnoRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public Turno guardarTurno(Turno turno) {
        return null;
    }

    @Override
    public Turno buscarTurno(Long id) {
        return null;
    }

    @Override
    public void eliminarTurno(Long id) {

    }

    @Override
    public Turno actualizarTurno(Turno turno) {
        return null;
    }

    @Override
    public List<Turno> listarTurnos() {
        return null;
    }
}
