package com.iescamp;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Empleado extends Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    private boolean tienePrivilegios;
    private Departamento departamento;

    public Empleado(String dni, String nombre, String apellidos, String direccion, String telefono, String correoElectronico, LocalDate fechaNacimiento, String pass, boolean activo, boolean tienePrivilegios, Departamento departamento) {
        super(dni, nombre, apellidos, direccion, telefono, correoElectronico, fechaNacimiento, pass, activo);
        this.setTienePrivilegios(tienePrivilegios);
        this.setDepartamento(departamento);
    }

    public boolean isTienePrivilegios() {
        return tienePrivilegios;
    }

    public void setTienePrivilegios(boolean tienePrivilegios) {
        this.tienePrivilegios = tienePrivilegios;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        if (departamento == null) {
            throw new IllegalArgumentException("El departamento no puede ser nulo");
        }
        this.departamento = departamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Empleado empleado = (Empleado) o;
        return tienePrivilegios == empleado.tienePrivilegios && Objects.equals(departamento, empleado.departamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tienePrivilegios, departamento);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\tPrivilegios       : " + (tienePrivilegios ? "Sí" : "No") + "\n" +
                "\tDepartamento      : " + departamento + "\n";
    }
}
