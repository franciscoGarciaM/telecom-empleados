package com.telecom.empleado.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "empleado_cuadrilla")
public class EmpleadoCuadrilla {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empleado_cuadrilla_id_gen")
    @SequenceGenerator(name = "empleado_cuadrilla_id_gen", sequenceName = "empleado_cuadrilla_id_empleado_cuadrilla_seq", allocationSize = 1)
    @Column(name = "id_empleado_cuadrilla", nullable = false)
    private Integer id;

    @Column(name = "uuid")
    private UUID uuid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cuadrilla", nullable = false)
    private Cuadrilla idCuadrilla;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_empleado", nullable = false)
    private Empleado idEmpleado;

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

    public Cuadrilla getIdCuadrilla() {
        return idCuadrilla;
    }

    public void setIdCuadrilla(Cuadrilla idCuadrilla) {
        this.idCuadrilla = idCuadrilla;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

}