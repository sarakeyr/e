package com.iescamp;

import java.util.ArrayList;
import java.util.Objects;

public class Zapato extends Accesorio {

    private int talla_zapatos;
    private String tipo_suela;
    private ArrayList<LineaPedido> lineasPedidos;


    public Zapato(int cod_art,
                  String nombre,
                  float precio,
                  String marca,
                  String descripcion,
                  String imagen,
                  String color,
                  boolean activo,
                  String estilo,
                  Material material,
                  boolean personalizado,
                  int talla_zapatos,
                  String tipo_suela,
                  TipoAccesorio tipoAccesorio) {
        super(cod_art,
                nombre, precio, marca, descripcion, imagen, color, activo, estilo, material, personalizado, TipoAccesorio.ZAPATOS);
        setTalla_zapatos(talla_zapatos);
        setTipo_suela(tipo_suela);
    }

    public int getTalla_zapatos() {
        return talla_zapatos;
    }

    public void setTalla_zapatos(int talla_zapatos) {
        try {
            int talla = talla_zapatos;
            if (talla <= 0) {
                throw new IllegalArgumentException("La talla de los zapatos debe ser un número positivo.");
            }
            this.talla_zapatos = talla_zapatos;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("La talla de los zapatos debe ser un número válido.");
        }
    }

    public String getTipo_suela() {
        return tipo_suela;
    }

    public void setTipo_suela(String tipo_suela) {
        if (tipo_suela == null || tipo_suela.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de suela no puede ser nulo o vacío.");
        }
        this.tipo_suela = tipo_suela;
    }

    public ArrayList<LineaPedido> getLineasPedidos() {
        return lineasPedidos;
    }

    public void setLineasPedidos(ArrayList<LineaPedido> lineasPedidos) {
        this.lineasPedidos = lineasPedidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Zapato zapatos = (Zapato) o;
        return talla_zapatos == zapatos.talla_zapatos &&
                tipo_suela.equals(zapatos.tipo_suela);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), talla_zapatos, tipo_suela);
    }

    @Override
    public String toString() {
        return "- Zapato -\n" +
                "\tCódigo       : " + getCod_art() + "\n" +
                "\tNombre       : " + getNombre() + "\n" +
                "\tPrecio       : " + getPrecio() + " €\n" +
                "\tMarca        : " + getMarca() + "\n" +
                "\tDescripción  : " + getDescripcion() + "\n" +
                "\tImagen       : " + getImagen() + "\n" +
                "\tColor       : " + getColor() + "\n" +
                "\tActivo       : " + (isActivo() ? "Sí" : "No") + "\n" +
                "\tEstilo       : " + getEstilo() + "\n" +
                "\tPersonalizado : " + (isPersonalizado() ? "Sí" : "No") + "\n" +
                "\tTalla        : " + talla_zapatos + "\n" +
                "\tTipo Suela   : " + tipo_suela + "\n";
    }

    public void mostrarDetalles() {
        System.out.println(getNombre() + " tiene una talla de " + talla_zapatos + " y una suela de tipo " + tipo_suela + ".");
    }
}
