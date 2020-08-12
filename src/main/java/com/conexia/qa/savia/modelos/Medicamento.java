package com.conexia.qa.savia.modelos;

public class Medicamento {

    private String tipologiaMedicamento;
    private String codigoMedicamento;
    private String descripcionMedicamento;
    private String codigoDiagnostico;
    private String causaExternaMedicamento;
    private String finalidadMedicamento;
    private String tipoCatastroficoMedicamento;
    private String dosisMedicamento;
    private String frecuenciaMedicamento;
    private String frecuenciaTipoMedicamento;
    private String viaDeAdministracionMedicamento;
    private String duracionTratamientoMedicamento;
    private String posologiaMedicamento;
    private String principoActivo;
    private String concentracion;
    private String formaFarmaceutica;

    public static Medicamento nuevoMedicamento() {
        return new Medicamento();
    }

    public String getTipologiaMedicamento() {
        return tipologiaMedicamento;
    }

    public void setTipologiaMedicamento(String tipologiaMedicamento) {
        this.tipologiaMedicamento = tipologiaMedicamento;
    }

    public String getCodigoMedicamento() {
        return codigoMedicamento;
    }

    public void setCodigoMedicamento(String codigoMedicamento) {
        this.codigoMedicamento = codigoMedicamento;
    }

    public String getDescripcionMedicamento() {
        return descripcionMedicamento;
    }

    public void setDescripcionMedicamento(String descripcionMedicamento) {
        this.descripcionMedicamento = descripcionMedicamento;
    }

    public String getCodigoDiagnostico() {
        return codigoDiagnostico;
    }

    public void setCodigoDiagnostico(String codigoDiagnostico) {
        this.codigoDiagnostico = codigoDiagnostico;
    }

    public String getCausaExternaMedicamento() {
        return causaExternaMedicamento;
    }

    public void setCausaExternaMedicamento(String causaExternaMedicamento) {
        this.causaExternaMedicamento = causaExternaMedicamento;
    }

    public String getFinalidadMedicamento() {
        return finalidadMedicamento;
    }

    public void setFinalidadMedicamento(String finalidadMedicamento) {
        this.finalidadMedicamento = finalidadMedicamento;
    }

    public String getTipoCatastroficoMedicamento() {
        return tipoCatastroficoMedicamento;
    }

    public void setTipoCatastroficoMedicamento(String tipoCatastroficoMedicamento) {
        this.tipoCatastroficoMedicamento = tipoCatastroficoMedicamento;
    }

    public String getDosisMedicamento() {
        return dosisMedicamento;
    }

    public void setDosisMedicamento(String dosisMedicamento) {
        this.dosisMedicamento = dosisMedicamento;
    }

    public String getFrecuenciaMedicamento() {
        return frecuenciaMedicamento;
    }

    public void setFrecuenciaMedicamento(String frecuenciaMedicamento) {
        this.frecuenciaMedicamento = frecuenciaMedicamento;
    }

    public String getFrecuenciaTipoMedicamento() {
        return frecuenciaTipoMedicamento;
    }

    public void setFrecuenciaTipoMedicamento(String frecuenciaTipoMedicamento) {
        this.frecuenciaTipoMedicamento = frecuenciaTipoMedicamento;
    }

    public String getViaDeAdministracionMedicamento() {
        return viaDeAdministracionMedicamento;
    }

    public void setViaDeAdministracionMedicamento(String viaDeAdministracionMedicamento) {
        this.viaDeAdministracionMedicamento = viaDeAdministracionMedicamento;
    }

    public String getDuracionTratamientoMedicamento() {
        return duracionTratamientoMedicamento;
    }

    public void setDuracionTratamientoMedicamento(String duracionTratamientoMedicamento) {
        this.duracionTratamientoMedicamento = duracionTratamientoMedicamento;
    }

    public String getPosologiaMedicamento() {
        return posologiaMedicamento;
    }

    public void setPosologiaMedicamento(String posologiaMedicamento) {
        this.posologiaMedicamento = posologiaMedicamento;
    }

    public String getPrincipoActivo() {
        return principoActivo;
    }

    public void setPrincipoActivo(String principoActivo) {
        this.principoActivo = principoActivo;
    }

    public String getConcentracion() {
        return concentracion;
    }

    public void setConcentracion(String concentracion) {
        this.concentracion = concentracion;
    }

    public String getFormaFarmaceutica() {
        return formaFarmaceutica;
    }

    public void setFormaFarmaceutica(String formaFarmaceutica) {
        this.formaFarmaceutica = formaFarmaceutica;
    }
}
