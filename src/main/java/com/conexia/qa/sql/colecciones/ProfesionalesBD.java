package com.conexia.qa.sql.colecciones;

import com.conexia.qa.savia.modelos.Profesional;

import java.util.ArrayList;
import java.util.List;

public class ProfesionalesBD {
    private static List<Profesional> profesionales;
    private static ProfesionalesBD ProfesionalesCollection;

    public static ProfesionalesBD traerProfesionales() {
        if (ProfesionalesCollection == null) {
            ProfesionalesCollection = new ProfesionalesBD();
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

    public void guardarProfesionale(Profesional profesional) {
        profesionales.add(profesional);
    }

    public void borrarProfesionales() {
        profesionales = new ArrayList<Profesional>();
    }

}
