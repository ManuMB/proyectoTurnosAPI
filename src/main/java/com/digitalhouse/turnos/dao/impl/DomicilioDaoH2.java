package com.digitalhouse.turnos.dao.impl;

import com.digitalhouse.turnos.dao.IDao;
import com.digitalhouse.turnos.model.Domicilio;
import com.digitalhouse.turnos.model.Odontologo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DomicilioDaoH2 implements IDao<Domicilio> {

    private static final Logger logger = Logger.getLogger(DomicilioDaoH2.class);

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:C:\\Users\\Manuel\\Documents\\DH\\backEnd\\parcialOdontologo";
    private final static String DB_USER = "root";
    private final static String DB_PASSWORD = "root";

    public DomicilioDaoH2() {
    }


    @Override
    public List<Domicilio> listar() {

        Connection connection = null;
        PreparedStatement statement = null;
        List<Domicilio> listaDomicilios = new ArrayList<>();

        try{
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            statement = connection.prepareStatement("SELECT * FROM domicilios");

            ResultSet result = statement.executeQuery();

            while (result.next()){
                Long id = result.getLong("id");
                String calle = result.getString("calle");
                String numero = result.getString("numero");
                String localidad = result.getString("localidad");
                String provincia = result.getString("provincia");

                listaDomicilios.add(new Domicilio(id,calle,numero,localidad,provincia));
            }

            logger.info("Todos los domicilios listados con exito.");
            connection.close();

        }catch(SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            logger.error("Error, no se han podido listar los domicilios.");
        }
        return listaDomicilios;
    }

    @Override
    public Domicilio guardar(Domicilio domicilio) {

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            statement = connection.prepareStatement("INSERT INTO domicilios VALUES (?,?,?,?,?)");
            statement.setLong(1, domicilio.getId());
            statement.setString(2, domicilio.getCalle());
            statement.setString(3, domicilio.getNumero());
            statement.setString(4, domicilio.getLocalidad());
            statement.setString(5, domicilio.getProvincia());

            statement.executeUpdate();
            logger.info("Domicilio guardado con exito.");
            statement.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            logger.error("Error, no se ha podido guardar el domicilio.");
            throwables.printStackTrace();
        }

        return domicilio;
    }

    @Override
    public Domicilio buscar(Long id) {
        Connection connection = null;
        PreparedStatement statement = null;
        Domicilio domicilio = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            statement = connection.prepareStatement("SELECT * FROM domicilios WHERE id = ?");
            statement.setLong(1, id);

            ResultSet result = statement.executeQuery();

            while (result.next()){
                Long idDomicilio = result.getLong("id");
                String calle = result.getString("calle");
                String numero = result.getString("numero");
                String localidad = result.getString("localidad");
                String provincia = result.getString("provincia");

                domicilio = new Domicilio(idDomicilio,calle,numero,localidad,provincia);
            }

            logger.info("Domicilio encontrado con exito.");
            statement.close();

        }catch(SQLException | ClassNotFoundException throwables) {
            logger.error("Error, no se ha encontrado el domicilio.");
            throwables.printStackTrace();
        }

        return domicilio;
    }

    @Override
    public void eliminar(Long id) {

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            statement = connection.prepareStatement("DELETE FROM domicilios WHERE id = ?");
            statement.setLong(1, id);

            statement.executeUpdate();
            logger.info("Domicilio eliminado con exito.");
            statement.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            logger.error("Error, no se ha eliminado el domicilios.");
            throwables.printStackTrace();
        }
    }

    @Override
    public Domicilio actualizar(Domicilio domicilio) {
        return null;
    }
}
