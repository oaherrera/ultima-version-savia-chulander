package com.conexia.qa.savia.colecciones;

import com.conexia.qa.savia.modelos.Procedimiento;

import java.util.ArrayList;
import java.util.List;

public class Procedimientos {
    private static Procedimientos procedimientosCollection;
    private static List<Procedimiento> procedimientos;

    public static Procedimientos traerProcedimientos() {
        if (procedimientosCollection == null) {
            procedimientosCollection = new Procedimientos();
            procedimientos = new ArrayList<Procedimiento>();
        }
        return procedimientosCollection;
    }

    public Procedimiento traerProcedimiento(int indice) {
        return procedimientos.get(indice);
    }

    public void guardarProcedimiento(Procedimiento procedimiento) {
        procedimientos.add(procedimiento);
    }

    public int cantidadProcedimientos() {
        return procedimientos.size();
    }

    public void limpiarProcedimientos() {
        procedimientos = new ArrayList<Procedimiento>();
    }

    public void guardarProcedimientos(List<Procedimiento> procedimientos) {
        int indice = 0;
        while (indice < procedimientos.size()) {
            guardarProcedimiento(procedimientos.get(indice));
            indice = indice + 1;
        }
    }
}
