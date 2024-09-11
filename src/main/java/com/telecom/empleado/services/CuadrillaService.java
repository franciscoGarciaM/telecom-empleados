package com.telecom.empleado.services;

import com.telecom.empleado.model.Cuadrilla;
import com.telecom.empleado.model.Empleado;
import com.telecom.empleado.model.EmpleadoCuadrilla;
import com.telecom.empleado.repository.CuadrillaRepository;
import com.telecom.empleado.repository.EmpleadoRepository;
import com.telecom.empleado.request.CuadrillaRequest;
import com.telecom.empleado.request.EmpleadoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuadrillaService {


    @Autowired
    private EmpleadoRepository emlpleadoRepository;

    @Autowired
    private CuadrillaRepository cuadrillaRepository;
    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Cuadrilla> findAll() {
        return cuadrillaRepository.findAll();
    }

    public Cuadrilla saveCuadrilla(CuadrillaRequest cuadrilla) {
         return cuadrillaRepository.save(mappingRequestToEntity(cuadrilla));
    }

    public Cuadrilla updateCuadrilla(Long idCuadrilla, Cuadrilla cuadrillaDetails) {
        Cuadrilla cuadrilla = cuadrillaRepository.findById(idCuadrilla)
                .orElseThrow(() -> new RuntimeException("Cuadrilla no encontrado por ID " + idCuadrilla));

        cuadrilla.setNombreCuadrilla(cuadrillaDetails.getNombreCuadrilla());
        return cuadrillaRepository.save(cuadrilla);
    }

    private Cuadrilla mappingRequestToEntity(CuadrillaRequest cuadrillaRequest) {
        Cuadrilla cuadrilla = new Cuadrilla();
        cuadrilla.setNombreCuadrilla(cuadrillaRequest.getNombreCuadrilla());
        for (EmpleadoRequest empleadoRequest : cuadrillaRequest.getEmpleados()) {
            Empleado empleado = empleadoRepository.findByUuid(empleadoRequest.getUuid()).get();
            EmpleadoCuadrilla empleadoCuadrilla = new EmpleadoCuadrilla();
            empleadoCuadrilla.setEmpleado(empleado);
            empleadoCuadrilla.setCuadrilla(cuadrilla);
            cuadrilla.getEmpleadoCuadrillas().add(empleadoCuadrilla);
        }
        return cuadrilla;
    }

}
