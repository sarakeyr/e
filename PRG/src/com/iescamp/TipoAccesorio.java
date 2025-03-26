package com.iescamp;

public enum TipoAccesorio {
    ZAPATOS("Zapato"),
    BOLSO("Bolso");

    private final String tipo;

    TipoAccesorio(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
