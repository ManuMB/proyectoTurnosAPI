/*
package com.digitalhouse.turnos;

import main.com.digitalhouse.odontologo.dao.impl.OdontologoDaoH2;
import main.com.digitalhouse.odontologo.model.Odontologo;
import main.com.digitalhouse.odontologo.service.OdontologoService;
import org.apache.log4j.Logger;
//import test.com.digitalhouse.odontologo.dao.TestOdontologoDaoH2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);

    private static final String createTable =

            "DROP TABLE IF EXISTS odontologos; CREATE TABLE odontologos"
                    + "("
                    + " id LONG PRIMARY KEY,"
                    + " apellido varchar(255) NOT NULL,"
                    + " nombre varchar(255) NOT NULL,"
                    + " matricula INT NOT NULL"
                    + ");";

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:C:\\Users\\Manuel\\Documents\\DH\\backEnd\\parcialOdontologo","root","root");
    }


    public static void main(String[] args) throws Exception {

        Odontologo o = new Odontologo(1L,"Perez","Juan",2843);

        Connection connection = getConnection();

        try{
            Statement statement = connection.createStatement();
            statement.execute(createTable);

            OdontologoService odonService = new OdontologoService();
            odonService.setOdontologoIDao(new OdontologoDaoH2());

            odonService.guardarOdontologo(o);

        }catch (Exception e){
            connection.rollback();

        }finally {
            logger.info("Conexion finalizada.");
            connection.close();
        }

    }
}
*/