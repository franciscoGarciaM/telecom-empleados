package com.telecom.empleado.controller;

import com.telecom.empleado.model.Rol;
import com.telecom.empleado.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public List<Rol> getAllRoles() {
        return rolService.findAll();
    }

    @PostMapping
    public Rol createRol(@RequestBody Rol rol) {
        return rolService.saveRol(rol);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rol> updateRol(@PathVariable Long id, @RequestBody Rol rolDetails) {
        Rol updatedRol = rolService.updateRol(id, rolDetails);
        return ResponseEntity.ok(updatedRol);
    }
}
