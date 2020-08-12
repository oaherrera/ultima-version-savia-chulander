package com.conexia.qa.savia.modelos;

public class GrupoServicio {
    private String codigoGrupoServicio;
    private String descripcionGrupoServicio;
    private String codigoServicio;
    private String descripcionServicio;

    public static GrupoServicio nuevoGrupoServicio(){
        return new GrupoServicio();
    }

    public String getCodigoGrupoServicio() {
        return codigoGrupoServicio;
    }

    public void setCodigoGrupoServicio(String codigoGrupoServicio) {
        this.codigoGrupoServicio = codigoGrupoServicio;
    }

    public String getDescripcionGrupoServicio() {
        return descripcionGrupoServicio;
    }

    public void setDescripcionGrupoServicio(String descripcionGrupoServicio) {
        this.descripcionGrupoServicio = descripcionGrupoServicio;
    }

    public String getCodigoServicio() {
        return codigoServicio;
    }

    public void setCodigoServicio(String codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    public String getDescripcionServicio() {
        return descripcionServicio;
    }

    public void setDescripcionServicio(String descripcionServicio) {
        this.descripcionServicio = descripcionServicio;
    }
}
