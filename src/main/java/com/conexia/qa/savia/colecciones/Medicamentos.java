package com.conexia.qa.savia.colecciones;

import com.conexia.qa.savia.modelos.Medicamento;

import java.util.ArrayList;
import java.util.List;

public class Medicamentos {
    private static Medicamentos medicamentosCollection;
    private static List<Medicamento> medicamentos;

    public static Medicamentos traerMedicamentos() {
        if (medicamentosCollection == null) {
            medicamentosCollection = new Medicamentos();
            medicamentos = new ArrayList<Medicamento>();
        }
        return medicamentosCollection;
    }

    public void agregarMedicamento(Medicamento medicamento) {
        medicamentos.add(medicamento);
    }

    public Medicamento traerMedicamento(int indice) {
        return medicamentos.get(indice);
    }

    public void borrarMedicamentos() {
        medicamentos = new ArrayList<Medicamento>();
    }

    public int cantidadMedicamentos() {
        return medicamentos.size();
    }

    public void agregarMedicamentos(List<Medicamento> medicamentosData) {
        int indice = 0;
        while (indice < medicamentosData.size()) {
            agregarMedicamento(medicamentosData.get(indice));
            indice = indice + 1;
        }
    }
}
