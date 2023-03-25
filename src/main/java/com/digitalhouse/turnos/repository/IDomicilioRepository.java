package com.digitalhouse.turnos.repository;

import com.digitalhouse.turnos.model.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDomicilioRepository extends JpaRepository<Domicilio,Long> {
}
