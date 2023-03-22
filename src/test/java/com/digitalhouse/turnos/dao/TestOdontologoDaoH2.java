package test.com.digitalhouse.odontologo.dao;

import main.com.digitalhouse.odontologo.dao.IDao;
import main.com.digitalhouse.odontologo.dao.impl.OdontologoDaoH2;
import main.com.digitalhouse.odontologo.model.Odontologo;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TestOdontologoDaoH2 {

    private static final Logger logger = Logger.getLogger(TestOdontologoDaoH2.class);

    private IDao<Odontologo> odontologoIDao = new OdontologoDaoH2();

    @Before
    public void crearOdontologoH2(){
        odontologoIDao.guardar(new Odontologo(20L,"Gonzales","Gomez",32984));
        odontologoIDao.guardar(new Odontologo(21L,"Pirulin","Pirulo",32834));
        odontologoIDao.guardar(new Odontologo(23L,"Messi","Lionel",18122));
    }

    @Test
    public void listarOdontologoH2(){
        logger.info("Listando todos los odontologos.");
        List<Odontologo> odontologos = odontologoIDao.listar();
        assertTrue(odontologos.size() > 0);
    }

    @Test
    public void guardarOdontologoH2(){
        logger.info("Guardando al odontologo.");
        odontologoIDao.guardar(new Odontologo(32L,"Scaloni","Leonel",29378));
        Odontologo o = odontologoIDao.buscar(32L);
        assertEquals(o.getNombre(), "Leonel");
    }

    @Test
    public void eliminarOdontologoH2(){
        logger.info("Eliminando el odontologo.");
        odontologoIDao.guardar(new Odontologo(30L,"DiMaria","Angel",93403));
        odontologoIDao.eliminar(30L);
        assertNull(odontologoIDao.buscar(30L));
    }

    @Test
    public void buscarOdontologoH2(){
        logger.info("Buscando al odontologo.");
        odontologoIDao.guardar(new Odontologo(36L, "DePaul","Rodrigo",28054));
        assertNotNull(odontologoIDao.buscar(36L));
    }
}
