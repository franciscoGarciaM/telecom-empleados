package com.telecom.empleado.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "empleado_cuadrilla")
public class EmpleadoCuadrilla {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado_cuadrilla", nullable = false)
    private Integer id;

    @Column(name = "uuid")
    private UUID uuid;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cuadrilla", nullable = false)
    private Cuadrilla cuadrilla;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_empleado", nullable = false)
    private Empleado empleado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Cuadrilla getCuadrilla() {
        return cuadrilla;
    }

    public void setCuadrilla(Cuadrilla idCuadrilla) {
        this.cuadrilla = idCuadrilla;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado idEmpleado) {
        this.empleado = idEmpleado;
    }

}