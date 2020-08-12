package com.conexia.qa.sql.colecciones;

import com.conexia.qa.savia.modelos.SolicitudAuditorBandeja;

import java.util.ArrayList;
import java.util.List;

public class SolicitudAuditorBandejaTecnologiasBD {
    private static SolicitudAuditorBandejaTecnologiasBD solicitudAuditorBandejaTecnologias;
    private static List<SolicitudAuditorBandeja> solicitudAuditorBandejaCollection;

    public static SolicitudAuditorBandejaTecnologiasBD traerSolicitudAuditorBandejaTecnologias() {
        if (solicitudAuditorBandejaTecnologias == null) {
            solicitudAuditorBandejaTecnologias = new SolicitudAuditorBandejaTecnologiasBD();
            solicitudAuditorBandejaCollection = new ArrayList<SolicitudAuditorBandeja>();
        }
        return solicitudAuditorBandejaTecnologias;
    }

    public void agregarSolicitudAuditorBandeja(SolicitudAuditorBandeja solicitudAuditorBandeja) {
        solicitudAuditorBandejaCollection.add(solicitudAuditorBandeja);
    }

    public SolicitudAuditorBandeja traerSolicitudAuditorBandeja(int indice){
        return solicitudAuditorBandejaCollection.get(indice);
    }

    public void borrarSolicitudAuditorBandeja(){
        solicitudAuditorBandejaCollection = new ArrayList<SolicitudAuditorBandeja>();
    }

    public int cantidadSolicitudAuditorBandeja(){
        return solicitudAuditorBandejaCollection.size();
    }
}
