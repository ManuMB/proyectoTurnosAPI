package com.digitalhouse.turnos.service;

import com.digitalhouse.turnos.dao.IDao;
import com.digitalhouse.turnos.model.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private IDao<Paciente> pacienteIDao;

    public PacienteService(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }


    public IDao<Paciente> getPacienteIDao() {
        return pacienteIDao;
    }

    public void setPacienteIDao(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }


    public List listarPaciente(){
        return pacienteIDao.listar();
    }

    public Paciente guardarPaciente(Paciente p){
        return pacienteIDao.guardar(p);
    }

    public Paciente buscarPaciente(Long id){
        return pacienteIDao.buscar(id);
    }

    public void eliminarPaciente(Long id){
        pacienteIDao.eliminar(id);
    }

    public Paciente actualizarPaciente(Paciente p){
        return pacienteIDao.actualizar(p);
    }
}
