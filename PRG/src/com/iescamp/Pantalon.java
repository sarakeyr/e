package com.iescamp;

import java.util.ArrayList;
import java.util.Objects;

public class Pantalon extends Ropa {

    private boolean tiene_bolsillo;
    private String tipo_pantalon;
    private ArrayList<LineaPedido> lineasPedidos;


    public Pantalon(int cod_art,
                    String nombre,
                    float precio,
                    String marca,
                    String descripcion,
                    String imagen, String color,
                    boolean activo,
                    Material material,
                    String talla_ropa,
                    String tipo_cierre,
                    TipoRopa tipo_ropa,
                    boolean tiene_bolsillo,
                    String tipo_pantalon) {
        super(cod_art, nombre, precio, marca, descripcion, imagen, color, activo, material, talla_ropa, tipo_cierre, tipo_ropa);
        setTipo_pantalon(tipo_pantalon);
        setTiene_bolsillo(tiene_bolsillo);
    }

    public boolean isTiene_bolsillo() {
        return tiene_bolsillo;
    }

    public void setTiene_bolsillo(boolean tiene_bolsillo) {
        this.tiene_bolsillo = tiene_bolsillo;
    }

    public String getTipo_pantalon() {
        return tipo_pantalon;
    }

    public void setTipo_pantalon(String tipo_pantalon) {
        if (tipo_pantalon == null || tipo_pantalon.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de pantalón no puede ser nulo o vacío");
        }
        this.tipo_pantalon = tipo_pantalon;
    }

    public ArrayList<LineaPedido> getLineasPedidos() {
        return lineasPedidos;
    }

    public void setLineasPedidos(ArrayList<LineaPedido> lineasPedidos) {
        this.lineasPedidos = lineasPedidos;
    }

    @Override
    public String toString() {
        return "- Pantalón -\n" +
                "\tCódigo       : " + getCod_art() + "\n" +
                "\tNombre       : " + getNombre() + "\n" +
                "\tPrecio       : " + getPrecio() + " €\n" +
                "\tMarca        : " + getMarca() + "\n" +
                "\tDescripción  : " + getDescripcion() + "\n" +
                "\tImagen       : " + getImagen() + "\n" +
                "\tColor        : " + getColor() + "\n" +
                "\tActivo       : " + (isActivo() ? "Sí" : "No") + "\n" +
                "\tTalla        : " + getTalla_ropa() + "\n" +
                "\tTipo Cierre  : " + getTipo_cierre() + "\n" +
                "\tColor        : " + getColor() + "\n" +
                "\tTipo Pantalón: " + tipo_pantalon + "\n" +
                "\tBolsillos    : " + (tiene_bolsillo ? "Sí" : "No") + "\n";
    }

    public void mostrarDetalles() {
        String mensaje = "Pantalón: " + getNombre() + ", Tipo: " + tipo_pantalon + ". ";
        mensaje += tiene_bolsillo ? "¡Tiene bolsillos!" : "No tiene bolsillos.";
        System.out.println(mensaje);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pantalon pantalon = (Pantalon) o;
        return tiene_bolsillo == pantalon.tiene_bolsillo &&
                tipo_pantalon.equals(pantalon.tipo_pantalon) &&
                Objects.equals(getCod_art(), pantalon.getCod_art()) &&
                Objects.equals(getNombre(), pantalon.getNombre()) &&
                Objects.equals(getMarca(), pantalon.getMarca()) &&
                Objects.equals(getDescripcion(), pantalon.getDescripcion()) &&
                Objects.equals(getImagen(), pantalon.getImagen()) &&
                Objects.equals(getColor(), pantalon.getColor()) &&
                getTalla_ropa() == pantalon.getTalla_ropa() &&
                getTipo_cierre().equals(pantalon.getTipo_cierre()) &&
                getColor().equals(pantalon.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCod_art(), getNombre(), getPrecio(), getMarca(), getDescripcion(), getImagen(), getColor(), isActivo(), getTalla_ropa(), getTipo_cierre(), getColor(), tipo_pantalon, tiene_bolsillo);
    }
}
