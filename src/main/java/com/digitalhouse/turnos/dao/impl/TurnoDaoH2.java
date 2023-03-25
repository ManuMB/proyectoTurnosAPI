/*

package com.digitalhouse.turnos.dao.impl;

import com.digitalhouse.turnos.dao.IDao;
import com.digitalhouse.turnos.model.Odontologo;
import com.digitalhouse.turnos.model.Turno;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TurnoDaoH2 implements IDao<Turno> {

    private static final Logger logger = Logger.getLogger(TurnoDaoH2.class);

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:C:\\Users\\Manuel\\Documents\\DH\\backEnd\\parcialOdontologo";
    private final static String DB_USER = "root";
    private final static String DB_PASSWORD = "root";

    public TurnoDaoH2() {
    }


    @Override
    public List<Turno> listar() {
        Connection connection = null;
        PreparedStatement statement = null;
        List<Turno> listaTurnos = new ArrayList<>();

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            statement = connection.prepareStatement("SELECT * FROM turnos");

            ResultSet result = statement.executeQuery();

            while (result.next()){
                Long id = result.getLong("id");
                String odontologo = result.getString("odontologo");     //Sería string o odontologo???
                String fecha = result.getString("fecha");
                String hora = result.getString("hora");

                listaTurnos.add(new Turno(id,odontologo,fecha,hora));
            }

            logger.info("Todos los turnos listados con exito.");
            statement.close();

        }catch(SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            logger.error("Error, no se han podido listar los turnos.");
        }

        return listaTurnos;
    }

    @Override
    public Turno guardar(Turno turno) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            statement = connection.prepareStatement("INSERT INTO turnos VALUES (?,?,?,?)");

            statement.setLong(1,turno.getId());
            statement.setString(2,turno.getOdontologo());
            statement.setString(3, turno.getFecha());
            statement.setString(4, turno.getHora());

            statement.executeUpdate();
            logger.info("Turno guardado con exito.");
            statement.close();

        }catch(SQLException | ClassNotFoundException throwables) {
            logger.error("Error, no se ha podido guardar el turno.");
            throwables.printStackTrace();
        }

        return turno;
    }

    @Override
    public Turno buscar(Long id) {

        Connection connection = null;
        PreparedStatement statement = null;
        Turno t = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            statement = connection.prepareStatement("SELECT * FROM turnos WHERE id = ?");
            statement.setLong(1, id);

            ResultSet result = statement.executeQuery();

            while (result.next()){
                Long idTurno = result.getLong("id");
                String odontologo = result.getString("odontologo");     //Sería string o odontologo???
                String fecha = result.getString("fecha");
                String hora = result.getString("hora");

                t = new Turno(idTurno,odontologo,fecha,hora);
            }

            logger.info("Turno encontrado con exito.");
            statement.close();

        }catch(SQLException | ClassNotFoundException throwables) {
            logger.error("Error, no se ha encontrado el turno.");
            throwables.printStackTrace();
        }

        return t;
    }

    @Override
    public void eliminar(Long id) {

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            statement = connection.prepareStatement("DELETE FROM turnos WHERE id = ?");
            statement.setLong(1, id);

            statement.executeUpdate();
            logger.info("Turno eliminado con exito.");
            statement.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            logger.error("Error, no se ha eliminado el turno.");
            throwables.printStackTrace();
        }
    }

    @Override
    public Turno actualizar(Turno turno) {
        return null;
    }
}


 */