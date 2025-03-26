package com.iescamp;

public enum TipoRopa {
    CHAQUETA("Chaqueta"),
    CAMISA("Camisa"),
    PANTALON("Pantalón");

    private final String tipo;

    TipoRopa(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
