package com.digitalhouse.turnos.controller;

import com.digitalhouse.turnos.dto.PacienteDTO;
import com.digitalhouse.turnos.model.Paciente;
import com.digitalhouse.turnos.service.impl.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;


    @PostMapping("/registrar")      //Post es para crear nuevos datos.
    public ResponseEntity<?> guardarPaciente(@RequestBody PacienteDTO pacienteDTO){
        pacienteService.guardarPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public PacienteDTO buscarPaciente(@PathVariable Long id){
        return pacienteService.buscarPaciente(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Long id){
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/actualizar")      //PUT es para actualizar datos existentes.
    public ResponseEntity<?> actualizarPaciente(@RequestBody PacienteDTO pacienteDTO){
        pacienteService.actualizarPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/listar")
    public Set<PacienteDTO> listarPacientes(){
        return pacienteService.listarPacientes();
    }
}