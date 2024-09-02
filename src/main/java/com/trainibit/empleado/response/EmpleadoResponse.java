package com.trainibit.empleado.response;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.UUID;

public class EmpleadoResponse {

    private String nombre;

    private String numEmpleado;

    private LocalDate fechaNacimiento;

    private LocalDate fechaUltimoLogin;

    private String puesto;

    private Boolean indActivo;

    private String nomEmpleado;

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

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    // Campos calculados

    public Integer getEdad() {
        if (fechaNacimiento == null) {
            return null;
        }
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    public String getNombreMayusculas() {
        return nombre != null ? nombre.toUpperCase() : null;
    }

    public String getPuestoNombre() {
        return puesto != null && nombre != null ? puesto + " " + nombre : null;
    }

    public EmpleadoResponse() {
        // Constructor vacío para la deserialización
    }
}
