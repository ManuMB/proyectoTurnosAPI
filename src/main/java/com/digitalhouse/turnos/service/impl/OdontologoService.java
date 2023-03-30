package com.digitalhouse.turnos.service.impl;

import com.digitalhouse.turnos.dto.OdontologoDTO;
import com.digitalhouse.turnos.model.Odontologo;
import com.digitalhouse.turnos.repository.IDomicilioRepository;
import com.digitalhouse.turnos.repository.IOdontologoRepository;
import com.digitalhouse.turnos.service.IDomicilioService;
import com.digitalhouse.turnos.service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoService implements IOdontologoService {

    @Autowired
    private IOdontologoRepository iOdontologoRepository;

    @Autowired
    ObjectMapper objectMapper;


    @Override
    public void guardarOdontologo(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = objectMapper.convertValue(odontologoDTO, Odontologo.class);
        iOdontologoRepository.save(odontologo);
    }

    @Override
    public OdontologoDTO buscarOdontologo(Long id) {
        OdontologoDTO odontologoDTO = null;

        Optional<Odontologo> odontologoBusqueda = iOdontologoRepository.findById(id);
        if(odontologoBusqueda.isPresent())
            odontologoDTO = objectMapper.convertValue(odontologoBusqueda, OdontologoDTO.class);

        return odontologoDTO;
    }

    @Override
    public void eliminarOdontologo(Long id) {
        iOdontologoRepository.deleteById(id);
    }

    @Override
    public void actualizarOdontologo(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = objectMapper.convertValue(odontologoDTO, Odontologo.class);
        iOdontologoRepository.save(odontologo);
    }

    @Override
    public Set<OdontologoDTO> listarOdontologos() {
        List<Odontologo> listaOdontologo = iOdontologoRepository.findAll();
        Set<OdontologoDTO> listaDTO = new HashSet<>();

        for(Odontologo o : listaOdontologo)
            listaDTO.add(objectMapper.convertValue(o, OdontologoDTO.class));

        return listaDTO;
    }
}
