package com.iescamp;

import java.util.ArrayList;
import java.util.Objects;

public class Chaqueta extends Ropa {

    private boolean impermeable;
    private ArrayList<LineaPedido> lineasPedidos;

    public Chaqueta(int cod_art,
                    String nombre,
                    float precio,
                    String marca,
                    String descripcion,
                    String imagen,
                    String color,
                    boolean activo,
                    Material material,
                    String talla_ropa,
                    String tipo_cierre,
                    TipoRopa tipoRopa,
                    boolean impermeable) {
        super(cod_art, nombre, precio, marca, descripcion, imagen, color,
                activo, material, talla_ropa, tipo_cierre, tipoRopa);
        setImpermeable(impermeable);
    }

    public boolean isImpermeable() {
        return impermeable;
    }

    public void setImpermeable(boolean impermeable) {
        this.impermeable = impermeable;
    }

    public ArrayList<LineaPedido> getLineasPedidos() {
        return lineasPedidos;
    }

    public void setLineasPedidos(ArrayList<LineaPedido> lineasPedidos) {
        this.lineasPedidos = lineasPedidos;
    }

    @Override
    public String toString() {
        return "Chaqueta:\n" +
                "- Código: " + getCod_art() + "\n" +
                "- Nombre: " + getNombre() + "\n" +
                "- Precio: " + getPrecio() + " €\n" +
                "- Marca: " + getMarca() + "\n" +
                "- Descripción: " + getDescripcion() + "\n" +
                "- Imagen: " + getImagen() + "\n" +
                "- Color: " + getColor() + "\n" +
                "- Activo: " + (isActivo() ? "Sí" : "No") + "\n" +
                "- Talla: " + getTalla_ropa() + "\n" +
                "- Color: " + getColor() + "\n" +
                "- Tipo de Cierre: " + getTipo_cierre() + "\n" +
                "- Impermeable: " + (isImpermeable() ? "Sí" : "No") + "\n";
    }

    public void mostrarDetalles() {
        System.out.println(getNombre() + " es una chaqueta " + (isImpermeable() ? "impermeable" : "no impermeable") + ".");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Chaqueta chaqueta = (Chaqueta) o;
        return impermeable == chaqueta.impermeable;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), impermeable);
    }
}
