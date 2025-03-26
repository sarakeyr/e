package com.iescamp;

import java.util.ArrayList;

public class Ventas {
    private ArrayList<Pedido> pedidos = new ArrayList<>();

    // CRUD
    public void crear(Pedido pedido) {
        if (buscarPorCodigo(pedido.getNumero()) != null) {
            throw new IllegalArgumentException("Pedido duplicado");
        }
        pedidos.add(pedido);
    }

    public Pedido leer(int index) {
        return (index >= 0 && index < pedidos.size()) ? pedidos.get(index) : null;
    }

    public boolean actualizar(Pedido pedido) {
        for (int i = 0; i < pedidos.size(); i++) {
            if (pedidos.get(i).getNumero() == pedido.getNumero()) {
                pedidos.set(i, pedido);
                return true;
            }
        }
        return false;
    }

    public void eliminarPedido(int index) {
        pedidos.remove(index);
    }

    public boolean borrar(int codigo) {
        return pedidos.removeIf(p -> p.getNumero() == codigo);
    }

    // Búsquedas y Filtrados
    public Pedido buscarPorCodigoPedido(int codigo) {
        for (Pedido pedido : pedidos) {
            if (pedido.getNumero() == codigo) {
                return pedido;
            }
        }
        return null;
    }

    public Pedido buscarPorCodigo(int codigo) {
        return pedidos.stream()
                .filter(p -> p.getNumero() == codigo)
                .findFirst()
                .orElse(null);
    }

    public ArrayList<Pedido> filtrarPorCliente(Cliente cliente) {
        ArrayList<Pedido> resultado = new ArrayList<>();
        for (Pedido p : pedidos) {
            if (p.getDNI_cliente().equals(cliente)) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    public double calcularPrecioVenta(Pedido pedido) {
        double total = 0.0;
        for (LineaPedido linea : pedido.getLineasPedido()) {
            total += linea.getCod_art().getPrecio();
        }
        return total;
    }
}
