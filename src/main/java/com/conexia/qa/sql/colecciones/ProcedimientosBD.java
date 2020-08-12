package com.conexia.qa.sql.colecciones;

import com.conexia.qa.savia.modelos.Procedimiento;

import java.util.ArrayList;
import java.util.List;

public class ProcedimientosBD {
    private static ProcedimientosBD procedimientosCollection;
    private static List<Procedimiento> procedimientos;

    public static ProcedimientosBD traerProcedimientos(){
        if(procedimientosCollection == null){
            procedimientosCollection = new ProcedimientosBD();
            procedimientos = new ArrayList<Procedimiento>() ;
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
}
