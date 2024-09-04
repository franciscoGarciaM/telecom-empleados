package com.telecom.empleado.controller;

import com.telecom.empleado.exception.ResourceNotFoundException;
import com.telecom.empleado.request.EmpleadoRequest;
import com.empleado.response.EmpleadoResponse;

import com.telecom.empleado.services.EmpleadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/empleado")
    public List<EmpleadoResponse> getEmpleado() {
        return empleadoService.findAll();
    }

    @GetMapping("/empleado/{uuid}")
    public ResponseEntity<EmpleadoResponse> getEmpleadoById(@PathVariable(value = "uuid") UUID uuid)
            throws ResourceNotFoundException {
        EmpleadoResponse empleado = empleadoService.findByUuid(uuid);
        return ResponseEntity.ok().body(empleado);
    }

    @PostMapping("/empleado")
    public ResponseEntity<EmpleadoResponse> createEmpleado(@Valid @RequestBody EmpleadoRequest empleadoRequest) {
        EmpleadoResponse empleadoResponse = empleadoService.saveEmpleado(empleadoRequest);
        return new ResponseEntity<>(empleadoResponse, HttpStatus.CREATED);
    }

    @PutMapping("/empleado/{uuid}")
    public ResponseEntity<EmpleadoResponse> updateEmpleado(
            @PathVariable(value = "uuid") UUID uuid,
            @Valid @RequestBody EmpleadoRequest empleadoRequest) throws ResourceNotFoundException {
        EmpleadoResponse empleadoResponse = empleadoService.updateEmpleado(uuid, empleadoRequest);
        return ResponseEntity.ok(empleadoResponse);
    }

    @DeleteMapping("/empleado/{uuid}")
    public ResponseEntity<Void> deleteEmpleado(@PathVariable(value = "uuid") UUID uuid)
            throws ResourceNotFoundException {
        empleadoService.deleteEmpleado(uuid);
        return ResponseEntity.noContent().build();
    }
}
