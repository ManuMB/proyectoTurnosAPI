package com.digitalhouse.turnos.service;

import com.digitalhouse.turnos.dao.IDao;
import com.digitalhouse.turnos.model.Domicilio;
import com.digitalhouse.turnos.model.Paciente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomicilioService {

    private IDao<Domicilio> domicilioIDao;

    public IDao<Domicilio> getDomicilioIDao() {
        return domicilioIDao;
    }

    public DomicilioService(IDao<Domicilio> domicilioIDao) {
        this.domicilioIDao = domicilioIDao;
    }


    public List listarDomicilios(){
        return domicilioIDao.listar();
    }

    public Domicilio guardarDomicilio(Domicilio d){
        return domicilioIDao.guardar(d);
    }

    public Domicilio buscarPaciente(Long id){
        return domicilioIDao.buscar(id);
    }

    public void eliminarPaciente(Long id){
        domicilioIDao.eliminar(id);
    }

    public Domicilio actualizarPaciente(Domicilio d){
        return domicilioIDao.actualizar(d);
    }
}
