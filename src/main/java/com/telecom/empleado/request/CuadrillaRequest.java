package com.telecom.empleado.request;

import java.util.List;

public class CuadrillaRequest {
    private String nombreCuadrilla;

    private List<EmpleadoRequest> empleados;

    public List<EmpleadoRequest> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<EmpleadoRequest> empleados) {
        this.empleados = empleados;
    }

    public String getNombreCuadrilla() {
        return nombreCuadrilla;
    }

    public void setNombreCuadrilla(String nombreCuadrilla) {
        this.nombreCuadrilla = nombreCuadrilla;
    }

}
