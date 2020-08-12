package com.conexia.qa.savia.colecciones;

import com.conexia.qa.savia.modelos.ServiciosSolicitado;

public class ServiciosSolicitados {
    private static ServiciosSolicitados serviciosSolicitadosCollection;
    private static ServiciosSolicitado serviciosSolicitado;

    public static ServiciosSolicitados traerServiciosSolicitados() {
        if (serviciosSolicitadosCollection == null) {
            serviciosSolicitadosCollection = new ServiciosSolicitados();
        }
        return serviciosSolicitadosCollection;
    }

    public void guardarServiciosSolicitados(ServiciosSolicitado pServicioSolicitado) {
        serviciosSolicitado = pServicioSolicitado;

    }

    public ServiciosSolicitado traerServiciosSolicitado(){
        return serviciosSolicitado;
    }
}
