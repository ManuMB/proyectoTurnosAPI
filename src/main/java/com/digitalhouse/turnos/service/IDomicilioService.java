package com.digitalhouse.turnos.service;

import com.digitalhouse.turnos.dto.DomicilioDTO;
import com.digitalhouse.turnos.model.Domicilio;

import java.util.List;
import java.util.Set;

public interface IDomicilioService {

    void guardarDomicilio(DomicilioDTO domicilioDTO);
    DomicilioDTO buscarDomicilio(Long id);
    void eliminarDomicilio(Long id);
    void actualizarDomicilio(DomicilioDTO domicilioDTO);
    Set<DomicilioDTO> listarDomicilios();

}
