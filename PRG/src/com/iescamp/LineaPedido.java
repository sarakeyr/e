package com.iescamp;

import java.util.Objects;

public class LineaPedido {
    private Articulo cod_art;
    private Pedido num_pedido;

    public LineaPedido(Articulo cod_art, Pedido num_pedido) {
        setCod_art(cod_art);
        setNum_pedido(num_pedido);
    }

    public Articulo getCod_art() {
        return cod_art;
    }

    public void setCod_art(Articulo cod_art) {
        if (cod_art == null) {
            throw new IllegalArgumentException("El artículo no puede ser nulo.");
        }
        this.cod_art = cod_art;
    }

    public Pedido getNum_pedido() {
        return num_pedido;
    }

    public void setNum_pedido(Pedido num_pedido) {
        if (num_pedido == null) {
            throw new IllegalArgumentException("El num_pedido no puede ser nulo.");
        }
        this.num_pedido = num_pedido;
    }

    // Método para mostrar los detalles de la línea de num_pedido
    public void mostrarDetalles() {
        System.out.println("Artículo: " + cod_art.getNombre() + " - ID Pedido: " + getNum_pedido().getNumero());
    }

    // Método para mostrar los detalles en un formato similar a los otros objetos
    @Override
    public String toString() {
        return "- Línea de Pedido -\n" +
                "\tArtículo    : " + cod_art.getNombre() + "\n" +
                "\tID Pedido   : " + getNum_pedido().getNumero() + "\n";
    }

    // Métodos equals y hashCode para comparar objetos LineaPedido
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineaPedido that = (LineaPedido) o;
        return Objects.equals(cod_art, that.cod_art) &&
                Objects.equals(num_pedido, that.num_pedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cod_art, num_pedido);
    }
}

