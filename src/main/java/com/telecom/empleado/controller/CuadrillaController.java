package com.telecom.empleado.controller;

import com.telecom.empleado.model.Cuadrilla;
import com.telecom.empleado.request.CuadrillaRequest;
import com.telecom.empleado.services.CuadrillaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cuadrilla")
public class CuadrillaController {

    @Autowired
    private CuadrillaService cuadrillaService;

    @GetMapping
    public List<Cuadrilla> getAllCuadrillaes() {
        return cuadrillaService.findAll();
    }

    @PostMapping
    public Cuadrilla createCuadrilla(@RequestBody CuadrillaRequest cuadrilla) {
        Cuadrilla CuadrillaRequest = null;
        return cuadrillaService.saveCuadrilla(cuadrilla);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cuadrilla> updateCuadrilla(@PathVariable Long id, @RequestBody Cuadrilla cuadrillaDetails) {
        Cuadrilla updatedCuadrilla = cuadrillaService.updateCuadrilla(id, cuadrillaDetails);
        return ResponseEntity.ok(updatedCuadrilla);
    }
}
