package com.conexia.qa.savia.modelos;

public class Insumo {

    private String tipologiaInsumo;
    private String codigoInsumo;
    private String descripcionInsumo;
    private String codigoDiagnostico;
    private String duracionTratamientoInsumo;

    public static Insumo nuevoInsumo() {
        return new Insumo();
    }

    public String getTipologiaInsumo() {
        return tipologiaInsumo;
    }

    public void setTipologiaInsumo(String tipologiaInsumo) {
        this.tipologiaInsumo = tipologiaInsumo;
    }

    public String getCodigoInsumo() {
        return codigoInsumo;
    }

    public void setCodigoInsumo(String codigoInsumo) {
        this.codigoInsumo = codigoInsumo;
    }

    public String getDescripcionInsumo() {
        return descripcionInsumo;
    }

    public void setDescripcionInsumo(String descripcionInsumo) {
        this.descripcionInsumo = descripcionInsumo;
    }

    public String getCodigoDiagnostico() {
        return codigoDiagnostico;
    }

    public void setCodigoDiagnostico(String codigoDiagnostico) {
        this.codigoDiagnostico = codigoDiagnostico;
    }

    public String getDuracionTratamientoInsumo() {
        return duracionTratamientoInsumo;
    }

    public void setDuracionTratamientoInsumo(String duracionTratamientoInsumo) {
        this.duracionTratamientoInsumo = duracionTratamientoInsumo;
    }
}
