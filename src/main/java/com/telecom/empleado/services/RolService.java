package com.telecom.empleado.services;

import com.telecom.empleado.model.Rol;
import com.telecom.empleado.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public List<Rol> findAll() {
        return rolRepository.findAll();
    }

    public Rol saveRol(Rol rol) {
        return rolRepository.save(rol);
    }

    public Rol updateRol(Long idRol, Rol rolDetails) {
        Rol rol = rolRepository.findById(idRol)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado por ID " + idRol));

        rol.setPuesto(rolDetails.getPuesto());
        return rolRepository.save(rol);
    }
}
