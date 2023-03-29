package com.digitalhouse.turnos.controller;

import com.digitalhouse.turnos.service.impl.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/odontologo")
public class OdontologoController {

    @Autowired
    private OdontologoService odontologoService;

    @GetMapping("/nombreOdontologo/{nombre}")
    public String mostrarOdontologo(@PathVariable String nombre) {
        return nombre;
    }
}
