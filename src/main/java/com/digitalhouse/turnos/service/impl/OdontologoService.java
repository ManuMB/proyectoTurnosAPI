package com.digitalhouse.turnos.service.impl;

import com.digitalhouse.turnos.model.Odontologo;
import com.digitalhouse.turnos.repository.IOdontologoRepository;
import com.digitalhouse.turnos.service.IDomicilioService;
import com.digitalhouse.turnos.service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService implements IOdontologoService {

    @Autowired
    private IDomicilioService iDomicilioService;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public Odontologo guardarOdontologo(Odontologo odontologo) {
        return null;
    }

    @Override
    public Odontologo buscarOdontologo(Long id) {
        return null;
    }

    @Override
    public void eliminarOdontologo(Long id) {

    }

    @Override
    public Odontologo actualizarOdontologo(Odontologo odontologo) {
        return null;
    }

    @Override
    public List<Odontologo> listarOdontologos() {
        return null;
    }
}
