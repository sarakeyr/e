package com.iescamp;

import java.util.ArrayList;
import java.util.Iterator;

public class Catalogo {
    private ArrayList<Articulo> articulos = new ArrayList<>();

    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(ArrayList<Articulo> articulos) {
        this.articulos = articulos;
    }

    // CRUD
    public void crear(Articulo art) {
        if (buscarPorCodigo(art.getCod_art()) != null) {
            throw new IllegalArgumentException("Código duplicado");
        }
        articulos.add(art);
    }

    public Articulo leer(int index) {
        return (index >= 0 && index < articulos.size()) ? articulos.get(index) : null;
    }

    public Articulo obtenerArticulo(int index) {
        return articulos.get(index);
    }

    public boolean actualizar(Articulo art) {
        for (int i = 0; i < articulos.size(); i++) {
            if (articulos.get(i).getCod_art() == art.getCod_art()) {
                articulos.set(i, art);
                return true;
            }
        }
        return false;
    }

    public void actualizarArticulo(int index, Articulo art) {
        articulos.set(index, art);
    }

    public void eliminarArticulo(int index) {
        articulos.remove(index);
    }

    public boolean borrar(String dni) {
        Iterator<Articulo> it = articulos.iterator();
        while (it.hasNext()) {
            if (it.next().getCod_art().equals(dni)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    // Búsquedas y Filtrados
    public Articulo buscarPorCodigo(String codigo) {
        for (Articulo art : articulos) {
            if (art.getCod_art().equals(codigo)) {
                return art;
            }
        }
        return null;
    }

    public Articulo buscarPorCodigo(int codigo) {
        return articulos.stream()
                .filter(a -> a.getCod_art().equals(String.valueOf(codigo)))
                .findFirst()
                .orElse(null);
    }


    public ArrayList<Articulo> filtrarPorTipo(Class<?> tipo) {
        ArrayList<Articulo> resultado = new ArrayList<>();
        for (Articulo art : articulos) {
            if (tipo.isInstance(art)) {
                resultado.add(art);
            }
        }
        return resultado;
    }

    public ArrayList<Articulo> filtrarPorMaterial(Material material) {
        ArrayList<Articulo> resultado = new ArrayList<>();
        for (Articulo a : articulos) {
            if (a.getMaterial().equals(material)) {
                resultado.add(a);
            }
        }
        return resultado;
    }

    public ArrayList<Articulo> filtrarPorActivacion(boolean activo) {
        ArrayList<Articulo> resultado = new ArrayList<>();
        for (Articulo a : articulos) {
            if (a.isActivo() == activo) {
                resultado.add(a);
            }
        }
        return resultado;
    }

}
