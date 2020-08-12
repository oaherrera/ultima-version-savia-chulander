package com.conexia.qa.savia.colecciones;

import com.conexia.qa.savia.modelos.Paquete;

import java.util.ArrayList;
import java.util.List;

public class Paquetes {
    private static Paquetes paquetesCollecion;
    private static List<Paquete> paquetes;

    public static Paquetes traerPaquetes() {
        if (paquetesCollecion == null) {
            paquetesCollecion = new Paquetes();
            paquetes = new ArrayList<Paquete>();
        }
        return paquetesCollecion;
    }

    public void agregarPaquete(Paquete paquete) {
        paquetes.add(paquete);
    }

    public int cantidadPaquetes() {
        return paquetes.size();
    }

    public void borrarPaquetes() {
        paquetes = new ArrayList<Paquete>();
    }

    public Paquete traerPaquete(int indice){
        return paquetes.get(indice);
    }

    public void agregarPaquetes(List<Paquete> paquetesData) {
        for (int indice = 0; indice < paquetesData.size(); indice++) {
            agregarPaquete(paquetesData.get(indice));
        }
    }
}
