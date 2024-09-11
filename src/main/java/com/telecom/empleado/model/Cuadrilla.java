package com.telecom.empleado.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "cuadrilla")
public class Cuadrilla {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cuadrilla", nullable = false)
    private Integer id;

    @Column(name = "nombre_cuadrilla", length = Integer.MAX_VALUE)
    private String nombreCuadrilla;

    @Column(name = "uuid")
    private UUID uuid;

    @JsonManagedReference
    @OneToMany(mappedBy = "cuadrilla", cascade = CascadeType.ALL)
    private Set<EmpleadoCuadrilla> empleadoCuadrillas = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCuadrilla() {
        return nombreCuadrilla;
    }

    public void setNombreCuadrilla(String nombreCuadrilla) {
        this.nombreCuadrilla = nombreCuadrilla;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Set<EmpleadoCuadrilla> getEmpleadoCuadrillas() {
        return empleadoCuadrillas;
    }

    public void setEmpleadoCuadrillas(Set<EmpleadoCuadrilla> empleadoCuadrillas) {
        this.empleadoCuadrillas = empleadoCuadrillas;
    }

}