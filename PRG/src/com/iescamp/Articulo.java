package com.iescamp;

import java.io.Serializable;
import java.util.Objects;

public abstract class Articulo implements Serializable {
    private static final long serialVersionUID = 1L;
    private int cod_art;
    private String nombre;
    private float precio;
    private String marca;
    private String descripcion;
    private String imagen;
    private String color;
    private boolean activo;
    private Material material;
    //private ArrayList<LineaPedido> lineasPedidos; MEJOR MANEJARLOS EN LA CLASE CATALOGO

    public Articulo(int cod_art, String nombre, float precio, String marca, String descripcion, String imagen, String color, boolean activo, Material material) {
        this.cod_art = cod_art;
        this.setNombre(nombre);
        this.setPrecio(precio);
        this.setMarca(marca);
        this.setDescripcion(descripcion);
        this.setImagen(imagen);
        this.setColor(color);
        setMaterial(material);
        this.setActivo(activo);
    }

  public int getCod_art() { return cod_art; }
    public void setCod_art(int cod_art) {
//        if ( cod_art == null || cod_art.isEmpty()) {
//            throw new IllegalArgumentException("El código de artículo no puede estar vacío");
//        }
        this.cod_art = cod_art;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre;
    }

    public String getColor() { return color; }
    public void setColor(String color) {
        if (color == null || color.isEmpty()) {
            throw new IllegalArgumentException("El color no puede estar vacío");
        }
        this.color = color;
    }

    public Material getMaterial() { return material; }
    public void setMaterial(Material material) {
        if (material == null) {
            throw new IllegalArgumentException("El material no puede ser nulo.");
        }
        this.material = material;
    }

    public float getPrecio() { return precio; }
    public void setPrecio(float precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.precio = precio;
    }

    public String getMarca() { return marca; }
    public void setMarca(String marca) {
        if (marca == null || marca.isEmpty()) {
            throw new IllegalArgumentException("La marca no puede estar vacía");
        }
        this.marca = marca;
    }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) {
        if (descripcion == null || descripcion.isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede estar vacía");
        }
        this.descripcion = descripcion;
    }

    public String getImagen() { return imagen; }
    public void setImagen(String imagen) {
        if (imagen == null || imagen.isEmpty()) {
            throw new IllegalArgumentException("La imagen no puede estar vacía");
        }
        this.imagen = imagen;
    }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Articulo articulo = (Articulo) o;
        return Float.compare(precio, articulo.precio) == 0 &&
                activo == articulo.activo &&
                Objects.equals(cod_art, articulo.cod_art) &&
                Objects.equals(nombre, articulo.nombre) &&
                Objects.equals(marca, articulo.marca) &&
                Objects.equals(descripcion, articulo.descripcion) &&
                Objects.equals(imagen, articulo.imagen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cod_art, nombre, precio, marca, descripcion, imagen, activo);
    }

    @Override
    public String toString() {
        return "- Artículo -\n" +
                "\tCódigo       : " + cod_art + "\n" +
                "\tNombre       : " + nombre + "\n" +
                "\tPrecio       : " + precio + " €\n" +
                "\tMarca        : " + marca + "\n" +
                "\tDescripción  : " + descripcion + "\n" +
                "\tImagen       : " + imagen + "\n" +
                "\tActivo       : " + (activo ? "Sí" : "No") + "\n";
    }
}

