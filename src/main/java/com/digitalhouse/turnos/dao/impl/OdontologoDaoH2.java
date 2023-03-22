package com.digitalhouse.turnos.dao.impl;


import com.digitalhouse.turnos.dao.IDao;
import com.digitalhouse.turnos.model.Odontologo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
//import test.com.digitalhouse.odontologo.service.TestOdontologoService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OdontologoDaoH2 implements IDao<Odontologo> {

    private static final Logger logger = Logger.getLogger(OdontologoDaoH2.class);

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:C:\\Users\\Manuel\\Documents\\DH\\backEnd\\parcialOdontologo";
    private final static String DB_USER = "root";
    private final static String DB_PASSWORD = "root";


    public OdontologoDaoH2() {
    }

    @Override
    public List listar() {

        Connection connection = null;
        PreparedStatement statement = null;
        List<Odontologo> listaOdontologos = new ArrayList<>();

        try{
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            statement = connection.prepareStatement("SELECT * FROM odontologos");

            ResultSet result = statement.executeQuery();  //cuando es de lectura usamos executeQuery, cuando es de modificar/agregar usamos executeUpdate

            while (result.next()){
                Long id = result.getLong("id");
                String apellido = result.getString("apellido");
                String nombre = result.getString("nombre");
                int matricula = result.getInt("matricula");

                listaOdontologos.add(new Odontologo(id, apellido, nombre, matricula));
            }

            logger.info("Todos los odontologos listados con exito.");
            statement.close();

        }catch(SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            logger.error("Error, no se han podido listar los odontologos.");
        }

        return listaOdontologos;
    }

    @Override
    public Odontologo guardar(Odontologo o) {

        Connection connection = null;
        PreparedStatement statement = null;

        try{
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            statement = connection.prepareStatement("INSERT INTO odontologos VALUES (?,?,?,?)");
            statement.setLong(1, o.getId());
            statement.setString(2, o.getApellido());
            statement.setString(3, o.getNombre());
            statement.setInt(4, o.getMatricula());

            statement.executeUpdate();
            logger.info("Odontologo guardado con exito.");
            statement.close();

        }catch(SQLException | ClassNotFoundException throwables) {
            logger.error("Error, no se ha podido guardar el odontologo.");
            throwables.printStackTrace();
        }

        return o;
    }

    @Override
    public Odontologo buscar(Long id) {

        Connection connection = null;
        PreparedStatement statement = null;
        Odontologo o = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            statement = connection.prepareStatement("SELECT * FROM odontologos WHERE id = ?");
            statement.setLong(1, id);

            ResultSet result = statement.executeQuery();

            while (result.next()){
                Long idOdontologo = result.getLong("id");
                String apellido = result.getString("apellido");
                String nombre = result.getString("nombre");
                int matricula = result.getInt("matricula");

                o = new Odontologo(idOdontologo, apellido, nombre, matricula);
            }

            logger.info("Odontologo encontrado con exito.");
            statement.close();

        }catch(SQLException | ClassNotFoundException throwables) {
            logger.error("Error, no se ha encontrado el odontologo.");
            throwables.printStackTrace();
        }
        return o;
    }

    @Override
    public void eliminar(Long id) {

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            statement = connection.prepareStatement("DELETE FROM odontologos WHERE id = ?");
            statement.setLong(1, id);

            statement.executeUpdate();
            logger.info("Odontologo eliminado con exito.");
            statement.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            logger.error("Error, no se ha eliminado el odontologo.");
            throwables.printStackTrace();
        }
    }

    @Override
    public Odontologo actualizar(Odontologo odontologo) {
        return null;
    }


}
