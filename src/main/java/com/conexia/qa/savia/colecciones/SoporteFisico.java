package com.conexia.qa.savia.colecciones;

public class SoporteFisico {
    private String rutaArchivo;
    private String tipoArchivo;

    public static SoporteFisico nuevoSoporteFisico(){
        return new SoporteFisico();
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public String getTipoArchivo() {
        return tipoArchivo;
    }

    public void setTipoArchivo(String tipoArchivo) {
        this.tipoArchivo = tipoArchivo;
    }
}
