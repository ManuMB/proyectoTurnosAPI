package com.digitalhouse.turnos.repository;

import com.digitalhouse.turnos.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITurnoRepository extends JpaRepository<Turno,Long> {
}
