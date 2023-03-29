package com.digitalhouse.turnos.service.impl;

import com.digitalhouse.turnos.model.Domicilio;
import com.digitalhouse.turnos.repository.IDomicilioRepository;
import com.digitalhouse.turnos.service.IDomicilioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomicilioService implements IDomicilioService{

    @Autowired
    private IDomicilioRepository iDomicilioRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public Domicilio guardarDomicilio(Domicilio domicilio) {
        return null;
    }

    @Override
    public Domicilio buscarDomicilio(Long id) {
        return null;
    }

    @Override
    public void eliminarDomicilio(Long id) {

    }

    @Override
    public Domicilio actualizarDomicilio(Domicilio domicilio) {
        return null;
    }

    @Override
    public List<Domicilio> listarDomicilios() {
        return null;
    }
}
