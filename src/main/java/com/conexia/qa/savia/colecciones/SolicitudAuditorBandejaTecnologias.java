package com.conexia.qa.savia.colecciones;

import com.conexia.qa.savia.modelos.SolicitudAuditorBandeja;

import java.util.ArrayList;
import java.util.List;

public class SolicitudAuditorBandejaTecnologias {
    private static SolicitudAuditorBandejaTecnologias solicitudAuditorBandejaTecnologias;
    private static List<SolicitudAuditorBandeja> solicitudAuditorBandejaCollection;

    public static SolicitudAuditorBandejaTecnologias traerSolicitudAuditorBandejaTecnologias() {
        if (solicitudAuditorBandejaTecnologias == null) {
            solicitudAuditorBandejaTecnologias = new SolicitudAuditorBandejaTecnologias();
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
