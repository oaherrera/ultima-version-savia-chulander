package com.conexia.qa.savia.modelos;

public class Procedimiento extends GrupoServicio {
    private String tipologiaProcedimiento;
    private String codigoProcedimiento;
    private String descripcionProcedimiento;
    private String complejidadProcedimiento;
    private String generoProcedimiento;
    private String desdeEdadProcedimiento;
    private String hastaEdadProcedimiento;
    private String medidaEdadProcedimiento;
    private String duracionTratamientoProcedimiento;
    private String indicacionesProcedimiento;
    private String valorProcedimiento;
    private String modalidadProcedimiento;


    public static Procedimiento nuevoProcedimiento() {
        return new Procedimiento();
    }

    public String getTipologiaProcedimiento() {
        return tipologiaProcedimiento;
    }

    public void setTipologiaProcedimiento(String tipologiaProcedimiento) {this.tipologiaProcedimiento = tipologiaProcedimiento;}

    public String getCodigoProcedimiento() {
        return codigoProcedimiento;
    }

    public void setCodigoProcedimiento(String codigoProcedimiento) {
        this.codigoProcedimiento = codigoProcedimiento;
    }

    public String getDescripcionProcedimiento() {
        return descripcionProcedimiento;
    }

    public void setDescripcionProcedimiento(String descripcionProcedimiento) {this.descripcionProcedimiento = descripcionProcedimiento;}

    public String getComplejidadProcedimiento() {
        return complejidadProcedimiento;
    }

    public void setComplejidadProcedimiento(String complejidadProcedimiento) {this.complejidadProcedimiento = complejidadProcedimiento;}

    public String getGeneroProcedimiento() {
        return generoProcedimiento;
    }

    public void setGeneroProcedimiento(String generoProcedimiento) {
        this.generoProcedimiento = generoProcedimiento;
    }

    public String getDesdeEdadProcedimiento() {
        return desdeEdadProcedimiento;
    }

    public void setDesdeEdadProcedimiento(String desdeEdadProcedimiento) {this.desdeEdadProcedimiento = desdeEdadProcedimiento; }

    public String getHastaEdadProcedimiento() {
        return hastaEdadProcedimiento;
    }

    public void setHastaEdadProcedimiento(String hastaEdadProcedimiento) {this.hastaEdadProcedimiento = hastaEdadProcedimiento;}

    public String getMedidaEdadProcedimiento() {
        return medidaEdadProcedimiento;
    }

    public void setMedidaEdadProcedimiento(String medidaEdadProcedimiento) {this.medidaEdadProcedimiento = medidaEdadProcedimiento;}

    public String getDuracionTratamientoProcedimiento() {
        return duracionTratamientoProcedimiento;
    }

    public void setDuracionTratamientoProcedimiento(String duracionTratamientoProcedimiento) {this.duracionTratamientoProcedimiento = duracionTratamientoProcedimiento;}

    public String getIndicacionesProcedimiento() {
        return indicacionesProcedimiento;
    }

    public void setIndicacionesProcedimiento(String indicacionesProcedimiento) {this.indicacionesProcedimiento = indicacionesProcedimiento;}

    public String getValorProcedimiento() {return valorProcedimiento;}

    public void setValorProcedimiento(String valorProcedimiento) {this.valorProcedimiento = valorProcedimiento;}

    public String getModalidadProcedimiento() {return modalidadProcedimiento;}

    public void setModalidadProcedimiento(String modalidadProcedimiento) {this.modalidadProcedimiento = modalidadProcedimiento;}
}
