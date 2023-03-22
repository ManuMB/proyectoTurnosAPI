package test.com.digitalhouse.odontologo.service;


import main.com.digitalhouse.odontologo.dao.IDao;
import main.com.digitalhouse.odontologo.dao.impl.OdontologoDaoH2;
import main.com.digitalhouse.odontologo.model.Odontologo;
import main.com.digitalhouse.odontologo.service.OdontologoService;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class TestOdontologoService {

    private static final Logger logger = Logger.getLogger(TestOdontologoService.class);

    private IDao<Odontologo> odontologoIDao = new OdontologoDaoH2();
    private OdontologoService odontologoService = new OdontologoService();


    @Before
    public void crearOdontologoService() {
        logger.info("Creando odontologos.");
        odontologoService.setOdontologoIDao(odontologoIDao);
        odontologoService.guardarOdontologo(new Odontologo(2L,"Viber","Jostin",12345));
        odontologoService.guardarOdontologo(new Odontologo(3L,"Menendez","Manuel",03145));
    }

    @Test
    public void testBuscarOdontologoService(){
        logger.info("Buscando odontologos.");
        odontologoService.setOdontologoIDao(odontologoIDao);
        Odontologo o = odontologoService.buscarOdontologo(2L);
        Assert.assertEquals(o.getNombre(),"Jostin");
        Assert.assertEquals(o.getApellido(),"Viber");
    }

}
