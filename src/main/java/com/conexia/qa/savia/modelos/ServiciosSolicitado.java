package com.conexia.qa.savia.modelos;

public class ServiciosSolicitado {
    private String origenDeLaAtencion;
    private String prioridadDeLaAntencion;
    private String tipoDeServicioSolicitado;
    private String ubicacionDelPaciente;

    public static ServiciosSolicitado nuevoServiciosSolicSolitados (){
        return new ServiciosSolicitado();
    }

    public String getOrigenDeLaAtencion() {
        return origenDeLaAtencion;
    }

    public void setOrigenDeLaAtencion(String origenDeLaAtencion) {
        this.origenDeLaAtencion = origenDeLaAtencion;
    }

    public String getPrioridadDeLaAntencion() {
        return prioridadDeLaAntencion;
    }

    public void setPrioridadDeLaAntencion(String prioridadDeLaAntencion) {
        this.prioridadDeLaAntencion = prioridadDeLaAntencion;
    }

    public String getTipoDeServicioSolicitado() {
        return tipoDeServicioSolicitado;
    }

    public void setTipoDeServicioSolicitado(String tipoDeServicioSolicitado) {
        this.tipoDeServicioSolicitado = tipoDeServicioSolicitado;
    }

    public String getUbicacionDelPaciente() {
        return ubicacionDelPaciente;
    }

    public void setUbicacionDelPaciente(String ubicacionDelPaciente) {
        this.ubicacionDelPaciente = ubicacionDelPaciente;
    }
}
