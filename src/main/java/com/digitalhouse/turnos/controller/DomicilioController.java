package com.digitalhouse.turnos.controller;

import com.digitalhouse.turnos.dto.DomicilioDTO;
import com.digitalhouse.turnos.service.impl.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/domicilios")
public class DomicilioController {

    @Autowired
    private DomicilioService domicilioService;

    @PostMapping("/registrar")
    public ResponseEntity<?> guardarDomicilio(@RequestBody DomicilioDTO domicilioDTO){
        domicilioService.guardarDomicilio(domicilioDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public DomicilioDTO buscarDomicilio(@PathVariable Long id){
        return domicilioService.buscarDomicilio(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarDomicilio(@PathVariable Long id){
        domicilioService.eliminarDomicilio(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizarDomicilio(@RequestBody DomicilioDTO domicilioDTO){
        domicilioService.actualizarDomicilio(domicilioDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/listar")
    public Set<DomicilioDTO> listarDomicilio(){
        return domicilioService.listarDomicilios();
    }
}
