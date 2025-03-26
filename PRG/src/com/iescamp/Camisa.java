package com.iescamp;

import java.util.ArrayList;
import java.util.Objects;

public class Camisa extends Ropa {

    private String tipo_manga;
    private boolean estampada;
    private ArrayList<LineaPedido> lineasPedidos;

    public Camisa(int cod_art,
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
                  String tipo_manga,
                  boolean estampada,
                  TipoRopa tipoRopa) {
        super(cod_art, nombre, precio, marca, descripcion,
                imagen, color, activo, material, talla_ropa, tipo_cierre, tipoRopa);
        setTipo_manga(tipo_manga);
        setEstampada(estampada);
    }

    public String getTipo_manga() {
        return tipo_manga;
    }

    public void setTipo_manga(String tipo_manga) {
        if (tipo_manga == null || tipo_manga.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de manga no puede ser nulo o vacío");
        }
        this.tipo_manga = tipo_manga;
    }

    public ArrayList<LineaPedido> getLineasPedidos() {
        return lineasPedidos;
    }

    public void setLineasPedidos(ArrayList<LineaPedido> lineasPedidos) {
        this.lineasPedidos = lineasPedidos;
    }

    public boolean isEstampada() {
        return estampada;
    }

    public void setEstampada(boolean estampada) {
        this.estampada = estampada;
    }

    @Override
    public String toString() {
        return "- Camisa -\n" +
                "\tCódigo       : " + getCod_art() + "\n" +
                "\tNombre       : " + getNombre() + "\n" +
                "\tPrecio       : " + getPrecio() + " €\n" +
                "\tMarca        : " + getMarca() + "\n" +
                "\tDescripción  : " + getDescripcion() + "\n" +
                "\tImagen       : " + getImagen() + "\n" +
                "\tColor       : " + getColor() + "\n" +
                "\tActivo       : " + (isActivo() ? "Sí" : "No") + "\n" +
                "\tMaterial        : " + getMaterial() + "\n" +
                "\tTalla        : " + getTalla_ropa() + "\n" +
                "\tTipo Cierre  : " + getTipo_cierre() + "\n" +
                "\tColor        : " + getColor() + "\n" +
                "\tTipo Manga   : " + tipo_manga + "\n" +
                "\tEstampado    : " + (estampada ? "Sí" : "No") + "\n";
    }

    public void mostrarDetalles() {
        String mensaje = getNombre() + " tiene un tipo de manga " + tipo_manga + ". ";
        mensaje += estampada ? "¡Es estampada!" : "No es estampada.";
        System.out.println(mensaje);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Camisa camisa = (Camisa) o;
        return estampada == camisa.estampada &&
                tipo_manga.equals(camisa.tipo_manga) &&
                Objects.equals(getCod_art(), camisa.getCod_art()) &&
                Objects.equals(getNombre(), camisa.getNombre()) &&
                Objects.equals(getMarca(), camisa.getMarca()) &&
                Objects.equals(getDescripcion(), camisa.getDescripcion()) &&
                Objects.equals(getImagen(), camisa.getImagen()) &&
                Objects.equals(getColor(), camisa.getColor()) &&
                getTalla_ropa() == camisa.getTalla_ropa() &&
                getTipo_cierre().equals(camisa.getTipo_cierre()) &&
                getColor().equals(camisa.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCod_art(), getNombre(), getPrecio(), getMarca(), getDescripcion(), getImagen(), isActivo(), getTalla_ropa(), getTipo_cierre(), getColor(), tipo_manga, estampada);
    }
}

