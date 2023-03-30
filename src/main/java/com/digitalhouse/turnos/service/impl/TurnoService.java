package com.digitalhouse.turnos.service.impl;

import com.digitalhouse.turnos.dto.TurnoDTO;
import com.digitalhouse.turnos.model.Turno;
import com.digitalhouse.turnos.repository.ITurnoRepository;
import com.digitalhouse.turnos.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.cert.TrustAnchor;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TurnoService implements ITurnoService {

    @Autowired
    private ITurnoRepository iTurnoRepository;

    @Autowired
    ObjectMapper objectMapper;


    @Override
    public void guardarTurno(TurnoDTO turnoDTO) {
        Turno turno = objectMapper.convertValue(turnoDTO, Turno.class);
        iTurnoRepository.save(turno);
    }

    @Override
    public TurnoDTO buscarTurno(Long id) {
        TurnoDTO turnoDTO = null;

        Optional<Turno> turnoBusqueda = iTurnoRepository.findById(id);
        if(turnoBusqueda.isPresent())
            turnoDTO = objectMapper.convertValue(turnoBusqueda, TurnoDTO.class);

        return turnoDTO;
    }

    @Override
    public void eliminarTurno(Long id) {
        iTurnoRepository.deleteById(id);
    }

    @Override
    public void actualizarTurno(TurnoDTO turnoDTO) {
        Turno turno = objectMapper.convertValue(turnoDTO, Turno.class);
        iTurnoRepository.save(turno);
    }

    @Override
    public Set<TurnoDTO> listarTurnos() {
        List<Turno> listaTurno = iTurnoRepository.findAll();
        Set<TurnoDTO> listaDTO = new HashSet<>();

        for (Turno t : listaTurno)
            listaDTO.add(objectMapper.convertValue(t, TurnoDTO.class));

        return listaDTO;
    }
}
