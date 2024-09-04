package com.telecom.empleado.services;

import com.telecom.empleado.exception.ResourceNotFoundException;
import com.telecom.empleado.model.Empleado;
import com.telecom.empleado.repository.EmpleadoRepository;
import com.telecom.empleado.request.EmpleadoRequest;
import com.empleado.response.EmpleadoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<EmpleadoResponse> findAll() {
        List<Empleado> listaEmpleados = empleadoRepository.findAll();
        List<EmpleadoResponse> listaEmpleadoResponse = new ArrayList<>();
        for (Empleado empleado : listaEmpleados) {
            EmpleadoResponse empleadoTmp = mappingEntityToResponse(empleado);
            listaEmpleadoResponse.add(empleadoTmp);
        }
        return listaEmpleadoResponse;
    }

    public EmpleadoResponse findByUuid(UUID uuid) throws ResourceNotFoundException {
        Empleado empleado = empleadoRepository.findByUuid(uuid)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado no encontrado por ID " + uuid));
        return mappingEntityToResponse(empleado);
    }

    @Transactional
    public EmpleadoResponse saveEmpleado(EmpleadoRequest empleadoRequest) {
        Empleado empleado = mappingRequestToEntity(empleadoRequest);
        Empleado savedEmpleado = empleadoRepository.save(empleado);
        return mappingEntityToResponse(savedEmpleado);
    }

    @Transactional
    public EmpleadoResponse updateEmpleado(UUID uuid, EmpleadoRequest empleadoRequest) throws ResourceNotFoundException {
        Empleado empleado = empleadoRepository.findByUuid(uuid)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado no encontrado por ID " + uuid));

        empleado.setNombre(empleadoRequest.getNombre());
        empleado.setNumEmpleado(empleadoRequest.getNumEmpleado());
        empleado.setFechaNacimiento(empleadoRequest.getFechaNacimiento());

        // Convertir LocalDateTime a LocalDate si es necesario
        if (empleadoRequest.getFechaUltimoLogin() != null) {
            empleado.setFechaUltimoLogin(empleadoRequest.getFechaUltimoLogin().toLocalDate());
        }

        empleado.setPuesto(empleadoRequest.getPuesto());
        empleado.setIndActivo(empleadoRequest.getIndActivo());
        empleado.setNomEmpleado(empleadoRequest.getNomEmpleado());
        empleado.setPassword(empleadoRequest.getPassword());

        final Empleado updatedEmpleado = empleadoRepository.save(empleado);
        return mappingEntityToResponse(updatedEmpleado);
    }

    @Transactional
    public void deleteEmpleado(UUID uuid) throws ResourceNotFoundException {
        Empleado empleado = empleadoRepository.findByUuid(uuid)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado no encontrado por ID " + uuid));
        empleadoRepository.delete(empleado);
    }

    private EmpleadoResponse mappingEntityToResponse(Empleado empleado) {
        EmpleadoResponse empleadoResponse = new EmpleadoResponse();
        empleadoResponse.setNombre(empleado.getNombre());
        empleadoResponse.setNumEmpleado(empleado.getNumEmpleado());
        empleadoResponse.setFechaNacimiento(empleado.getFechaNacimiento());
        empleadoResponse.setFechaUltimoLogin(empleado.getFechaUltimoLogin());
        empleadoResponse.setPuesto(empleado.getPuesto());
        empleadoResponse.setIndActivo(empleado.getIndActivo());
        empleadoResponse.setNomEmpleado(empleado.getNomEmpleado());
        empleadoResponse.setUuid(empleado.getUuid());
        return empleadoResponse;
    }

    private Empleado mappingRequestToEntity(EmpleadoRequest empleadoRequest) {
        Empleado empleado = new Empleado();
        empleado.setNombre(empleadoRequest.getNombre());
        empleado.setNumEmpleado(empleadoRequest.getNumEmpleado());
        empleado.setFechaNacimiento(empleadoRequest.getFechaNacimiento());

        // Convertir LocalDateTime a LocalDate si es necesario
        if (empleadoRequest.getFechaUltimoLogin() != null) {
            empleado.setFechaUltimoLogin(empleadoRequest.getFechaUltimoLogin().toLocalDate());
        }

        empleado.setPuesto(empleadoRequest.getPuesto());
        empleado.setIndActivo(empleadoRequest.getIndActivo());
        empleado.setNomEmpleado(empleadoRequest.getNomEmpleado());
        empleado.setPassword(empleadoRequest.getPassword());
        empleado.setUuid(UUID.randomUUID());
        return empleado;
    }
}
