package com.digitalhouse.turnos.dao.impl;

import com.digitalhouse.turnos.dao.IDao;
import com.digitalhouse.turnos.model.Odontologo;
import com.digitalhouse.turnos.model.Paciente;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PacienteDaoH2 implements IDao<Paciente> {

    private static final Logger logger = Logger.getLogger(PacienteDaoH2.class);

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:C:\\Users\\Manuel\\Documents\\DH\\backEnd\\parcialOdontologo;INIT= RUNSCRIPT FROM 'create.sql'";
    private final static String DB_USER = "root";
    private final static String DB_PASSWORD = "root";

    public PacienteDaoH2() {
    }

    @Override
    public List<Paciente> listar() {

        Connection connection = null;
        PreparedStatement statement = null;
        List<Paciente> listaPacientes = new ArrayList<>();

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            statement = connection.prepareStatement("GET * FROM pacientes");

            ResultSet result = statement.executeQuery();

            while (result.next()){
                Long id = result.getLong("id");
                String apellido = result.getString("apellido");
                String nombre = result.getString("nombre");
                int dni = result.getInt("dni");
                String fechaAlta = result.getString("fechaAlta");

                listaPacientes.add(new Paciente(id,apellido,nombre,dni,fechaAlta));
            }

            logger.info("Todos los pacientes listados con exito.");
            statement.close();

        }catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            logger.error("Error, no se han podido listar los pacientes.");
        }

        return listaPacientes;
    }

    @Override
    public Paciente guardar(Paciente paciente) {

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            statement = connection.prepareStatement("INSERT INTO PACIENTES VALUES (?,?,?,?,?)");
            statement.setLong(1, paciente.getId());
            statement.setString(2,paciente.getApellido());
            statement.setString(3,paciente.getNombre());
            statement.setInt(4,paciente.getDni());
            statement.setString(5,paciente.getFechaAlta());

            statement.executeUpdate();
            logger.info("Paciente guardado con exito.");
            statement.close();

        }catch(SQLException | ClassNotFoundException throwables) {
            logger.error("Error, no se ha podido guardar el odontologo.");
            throwables.printStackTrace();
        }

        return paciente;
    }

    @Override
    public Paciente buscar(Long id) {
        Connection connection = null;
        PreparedStatement statement = null;
        Paciente p = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            statement = connection.prepareStatement("SELECT * FROM PACIENTES WHERE id = ?");
            statement.setLong(1, id);

            ResultSet result = statement.executeQuery();

            while (result.next()){
                Long idPaciente = result.getLong("id");
                String apellido = result.getString("apellido");
                String nombre = result.getString("nombre");
                int dni = result.getInt("dni");
                String fechaAlta = result.getString("fechaAlta");

                p = new Paciente(idPaciente,apellido,nombre,dni,fechaAlta);
            }

        }catch(SQLException | ClassNotFoundException throwables) {
            logger.error("Error, no se ha encontrado al paciente.");
            throwables.printStackTrace();
        }

        return p;
    }

    @Override
    public void eliminar(Long id) {

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            statement = connection.prepareStatement("DELETE FROM pacientes WHERE id = ?");
            statement.setLong(1, id);

            statement.executeUpdate();
            logger.info("Paciente eliminado con exito.");
            statement.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            logger.error("Error, no se ha eliminado el paciente.");
            throwables.printStackTrace();
        }
    }

    @Override
    public Paciente actualizar(Paciente paciente) {
        return null;
    }
}
