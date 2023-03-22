package com.digitalhouse.turnos.controller;

import com.digitalhouse.turnos.dao.impl.PacienteDaoH2;
import com.digitalhouse.turnos.model.Odontologo;
import com.digitalhouse.turnos.model.Paciente;
import com.digitalhouse.turnos.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    /*
    @GetMapping("/mostrarPaciente")
    public String mostrarPaciente(@RequestParam String nombre, @RequestParam String apellido, @RequestParam String dni, @RequestParam String fechaAlta) {
        return nombre + apellido + dni + fechaAlta ;
    }
*/
    @PostMapping("/registrar")
    public Paciente crearPaciente(@RequestBody Paciente paciente){
        return pacienteService.guardarPaciente(paciente);
    }

    @GetMapping("/{id}")
    public Paciente buscarPaciente(@PathVariable Long id){
        return pacienteService.buscarPaciente(id);
    }

}