package com.conexia.qa.savia.colecciones;

import com.conexia.qa.savia.modelos.Diagnostico;

import javax.tools.DiagnosticCollector;
import java.util.ArrayList;
import java.util.List;

public class Diagnosticos {
    private static Diagnosticos diagnosticosColeccion;
    private static List<Diagnostico> diagnosticos;

    public static Diagnosticos traerDiagnosticos(){
        if(diagnosticosColeccion==null){
            diagnosticosColeccion = new Diagnosticos();
            diagnosticos = new ArrayList<Diagnostico>();
        }
        return diagnosticosColeccion;
    }

    public void agregarDiagnostico(Diagnostico diagnostico){
        diagnosticos.add(diagnostico);
    }
    public Diagnostico traerDiagnostico(int indice){
        return diagnosticos.get(indice);
    }

    public void bobrrarDiagnosticos(){
        diagnosticos = new ArrayList<Diagnostico>();
    }
}
