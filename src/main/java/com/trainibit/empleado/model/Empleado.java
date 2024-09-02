package com.trainibit.empleado.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "num_empleado")
    private String numEmpleado;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "fecha_ultimo_login")
    private LocalDate fechaUltimoLogin;

    @Column(name = "puesto")
    private String puesto;

    @Column(name = "ind_activo")
    private Boolean indActivo;

    @Column(name = "nom_empleado", nullable = false)
    private String nomEmpleado;

    @Column(name = "password")
    private String password;

    @Column(name = "uuid")
    private UUID uuid;

    @PrePersist
    public void prePersist() {
        if (uuid == null) {
            uuid = UUID.randomUUID();
        }
    }

    public Empleado() {
    }

    public Empleado(String nombre, String numEmpleado, LocalDate fechaNacimiento, LocalDate fechaUltimoLogin,
                    String puesto, Boolean indActivo, String nomEmpleado, String password, UUID uuid) {
        this.nombre = nombre;
        this.numEmpleado = numEmpleado;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaUltimoLogin = fechaUltimoLogin;
        this.puesto = puesto;
        this.indActivo = indActivo;
        this.nomEmpleado = nomEmpleado;
        this.password = password;
        this.uuid = uuid;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(String numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaUltimoLogin() {
        return fechaUltimoLogin;
    }

    public void setFechaUltimoLogin(LocalDate fechaUltimoLogin) {
        this.fechaUltimoLogin = fechaUltimoLogin;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Boolean getIndActivo() {
        return indActivo;
    }

    public void setIndActivo(Boolean indActivo) {
        this.indActivo = indActivo;
    }

    public String getNomEmpleado() {
        return nomEmpleado;
    }

    public void setNomEmpleado(String nomEmpleado) {
        this.nomEmpleado = nomEmpleado;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
