package com.conexia.qa.savia.modelos;

public class SolicitudAuditorBandeja {
    private String descripcionTecnologia;
    private String estado;
    private String cantidadSolicitada;
    private String bandejaSolicitud;
    private String auditorResponsable;
    private String motivo;

    public static SolicitudAuditorBandeja nuevo(){
        return new SolicitudAuditorBandeja();
    }

    public String getDescripcionTecnologia() {
        return descripcionTecnologia;
    }

    public void setDescripcionTecnologia(String descripcionTecnologia) {
        this.descripcionTecnologia = descripcionTecnologia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCantidadSolicitada() {
        return cantidadSolicitada;
    }

    public void setCantidadSolicitada(String cantidadSolicitada) {
        this.cantidadSolicitada = cantidadSolicitada;
    }

    public String getBandejaSolicitud() {
        return bandejaSolicitud;
    }

    public void setBandejaSolicitud(String bandejaSolicitud) {
        this.bandejaSolicitud = bandejaSolicitud;
    }

    public String getAuditorResponsable() {
        return auditorResponsable;
    }

    public void setAuditorResponsable(String auditorResponsable) {
        this.auditorResponsable = auditorResponsable;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
