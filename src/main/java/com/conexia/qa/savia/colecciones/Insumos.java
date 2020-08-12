package com.conexia.qa.savia.colecciones;

import com.conexia.qa.savia.modelos.Insumo;

import java.util.ArrayList;
import java.util.List;

public class Insumos {
    private static Insumos insumosCollection;
    private static List<Insumo> insumos;

    public static Insumos traerInsumos() {
        if (insumos == null) {
            insumosCollection = new Insumos();
            insumos = new ArrayList<Insumo>();
        }
        return insumosCollection;
    }

    public void agregarInsumo(Insumo insumo) {
        insumos.add(insumo);
    }

    public Insumo traerInsumo(int indice) {
        return insumos.get(indice);
    }

    public int cantidadInsumos() {
        return insumos.size();
    }

    public void borrarInsumos() {
        insumos = new ArrayList<Insumo>();
    }

    public void agregarInsumos(List<Insumo> insumosData) {
        int indice = 0;
        while (indice < insumosData.size()) {
            insumos.add(insumosData.get(indice));
            indice++;
        }
    }

}
