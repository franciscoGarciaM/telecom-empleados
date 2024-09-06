package com.telecom.empleado.repository;

import com.telecom.empleado.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RolRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByUuid(UUID uuid);
}
