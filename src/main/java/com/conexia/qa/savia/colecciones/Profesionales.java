package com.conexia.qa.savia.colecciones;

import com.conexia.qa.savia.modelos.Profesional;

import java.util.ArrayList;
import java.util.List;

public class Profesionales {
    private static List<Profesional> profesionales;
    private static Profesionales ProfesionalesCollection;

    public static Profesionales traerProfesionales(){
        if(ProfesionalesCollection== null){
            ProfesionalesCollection = new Profesionales();
            profesionales = new ArrayList<Profesional>();
        }
        return ProfesionalesCollection;
    }

    public List<Profesional> Profesionales() {
        return profesionales;
    }

    public Profesional traerProfesional(int indice) {
        return profesionales.get(indice);
    }

    public void guardarProfesionales(Profesional profesional) {profesionales.add(profesional);}

    public void borrarProfesionales() {
        profesionales = new ArrayList<Profesional>();
    }

}
