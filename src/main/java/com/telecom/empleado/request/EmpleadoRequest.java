package com.telecom.empleado.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class EmpleadoRequest {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 50, message = "El nombre no puede exceder 50 caracteres")
    private String nombre;

    @NotBlank(message = "El número de empleado es obligatorio")
    @Size(max = 20, message = "El número de empleado no puede exceder 20 caracteres")
    private String numEmpleado;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Past(message = "La fecha de nacimiento debe ser una fecha pasada")
    private LocalDate fechaNacimiento;

    private LocalDateTime fechaUltimoLogin;

    @NotBlank(message = "El puesto es obligatorio")
    @Size(max = 50, message = "El puesto no puede exceder 50 caracteres")
    private String puesto;

    @NotNull(message = "El indicador de actividad es obligatorio")
    private Boolean indActivo;

    @NotBlank(message = "El nombre de empleado es obligatorio")
    @Size(max = 50, message = "El nombre de empleado no puede exceder 50 caracteres")
    private String nomEmpleado;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    private String password;


    @NotBlank(message = "El e-mail es obligatoria")
    @Size(min = 8, message = "El email debe tener al menos 8 caracteres")
    private String email;

    @NotBlank(message = "El telefono es obligatoria")
    @Size(min = 8, message = "El telefono debe tener al menos 10 caracteres")
    private String celular;

    private Long idRol;

    private UUID uuid;

    // Getters y Setters

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

    public LocalDateTime getFechaUltimoLogin() {
        return fechaUltimoLogin;
    }

    public void setFechaUltimoLogin(LocalDateTime fechaUltimoLogin) {
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


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
