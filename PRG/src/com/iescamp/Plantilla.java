package com.iescamp;

import java.util.ArrayList;
import java.util.Iterator;

public class Plantilla {
    private ArrayList<Empleado> empleados = new ArrayList<>();

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<com.iescamp.Empleado> empleados) {
        this.empleados = empleados;
    }

    // CRUD
    public void crear(Empleado emp) {
        if (buscarPorDNI(emp.getDni()) != null) {
            throw new IllegalArgumentException("DNI duplicado");
        }
        empleados.add(emp);
    }

    public Empleado leer(int index) {
        return (index >= 0 && index < empleados.size()) ? empleados.get(index) : null;
    }

    public boolean actualizar(Empleado emp) {
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getDni().equals(emp.getDni())) {
                empleados.set(i, emp);
                return true;
            }
        }
        return false;
    }

    public boolean borrar(String dni) {
        Iterator<Empleado> it = empleados.iterator();
        while (it.hasNext()) {
            if (it.next().getDni().equals(dni)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    // Búsquedas y Filtrados
    public Empleado buscarPorDNI(String dni) {
        for (Empleado emp : empleados) {
            if (emp.getDni().equalsIgnoreCase(dni)) {
                return emp;
            }
        }
        return null;
    }

    public ArrayList<Empleado> filtrarPorDepartamento(Departamento depto) {
        ArrayList<Empleado> resultado = new ArrayList<>();
        for (Empleado emp : empleados) {
            if (emp.getDepartamento().equals(depto)) {
                resultado.add(emp);
            }
        }
        return resultado;
    }

    public ArrayList<Empleado> filtrarPorAdministradores() {
        ArrayList<Empleado> resultado = new ArrayList<>();
        for (Empleado emp : empleados) {
            if (emp.isTienePrivilegios()) {
                resultado.add(emp);
            }
        }
        return resultado;
    }

    public ArrayList<Empleado> filtrarPorNombreApellidos(String nombre, String apellidos) {
        ArrayList<Empleado> resultado = new ArrayList<>();
        for (Empleado emp : empleados) {
            if (emp.getNombre().equalsIgnoreCase(nombre)
                    && emp.getApellidos().equalsIgnoreCase(apellidos)) {
                resultado.add(emp);
            }
        }
        return resultado;
    }

    public ArrayList<Empleado> filtrarPorNombreApellidos(String completo) {
        ArrayList<Empleado> resultado = new ArrayList<>();
        String lowerBusqueda = completo.toLowerCase();
        for (Empleado e : empleados) {
            String nombreCompleto = (e.getNombre() + " " + e.getApellidos()).toLowerCase();
            if (nombreCompleto.contains(lowerBusqueda)) {
                resultado.add(e);
            }
        }
        return resultado;
    }
}
