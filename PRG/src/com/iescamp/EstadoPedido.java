package com.iescamp;

public enum EstadoPedido {
    EN_PROCESO("En proceso"),
    COMPLETADO("Completado"),
    CANCELADO("Cancelado");

    private final String descripcion;

    EstadoPedido(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}