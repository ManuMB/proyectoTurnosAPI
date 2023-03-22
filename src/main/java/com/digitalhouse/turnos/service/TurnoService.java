package com.digitalhouse.turnos.service;

import com.digitalhouse.turnos.dao.IDao;
import com.digitalhouse.turnos.model.Turno;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService {

    private IDao<Turno> turnoIDao;

    public IDao<Turno> getTurnoIDao() {
        return turnoIDao;
    }

    public void setTurnoIDao(IDao<Turno> turnoIDao) {
        this.turnoIDao = turnoIDao;
    }


    public List listarTurnos(){
        return turnoIDao.listar();
    }

    public Turno guardarTurno(Turno t){
        return turnoIDao.guardar(t);
    }

    public Turno buscarTurno(Long id){
        return turnoIDao.buscar(id);
    }

    public void eliminarTurno(Long id){
        turnoIDao.eliminar(id);
    }

    public Turno actualizarPaciente(Turno t){
        return turnoIDao.actualizar(t);
    }
}
