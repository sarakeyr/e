package com.iescamp;

import java.util.ArrayList;
import java.util.Objects;

public class Bolso extends Accesorio {

    private String cierre_bolso;
    private int capacidad;
    private ArrayList<LineaPedido> lineasPedidos;

    public Bolso(int cod_art,
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
                 String cierre_bolso,
                 int capacidad,
                 TipoAccesorio tipoAccesorio) {
        super(cod_art, nombre, precio, marca, descripcion, imagen, color, activo, estilo, material, esPersonalizado, TipoAccesorio.BOLSO);
        setCierre_bolso(cierre_bolso); // Validación en el setter
        setCapacidad(capacidad); // Validación en el setter
    }

    public String getCierre_bolso() {
        return cierre_bolso;
    }

    public void setCierre_bolso(String cierre_bolso) {
        if (cierre_bolso == null || cierre_bolso.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de cierre no puede ser nulo o vacío.");
        }
        this.cierre_bolso = cierre_bolso;
    }

    public ArrayList<LineaPedido> getLineasPedidos() {
        return lineasPedidos;
    }

    public void setLineasPedidos(ArrayList<LineaPedido> lineasPedidos) {
        this.lineasPedidos = lineasPedidos;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser un número positivo.");
        }
        this.capacidad = capacidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bolso bolso = (Bolso) o;
        return capacidad == bolso.capacidad &&
                cierre_bolso.equals(bolso.cierre_bolso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cierre_bolso, capacidad);
    }

    @Override
    public String toString() {
        return "- Bolso -\n" +
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
                "\tTipo Cierre  : " + cierre_bolso + "\n" +
                "\tCapacidad    : " + capacidad + " litros\n";
    }

    public void mostrarDetalles() {
        System.out.println(getNombre() + " tiene un cierre tipo " + cierre_bolso + " y una capacidad de " + capacidad + " litros.");
    }
}