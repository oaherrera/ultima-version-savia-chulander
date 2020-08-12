package com.conexia.qa.sql.colecciones;

import com.conexia.qa.savia.modelos.Insumo;

import java.util.ArrayList;
import java.util.List;

public class InsumosBD {
    private static InsumosBD insumosCollection;
    private static List<Insumo> insumos;

    public static InsumosBD traerInsumos(){
        if(insumos== null){
            insumosCollection = new InsumosBD();
            insumos = new ArrayList<Insumo>();
        }
        return insumosCollection;
    }

    public  void agregarInsumo(Insumo insumo) {
        insumos.add(insumo);
    }

    public Insumo traerInsumo(int indice){
        return insumos.get(indice);
    }

    public int cantidadInsumos() {
        return insumos.size();
    }

    public void borrarInsumos(){
        insumos = new ArrayList<Insumo>();
    }

}
