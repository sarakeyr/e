package com.iescamp;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Cliente extends Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    private String dir_envio;
    private float saldo_cuenta;
    private boolean tarjeta_fidelizacion;
    private int num_pedidos;
    private MetodoPago m_pago;
    private ArrayList<Pedido> pedidos;

    public Cliente(String dni, String nombre, String apellidos, String direccion, String telefono, String correoElectronico, LocalDate fechaNacimiento, String pass, boolean activo, String dir_envio, float saldo_cuenta, boolean tarjeta_fidelizacion, int num_pedidos, MetodoPago m_pago) {
        super(dni, nombre, apellidos, direccion, telefono, correoElectronico, fechaNacimiento, pass, activo);
        this.setDir_envio(dir_envio);
        this.setSaldo_cuenta(saldo_cuenta);
        this.setTarjeta_fidelizacion(tarjeta_fidelizacion);
        this.setNum_pedidos(num_pedidos);
        this.setM_pago(m_pago);
        this.pedidos = new ArrayList<>();
    }

    public String getDir_envio() { return dir_envio; }
    public void setDir_envio(String dir_envio) {
        if (dir_envio == null || dir_envio.isEmpty()) {
            throw new IllegalArgumentException("La dirección de envío no puede estar vacía");
        }
        this.dir_envio = dir_envio;
    }

    public float getSaldo_cuenta() { return saldo_cuenta; }
    public void setSaldo_cuenta(float saldo_cuenta) {
        if (saldo_cuenta < 0) {
            throw new IllegalArgumentException("El saldo no puede ser negativo");
        }
        this.saldo_cuenta = saldo_cuenta;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        if (pedidos == null) {
            throw new IllegalArgumentException("El pedido no puede ser nulo");
        }
        this.pedidos = pedidos;
    }

    public boolean isTarjeta_fidelizacion() { return tarjeta_fidelizacion; }
    public void setTarjeta_fidelizacion(boolean tarjeta_fidelizacion) {
        this.tarjeta_fidelizacion = tarjeta_fidelizacion;
    }

    public int getNum_pedidos() { return num_pedidos; }
    public void setNum_pedidos(int num_pedidos) {
        if (num_pedidos < 0) {
            throw new IllegalArgumentException("El número de pedidos no puede ser negativo");
        }
        this.num_pedidos = num_pedidos;
    }

    public MetodoPago getM_pago() { return m_pago; }
    public void setM_pago(MetodoPago m_pago) {
        if (m_pago == null) {
            throw new IllegalArgumentException("El método de pago no puede ser nulo");
        }
        this.m_pago = m_pago;
    }

    @Override
    public String toString() {
        return "- Cliente -\n" +
                "\tDirección de Envío : " + dir_envio + "\n" +
                "\tSaldo en Cuenta    : " + saldo_cuenta + "\n" +
                "\tTarjeta Fidelidad  : " + (tarjeta_fidelizacion ? "Sí" : "No") + "\n" +
                "\tPedidos Realizados : " + num_pedidos + "\n" +
                "\tMétodo de Pago     : " + m_pago + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass() || !super.equals(o)) return false;
        Cliente cliente = (Cliente) o;
        return Float.compare(cliente.saldo_cuenta, saldo_cuenta) == 0 &&
                tarjeta_fidelizacion == cliente.tarjeta_fidelizacion &&
                num_pedidos == cliente.num_pedidos &&
                Objects.equals(dir_envio, cliente.dir_envio) &&
                Objects.equals(m_pago, cliente.m_pago);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dir_envio, saldo_cuenta, tarjeta_fidelizacion, num_pedidos, m_pago);
    }
}

