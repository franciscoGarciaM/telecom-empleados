package com.telecom.empleado.model;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "cuadrilla")
public class Cuadrilla {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cuadrilla_id_gen")
    @SequenceGenerator(name = "cuadrilla_id_gen", sequenceName = "cuadrilla_id_cuadrilla_seq", allocationSize = 1)
    @Column(name = "id_cuadrilla", nullable = false)
    private Integer id;

    @Column(name = "nombre_cuadrilla", length = Integer.MAX_VALUE)
    private String nombreCuadrilla;

    @Column(name = "uuid")
    private UUID uuid;

    @OneToMany(mappedBy = "idCuadrilla")
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