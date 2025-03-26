package com.iescamp;

import java.util.ArrayList;
import java.util.Iterator;

public class Materiales {
    private ArrayList<Material> lmaterial;

    public Materiales(){
        lmaterial= new ArrayList<>();
    }

    public Materiales(ArrayList<Material> lmaterial) {
        this.lmaterial = lmaterial;
    }

    public ArrayList<Material> getLmaterial() {
        return lmaterial;
    }

    public void setLmaterial(ArrayList<Material> lmaterial) {
        this.lmaterial = lmaterial;
    }


    public Material getMaterial(int id){
        for(Material material : lmaterial){
            if(material.getCodigo() == id)
                return material;
        }
        return null;
    }

    public void addMaterial(Material nuevo){
        Material existente = getMaterial(nuevo.getCodigo());
        if (existente == null){
            lmaterial.add(nuevo);
        }else{
            System.out.println("Material duplicado");
        }
    }

    public boolean updateMaterial(Material nuevo){
        Material existente = getMaterial(nuevo.getCodigo());

        if (existente != null){
            existente.setDenominacion(nuevo.getDenominacion());
            return true;
        }
        System.out.println("Material encontrado");
        return false;
    }

    public boolean deleteMaterial(int id){
        boolean encontrado= false;

        Iterator<Material> iterator = lmaterial.iterator();

        while(iterator.hasNext()){
            Material material = iterator.next();
            if (material.getCodigo()==id){
                iterator.remove();
                encontrado = true;
                break;
            }
        }

        if(!encontrado){
            System.out.println("No encontrado");
        }
        return encontrado;
    }

}
