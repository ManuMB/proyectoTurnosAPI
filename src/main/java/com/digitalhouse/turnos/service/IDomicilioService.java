package com.digitalhouse.turnos.service;

import com.digitalhouse.turnos.model.Domicilio;

import java.util.List;

public interface IDomicilioService {

    Domicilio guardarDomicilio(Domicilio domicilio);
    Domicilio buscarDomicilio(Long id);
    void eliminarDomicilio(Long id);
    Domicilio actualizarDomicilio(Domicilio domicilio);
    List<Domicilio> listarDomicilios();

}
