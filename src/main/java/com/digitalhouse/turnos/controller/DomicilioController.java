package com.digitalhouse.turnos.controller;

import com.digitalhouse.turnos.service.impl.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/domicilio")
public class DomicilioController {

    @Autowired
    private DomicilioService domicilioService;

    @GetMapping("/domicilio/{dom}")
    public String mostrarDomicilio(@PathVariable String dom) {
        return dom;
    }
}
