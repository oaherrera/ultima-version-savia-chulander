package com.conexia.qa.sql.colecciones;

import com.conexia.qa.savia.modelos.Medicamento;

import java.util.ArrayList;
import java.util.List;

public class MedicamentosBD {
    private static MedicamentosBD medicamentosCollection;
    private static List<Medicamento> medicamentos;

    public static MedicamentosBD traerMedicamentos(){
        if(medicamentosCollection == null){
            medicamentosCollection = new MedicamentosBD();
            medicamentos =new ArrayList<Medicamento>();
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
}
