package com.iescamp;

import java.util.ArrayList;
import java.util.Objects;

public class Material {
    private int codigo;
    private String denominacion;
    private ArrayList<Articulo> articulos;

    public Material(int id, String denominacion) {
        this.setCodigo(id);
        this.setDenominacion(denominacion);
        this.articulos = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        if (codigo <= 0) {
            throw new IllegalArgumentException("El ID debe ser un número positivo.");
        }
        this.codigo = codigo;
    }

    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(ArrayList<Articulo> articulos) {
        this.articulos = articulos;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        if (denominacion == null || denominacion.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede estar vacía.");
        }
        this.denominacion = denominacion;
    }

    @Override
    public String toString() {
        return "- Material -\n" +
                "\tID          : " + codigo + "\n" +
                "\tDescripción : " + denominacion + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Material material = (Material) o;
        return codigo == material.codigo && Objects.equals(denominacion, material.denominacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, denominacion);
    }
}

