package com.iescamp;

import java.util.Date;
import java.util.ArrayList;


public class Pedido {
    private int numero;
    private Date fecha;
    private EstadoPedido estado;
    private String dir_envio;
    private ArrayList<LineaPedido> lineasPedido;
    private Cliente DNI_cliente;
    private MetodoPago m_pago;

    public Pedido(int numero,
                  Date fecha,
                  EstadoPedido estado,
                  String dir_envio,
                  Cliente DNI_cliente) {
        this.numero = numero;
        this.fecha = fecha;
        setEstado(estado);  // Usa el setter con validación
        this.dir_envio = dir_envio;
        this.DNI_cliente = DNI_cliente;
        this.lineasPedido = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        if (estado == null) {
            throw new IllegalArgumentException("El estado no puede ser nulo.");
        }
        this.estado = estado;
    }

    public String getDir_envio() {
        return dir_envio;
    }

    public Cliente getDNI_cliente() {
        return DNI_cliente;
    }

    public void agregarLineaPedido(LineaPedido linea) {
        this.lineasPedido.add(linea);
    }

    public ArrayList<LineaPedido> getLineasPedido() {
        return lineasPedido;
    }

    public void mostrarPedido() {
        System.out.println("Número de pedido: " + getNumero());
        System.out.println("Fecha de pedido: " + getFecha());
        System.out.println("Estado: " + getEstado().getDescripcion());
        System.out.println("Dirección de entrega: " + getDir_envio());
        System.out.println("Cliente: " + DNI_cliente.getNombre() + " " + DNI_cliente.getApellidos());

        System.out.println("Detalles de las líneas de pedido:");
        for (LineaPedido linea : lineasPedido) {
            linea.mostrarDetalles();
        }
    }
}
