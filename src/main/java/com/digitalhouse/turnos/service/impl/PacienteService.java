package com.digitalhouse.turnos.service.impl;

import com.digitalhouse.turnos.model.Paciente;
import com.digitalhouse.turnos.repository.IPacienteRepository;
import com.digitalhouse.turnos.service.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService implements IPacienteService {

    @Autowired
    private IPacienteRepository iPacienteRepository;

    @Autowired
    ObjectMapper objectMapper;


    @Override
    public Paciente guardarPaciente(Paciente paciente) {
        return null;
    }

    @Override
    public Paciente buscarPaciente(Long id) {
        return null;
    }

    @Override
    public void eliminarPaciente(Long id) {

    }

    @Override
    public Paciente actualizarPaciente(Paciente paciente) {
        return null;
    }

    @Override
    public List<Paciente> listarPacientes() {
        return null;
    }
}
