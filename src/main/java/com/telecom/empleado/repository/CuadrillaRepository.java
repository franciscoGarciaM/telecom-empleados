package com.telecom.empleado.repository;

import com.telecom.empleado.model.Cuadrilla;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CuadrillaRepository extends JpaRepository<Cuadrilla, Long> {
    Optional<Cuadrilla> findByUuid(UUID uuid);
}
