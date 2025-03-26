package com.iescamp;

import java.util.ArrayList;
import java.util.Iterator;

public class MetodosPago {

    private ArrayList<MetodoPago> lmetodopago;


    public MetodosPago(){
        lmetodopago = new ArrayList<>();
    }

    public MetodosPago(ArrayList<MetodoPago> lmetodopago) {
        this.lmetodopago = lmetodopago;
    }

    public ArrayList<MetodoPago> getLmetodopago() {
        return lmetodopago;
    }

    public void setLmetodopago(ArrayList<MetodoPago> lmetodopago) {
        this.lmetodopago = lmetodopago;
    }



    public MetodoPago getMetodoPago(int id) {
        for (MetodoPago metodopago : lmetodopago) {
            if (metodopago.getCodigo() == id)
                return metodopago;
        }
        return null;
    }

    public void addMetodoPago(MetodoPago nuevo){
        MetodoPago existente = getMetodoPago(nuevo.getCodigo());
        if (existente == null){
            lmetodopago.add(nuevo);
        }else{
            System.out.println("Metodo de pago duplicado");
        }

    }

    public boolean updateMetodoPago(MetodoPago nuevo){
        MetodoPago existente = getMetodoPago(nuevo.getCodigo());
        if (existente != null){
            existente.setDescripcion(nuevo.getDescripcion());
            return true;
        }
        System.out.println("Metodo de pago encontrado");
        return false;
    }

    public boolean deleteMetodoPago (int id){
        boolean encontrado = false;
        Iterator<MetodoPago> iterator = lmetodopago.iterator();
        while(iterator.hasNext()){
            MetodoPago metodopago = iterator.next();
            if (metodopago.getCodigo()== id){
                iterator.remove();
                encontrado = true;
                break;
            }

        }
        if (!encontrado)
            System.out.println("Metodo de pago no encontrado");
        return encontrado;
    }

}
