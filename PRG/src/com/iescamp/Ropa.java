package com.iescamp;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Ropa extends Articulo {

    private TipoRopa tipo_ropa;
    private Material material;
    private ArrayList<LineaPedido> lineasPedidos;
    private String talla_ropa;
    private String tipo_cierre;

    public Ropa(int cod_art, String nombre, float precio, String marca, String descripcion, String imagen, String color, boolean activo, Material material, String talla_ropa, String tipoCierre, TipoRopa tipoRopa) {
        super(cod_art, nombre, precio, marca, descripcion, imagen, color, activo, material);
        setMaterial(material);
        setTipo_ropa(tipoRopa);
        setTalla_ropa(talla_ropa);
        setTipo_cierre(tipoCierre);
        setColor(color);
    }

    public String getTalla_ropa() {
        return talla_ropa;
    }

    public void setTalla_ropa(String talla_ropa) {
        if (talla_ropa == null) throw new IllegalArgumentException("La talla_ropa debe ser válida.");
        this.talla_ropa = talla_ropa;
    }

    public Material getMaterial() { return material; }
    public void setMaterial(Material material) {
        if (material == null) {
            throw new IllegalArgumentException("El material no puede ser nulo.");
        }
        this.material = material;
    }

    public TipoRopa getTipo_ropa() { return tipo_ropa; }
    public void setTipo_ropa(TipoRopa tipo_ropa) {
        if (tipo_ropa == null) {
            throw new IllegalArgumentException("El tipo de ropa no puede ser nulo.");
        }
        this.tipo_ropa = tipo_ropa;
    }

    public ArrayList<LineaPedido> getLineasPedidos() {
        return lineasPedidos;
    }

    public void setLineasPedidos(ArrayList<LineaPedido> lineasPedidos) {
        this.lineasPedidos = lineasPedidos;
    }

    public String getTipo_cierre() {
        return tipo_cierre;
    }

    public void setTipo_cierre(String tipo_cierre) {
        if (tipo_cierre == null || tipo_cierre.trim().isEmpty()) throw new IllegalArgumentException("El tipo de cierre no puede estar vacío.");
        this.tipo_cierre = tipo_cierre;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Ropa ropa = (Ropa) o;
        return talla_ropa.equals(ropa.talla_ropa) && Objects.equals(tipo_cierre, ropa.tipo_cierre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), talla_ropa, tipo_cierre, tipo_ropa);
    }

    @Override
    public String toString() {
        return "Ropa:\n" +
                "- Tipo : " + tipo_ropa + "\n" +
                "- Talla: " + talla_ropa + "\n" +
                "- Color: " + getColor() + "\n" +
                "- Tipo de cierre: " + tipo_cierre;
    }
}