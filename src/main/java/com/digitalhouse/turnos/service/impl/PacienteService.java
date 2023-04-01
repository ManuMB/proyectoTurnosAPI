package com.digitalhouse.turnos.service.impl;

import com.digitalhouse.turnos.dto.PacienteDTO;
import com.digitalhouse.turnos.model.Paciente;
import com.digitalhouse.turnos.repository.IPacienteRepository;
import com.digitalhouse.turnos.service.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;


import java.util.*;


@Service
public class PacienteService implements IPacienteService {

    private static final Logger logger = Logger.getLogger(PacienteService.class);


    @Autowired
    private IPacienteRepository iPacienteRepository;

/*
    public PacienteService(IPacienteRepository iPacienteRepository) {
        this.iPacienteRepository = iPacienteRepository;
    }

 */

    @Autowired
    ObjectMapper objectMapper;


    @Override
    public void guardarPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = objectMapper.convertValue(pacienteDTO,Paciente.class);
        iPacienteRepository.save(paciente);
    }

    @Override
    public PacienteDTO buscarPaciente(Long id) {
        PacienteDTO pacienteDTO = null;

        Optional<Paciente> pacienteBusqueda = iPacienteRepository.findById(id);
        if(pacienteBusqueda.isPresent())
            pacienteDTO = objectMapper.convertValue(pacienteBusqueda, PacienteDTO.class);

        return pacienteDTO;
    }

    @Override
    public void eliminarPaciente(Long id) {
        iPacienteRepository.deleteById(id);
    }

    @Override
    public void actualizarPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = objectMapper.convertValue(pacienteDTO,Paciente.class);
        iPacienteRepository.save(paciente);
    }

    @Override
    public Set<PacienteDTO> listarPacientes() {
        List<Paciente> listaPaciente = iPacienteRepository.findAll();
        Set<PacienteDTO> listaDTO = new HashSet<PacienteDTO>();         //Usamos HashSet en vez de arrayList porque no permite repetidos.

        for(Paciente p : listaPaciente)
            listaDTO.add(objectMapper.convertValue(p, PacienteDTO.class));

        return listaDTO;
    }
}
