package com.digitalhouse.turnos.service;

import com.digitalhouse.turnos.model.Paciente;

import java.util.List;

public interface IPacienteService {

    Paciente guardarPaciente(Paciente paciente);
    Paciente buscarPaciente(Long id);
    void eliminarPaciente(Long id);
    Paciente actualizarPaciente(Paciente paciente);
    List<Paciente> listarPacientes();

}
