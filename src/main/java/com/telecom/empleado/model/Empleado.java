package com.telecom.empleado.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
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

    @Column(name = "numero_empleado", length = Integer.MAX_VALUE)
    private String numeroEmpleado;

    @Column(name = "ultimo_acceso")
    private LocalDate ultimoAcceso;

    @Column(name = "nombre_usuario", length = Integer.MAX_VALUE)
    private String nombreUsuario;

    @Column(name = "email", length = Integer.MAX_VALUE)
    private String email;

    @Column(name = "celular", length = Integer.MAX_VALUE)
    private String celular;

    @Column(name = "fecha_creacion", length = Integer.MAX_VALUE)
    private String fechaCreacion;

    @Column(name = "fecha_modificacion", length = Integer.MAX_VALUE)
    private String fechaModificacion;

    @OneToMany(mappedBy = "idEmpleado")
    private Set<EmpleadoCuadrilla> empleadoCuadrillas = new LinkedHashSet<>();

    public Set<EmpleadoCuadrilla> getEmpleadoCuadrillas() {
        return empleadoCuadrillas;
    }

    public void setEmpleadoCuadrillas(Set<EmpleadoCuadrilla> empleadoCuadrillas) {
        this.empleadoCuadrillas = empleadoCuadrillas;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public LocalDate getUltimoAcceso() {
        return ultimoAcceso;
    }

    public void setUltimoAcceso(LocalDate ultimoAcceso) {
        this.ultimoAcceso = ultimoAcceso;
    }

    public String getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(String numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

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
