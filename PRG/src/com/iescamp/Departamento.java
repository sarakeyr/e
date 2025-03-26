package com.iescamp;

import java.util.ArrayList;
import java.util.Objects;

public class Departamento {
    private int codigo;
    private String nombre;
    private ArrayList<com.iescamp.Empleado> empleados;

    public Departamento(int codigo, String nombre) {
        this.setCodigo(codigo);
        this.setNombre(nombre);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        if (codigo <= 0) {
            throw new IllegalArgumentException("El ID debe ser un número positivo");
        }
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre;
    }

    public ArrayList<com.iescamp.Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<com.iescamp.Empleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departamento that = (Departamento) o;
        return codigo == that.codigo && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre);
    }

    @Override
    public String toString() {
        return "Departamento: " + codigo + "\n" + "Nombre: " + nombre;
    }
}