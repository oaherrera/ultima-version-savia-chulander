package com.conexia.qa.savia.modelos;

public class Paquete {

    private String tipologiaPaquete;
    private String codigoPaquete;
    private String descripcionPaquete;
    private String codigoDiagnostico;
    private String duracionTratamientoPaquete;
    private String indicacionesPaquete;

    public Paquete nuevoPaquete() {
        return new Paquete();
    }

    public String getTipologiaPaquete() {
        return tipologiaPaquete;
    }

    public void setTipologiaPaquete(String tipologiaPaquete) {
        this.tipologiaPaquete = tipologiaPaquete;
    }

    public String getCodigoPaquete() {
        return codigoPaquete;
    }

    public void setCodigoPaquete(String codigoPaquete) {
        this.codigoPaquete = codigoPaquete;
    }

    public String getDescripcionPaquete() {
        return descripcionPaquete;
    }

    public void setDescripcionPaquete(String descripcionPaquete) {
        this.descripcionPaquete = descripcionPaquete;
    }

    public String getCodigoDiagnostico() {
        return codigoDiagnostico;
    }

    public void setCodigoDiagnostico(String codigoDiagnostico) {
        this.codigoDiagnostico = codigoDiagnostico;
    }

    public String getDuracionTratamientoPaquete() {
        return duracionTratamientoPaquete;
    }

    public void setDuracionTratamientoPaquete(String duracionTratamientoPaquete) {
        this.duracionTratamientoPaquete = duracionTratamientoPaquete;
    }

    public String getIndicacionesPaquete() {
        return indicacionesPaquete;
    }

    public void setIndicacionesPaquete(String indicacionesPaquete) {
        this.indicacionesPaquete = indicacionesPaquete;
    }
}
