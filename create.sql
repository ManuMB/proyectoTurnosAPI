DROP TABLE PACIENTES IF EXISTS;
CREATE TABLE PACIENTES(id INT PRIMARY KEY, apellido VARCHAR(255) NOT NULL, nombre VARCHAR(255) NOT NULL, dni INT NOT NULL, fechaAlta VARCHAR(255) NOT NULL);
