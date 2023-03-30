package com.digitalhouse.turnos.service;

import com.digitalhouse.turnos.dto.OdontologoDTO;
import com.digitalhouse.turnos.model.Odontologo;

import java.util.List;
import java.util.Set;

public interface IOdontologoService {

    void guardarOdontologo(OdontologoDTO odontologoDTO);
    OdontologoDTO buscarOdontologo(Long id);
    void eliminarOdontologo(Long id);
    void actualizarOdontologo(OdontologoDTO odontologoDTO);
    Set<OdontologoDTO> listarOdontologos();

}
