package com.iescamp;

import java.util.ArrayList;
import java.util.Objects;

public class MetodoPago {
    private int codigo;
    private String descripcion;
    private ArrayList<Cliente> clientes;
    private ArrayList<Pedido> pedidos;

    public MetodoPago(int id, String descripcion) {
        setCodigo(id);
        setDescripcion(descripcion);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int id) {
        if (id <= 0) throw new IllegalArgumentException("El ID debe ser un número positivo.");
        this.codigo = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion == null || descripcion.trim().isEmpty()) throw new IllegalArgumentException("La descripción no puede estar vacía.");
        this.descripcion = descripcion;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MetodoPago that = (MetodoPago) o;
        return codigo == that.codigo && Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, descripcion);
    }

    @Override
    public String toString() {
        return "Metodo de Pago:\n" +
                "- ID: " + codigo + "\n" +
                "- Descripción: " + descripcion;
    }
}