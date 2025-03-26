package com.iescamp;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Accesorio extends Articulo {
    private String estilo;
    private boolean personalizado;
    private Material material;
    private TipoAccesorio tipoAccesorio;
    private ArrayList<LineaPedido> lineasPedidos;

    public Accesorio(int cod_art,
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
                     TipoAccesorio tipoAccesorio) {
        super(cod_art, nombre, precio, marca, descripcion, imagen, color, activo, material);
        setEstilo(estilo);
        setTipoAccesorio(tipoAccesorio);
        setPersonalizado(personalizado);

    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        if (estilo == null || estilo.trim().isEmpty()) {
            throw new IllegalArgumentException("El estilo no puede estar vacío.");
        }
        this.estilo = estilo;
    }

    public TipoAccesorio getTipoAccesorio() {
        return tipoAccesorio;
    }

    public void setTipoAccesorio(TipoAccesorio tipoAccesorio) {
        this.tipoAccesorio = tipoAccesorio;
    }

    public ArrayList<LineaPedido> getLineasPedidos() {
        return lineasPedidos;
    }

    public void setLineasPedidos(ArrayList<LineaPedido> lineasPedidos) {
        this.lineasPedidos = lineasPedidos;
    }

    public Material getMaterial() { return material; }
    public void setMaterial(Material material) {
        if (material == null) {
            throw new IllegalArgumentException("El material no puede ser nulo.");
        }
        this.material = material;
    }

    public boolean isPersonalizado() {
        return personalizado;
    }

    public void setPersonalizado(boolean personalizado) {
        this.personalizado = personalizado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Accesorio accesorio = (Accesorio) o;
        return personalizado == accesorio.personalizado && Objects.equals(estilo, accesorio.estilo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), estilo, personalizado);
    }

    @Override
    public String toString() {
        return "- com.iescamp.Accesorio -\n" +
                "\tCódigo       : " + getCod_art() + "\n" +
                "\tNombre       : " + getNombre() + "\n" +
                "\tPrecio       : " + getPrecio() + "\n" +
                "\tMarca        : " + getMarca() + "\n" +
                "\tDescripción  : " + getDescripcion() + "\n" +
                "\tImagen       : " + getImagen() + "\n" +
                "\tColor       : " + getColor() + "\n" +
                "\tActivo       : " + isActivo() + "\n" +
                "\tEstilo       : " + estilo + "\n" +
                "\tPersonalizado: " + (personalizado ? "Sí" : "No") + "\n";
    }
}

