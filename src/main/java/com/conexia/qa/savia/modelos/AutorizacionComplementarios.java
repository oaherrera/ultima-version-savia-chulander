package com.conexia.qa.savia.modelos;

public class AutorizacionComplementarios {
    private String justificacionClinica;
    private String historiaClinica;

    public static AutorizacionComplementarios nuevoAutorizacionComplementarios() {
        return new AutorizacionComplementarios();
    }

    public String getJustificacionClinica() {
        return justificacionClinica;
    }

    public void setJustificacionClinica(String justificacionClinica) {
        this.justificacionClinica = justificacionClinica;
    }

    public String getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(String historiaClinica) {
        this.historiaClinica = historiaClinica;
    }
}
