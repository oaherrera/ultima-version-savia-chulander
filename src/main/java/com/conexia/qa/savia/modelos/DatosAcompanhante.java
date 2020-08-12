package com.conexia.qa.savia.modelos;

public class DatosAcompanhante {
    private String nombreAcompanhante;
    private String telefonoFijoAcompanhante;
    private String celularAcompanhante;
    private String programa;
    private String servicio;
    private String nroSolicitud;
    private static DatosAcompanhante datosAcompanhante;

    public static DatosAcompanhante trearDatosAcompanhante() {
        if (datosAcompanhante == null) {
            datosAcompanhante = new DatosAcompanhante();
        }
        return datosAcompanhante;
    }

    public void guardarDatosAcompanhante(DatosAcompanhante pdatosAcompanhante) {
        datosAcompanhante = pdatosAcompanhante;
    }

    public String getNombreAcompanhante() {
        return nombreAcompanhante;
    }

    public void setNombreAcompanhante(String nombreAcompanhante) {
        this.nombreAcompanhante = nombreAcompanhante;
    }

    public String getTelefonoFijoAcompanhante() {
        return telefonoFijoAcompanhante;
    }

    public void setTelefonoFijoAcompanhante(String telefonoFijoAcompanhante) {
        this.telefonoFijoAcompanhante = telefonoFijoAcompanhante;
    }

    public String getCelularAcompanhante() {
        return celularAcompanhante;
    }

    public void setCelularAcompanhante(String celularAcompanhante) {
        this.celularAcompanhante = celularAcompanhante;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getNroSolicitud() {
        return nroSolicitud;
    }

    public void setNroSolicitud(String nroSolicitud) {
        this.nroSolicitud = nroSolicitud;
    }

    public static DatosAcompanhante getDatosAcompanhante() {
        return datosAcompanhante;
    }

    public static void setDatosAcompanhante(DatosAcompanhante datosAcompanhante) {
        DatosAcompanhante.datosAcompanhante = datosAcompanhante;
    }
}
