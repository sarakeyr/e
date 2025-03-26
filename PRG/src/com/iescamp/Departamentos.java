package com.iescamp;

import java.util.ArrayList;
import java.util.Iterator;

public class Departamentos {

    ArrayList<Departamento> ldepartamento;

    public Departamentos(){
        ldepartamento = new ArrayList<>();

    }

    public Departamentos(ArrayList<Departamento> ldepartamento) {
        this.ldepartamento = ldepartamento;
    }

    public ArrayList<Departamento> getLdepartamento() {
        return ldepartamento;
    }

    public void setLdepartamento(ArrayList<Departamento> ldepartamento) {
        this.ldepartamento = ldepartamento;
    }

    public Departamento getDepartamento(int id){
        for (Departamento departamento : ldepartamento){
            if (departamento.getCodigo() == id) {
                return departamento;
            }
        }
        return null;
    }


    //CRUD
    public boolean updateDepartamento(Departamento nuevo){
        Departamento existente = getDepartamento(nuevo.getCodigo());
        if (existente != null){
            existente.setNombre(nuevo.getNombre());
            return true;
        }
        System.out.println("Departamento encontrado");
        return false;
    }

    public boolean addDepartamento(Departamento nuevo){
        Departamento existente = getDepartamento(nuevo.getCodigo());
        if(existente != null){
            existente.setNombre(nuevo.getNombre());
            return true;
        }else{
            System.out.println("Departamento encontrado");
            return false;
        }
    }

    public boolean deleteDepartamento(int id){

        boolean encontrado = false;

        Iterator<Departamento> iterator =ldepartamento.iterator();

        while (iterator.hasNext()){
            Departamento departamento = iterator.next();
            if (departamento.getCodigo()==id){
                iterator.remove();
                encontrado=true;
                break;
            }
        }
        if (!encontrado){
            System.out.println("No encontrado");
        }
        return  encontrado;
    }
}