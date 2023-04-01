package com.digitalhouse.turnos.controller;

import com.digitalhouse.turnos.dto.TurnoDTO;
import com.digitalhouse.turnos.service.impl.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;


    @PostMapping("/registrar")
    public ResponseEntity<?> guardarTurno(@RequestBody TurnoDTO turnoDTO){
        turnoService.guardarTurno(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public TurnoDTO buscarTurno(@PathVariable Long id){
        return turnoService.buscarTurno(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTurno(@PathVariable Long id){
        turnoService.eliminarTurno(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizarTurno(@RequestBody TurnoDTO turnoDTO){
        turnoService.actualizarTurno(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/listar")
    public Set<TurnoDTO> listarTurnos(){
        return turnoService.listarTurnos();
    }
}
