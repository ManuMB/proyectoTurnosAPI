package com.digitalhouse.turnos.controller;

import com.digitalhouse.turnos.dto.OdontologoDTO;
import com.digitalhouse.turnos.service.impl.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    private OdontologoService odontologoService;


    @PostMapping("/registrar")
    public ResponseEntity<?> guardarOdontologo(@RequestBody OdontologoDTO odontologoDTO){
        odontologoService.guardarOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public OdontologoDTO buscarOdontologo(@PathVariable Long id){
        return odontologoService.buscarOdontologo(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable Long id){
        odontologoService.eliminarOdontologo(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizarOdontologo(@RequestBody OdontologoDTO odontologoDTO){
        odontologoService.actualizarOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/listar")
    public Set<OdontologoDTO> listarOdontologos(){
        return odontologoService.listarOdontologos();
    }
}
