package com.digitalhouse.turnos.service;

import com.digitalhouse.turnos.dao.IDao;
import com.digitalhouse.turnos.model.Odontologo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService {

    private IDao<Odontologo> odontologoIDao;

    public IDao<Odontologo> getOdontologoIDao() {
        return odontologoIDao;
    }

    public void setOdontologoIDao(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }


    public List listarOdontologo(){
        return odontologoIDao.listar();
    }

    public Odontologo guardarOdontologo(Odontologo o){
        return odontologoIDao.guardar(o);
    }

    public Odontologo buscarOdontologo(Long id){
        return odontologoIDao.buscar(id);
    }

    public void eliminarOdontologo(Long id){
        odontologoIDao.eliminar(id);
    }

    public Odontologo actualizarOdontologo(Odontologo o){
        return odontologoIDao.actualizar(o);
    }
}
