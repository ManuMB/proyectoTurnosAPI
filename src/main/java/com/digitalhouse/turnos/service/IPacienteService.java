package com.digitalhouse.turnos.service;

import com.digitalhouse.turnos.dto.PacienteDTO;
import com.digitalhouse.turnos.model.Paciente;
import org.hibernate.mapping.Collection;
import java.util.Set;

import java.util.List;

public interface IPacienteService {

    void guardarPaciente(PacienteDTO pacienteDTO);
    PacienteDTO buscarPaciente(Long id);
    void eliminarPaciente(Long id);
    void actualizarPaciente(PacienteDTO pacienteDTO);
    Set<PacienteDTO> listarPacientes();

}
