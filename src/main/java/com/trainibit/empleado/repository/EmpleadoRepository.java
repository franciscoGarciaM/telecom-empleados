package com.trainibit.empleado.repository;

import com.trainibit.empleado.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    Optional<Empleado> findByUuid(UUID uuid);

    Optional<Empleado> findByNomEmpleadoAndPassword(String nomEmpleado, String password);
}
