package com.iescamp;

import java.util.ArrayList;
import java.util.Iterator;

public class Clientela {
    private ArrayList<Cliente> clientes = new ArrayList<>();

    // CRUD
    public void crear(Cliente cli) {
        if (buscarPorDNI(cli.getDni()) != null) {
            throw new IllegalArgumentException("Cliente ya existe");
        }
        clientes.add(cli);
    }

    public Cliente leer(int index) {
        return (index >= 0 && index < clientes.size()) ? clientes.get(index) : null;
    }

    public boolean actualizar(Cliente cli) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getDni().equals(cli.getDni())) {
                clientes.set(i, cli);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void eliminarCliente(int index) {
        clientes.remove(index);
    }

    public boolean borrar(String dni) {
        Iterator<Cliente> it = clientes.iterator();
        while (it.hasNext()) {
            if (it.next().getDni().equals(dni)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    // Búsquedas y Filtrados
    public Cliente buscarPorDNI(String dni) {
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equalsIgnoreCase(dni)) {
                return cliente;
            }
        }
        return null;
    }

    public ArrayList<Cliente> filtrarPorMetodoPago(MetodoPago metodo) {
        ArrayList<Cliente> resultado = new ArrayList<>();
        for (Cliente cliente : clientes) {
            if (cliente.getM_pago().equals(metodo)) {
                resultado.add(cliente);
            }
        }
        return resultado;
    }

    public ArrayList<Cliente> filtrarPorNombreApellidos(String busqueda) {
        ArrayList<Cliente> resultado = new ArrayList<>();
        String lowerBusqueda = busqueda.toLowerCase();
        for (Cliente c : clientes) {
            String nombreCompleto = (c.getNombre() + " " + c.getApellidos()).toLowerCase();
            if (nombreCompleto.contains(lowerBusqueda)) {
                resultado.add(c);
            }
        }
        return resultado;
    }

}
