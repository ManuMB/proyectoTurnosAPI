package com.digitalhouse.turnos.service.impl;

import com.digitalhouse.turnos.dto.DomicilioDTO;
import com.digitalhouse.turnos.model.Domicilio;
import com.digitalhouse.turnos.repository.IDomicilioRepository;
import com.digitalhouse.turnos.service.IDomicilioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DomicilioService implements IDomicilioService{

    @Autowired
    private IDomicilioRepository iDomicilioRepository;

    @Autowired
    ObjectMapper objectMapper;


    @Override
    public void guardarDomicilio(DomicilioDTO domicilioDTO) {
        Domicilio domicilio = objectMapper.convertValue(domicilioDTO, Domicilio.class);
        iDomicilioRepository.save(domicilio);
    }

    @Override
    public DomicilioDTO buscarDomicilio(Long id) {
        DomicilioDTO domicilioDTO = null;

        Optional<Domicilio> domicilioBusqueda = iDomicilioRepository.findById(id);
        if(domicilioBusqueda.isPresent())
            domicilioDTO = objectMapper.convertValue(domicilioBusqueda, DomicilioDTO.class);

        return domicilioDTO;
    }

    @Override
    public void eliminarDomicilio(Long id) {
        iDomicilioRepository.deleteById(id);
    }

    @Override
    public void actualizarDomicilio(DomicilioDTO domicilioDTO) {
        Domicilio domicilio = objectMapper.convertValue(domicilioDTO, Domicilio.class);
        iDomicilioRepository.save(domicilio);
    }

    @Override
    public Set<DomicilioDTO> listarDomicilios() {
        List<Domicilio> listaDomicilio = iDomicilioRepository.findAll();
        Set<DomicilioDTO> listaDTO = new HashSet<>();

        for(Domicilio d : listaDomicilio)
            listaDTO.add(objectMapper.convertValue(d, DomicilioDTO.class));

        return listaDTO;
    }
}
