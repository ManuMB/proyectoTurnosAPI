package com.digitalhouse.turnos.service;

import com.digitalhouse.turnos.model.Odontologo;

import java.util.List;

public interface IOdontologoService {

    Odontologo guardarOdontologo(Odontologo odontologo);
    Odontologo buscarOdontologo(Long id);
    void eliminarOdontologo(Long id);
    Odontologo actualizarOdontologo(Odontologo odontologo);
    List<Odontologo> listarOdontologos();

}
