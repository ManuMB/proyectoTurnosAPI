package com.digitalhouse.turnos.repository;

import com.digitalhouse.turnos.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPacienteRepository extends JpaRepository<Paciente,Long> {
}
