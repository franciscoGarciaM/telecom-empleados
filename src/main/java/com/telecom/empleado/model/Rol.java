package com.telecom.empleado.model;

import jakarta.persistence.*;

import java.util.UUID;



@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Long idRol;

    private String puesto;
    private UUID uuid;

    // Getters y Setters
}
