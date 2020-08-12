package com.conexia.qa.savia.questions;

import com.conexia.qa.savia.colecciones.SolicitudAuditorBandejaTecnologias;
import com.conexia.qa.savia.modelos.SolicitudAuditorBandeja;
import com.conexia.qa.sql.colecciones.SolicitudAuditorBandejaTecnologiasBD;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;

public class LosResultadosDeLaTablaSolicitud implements Question<Boolean> {

    private SolicitudAuditorBandejaTecnologias tecnologiasEnElPortal;
    private SolicitudAuditorBandejaTecnologiasBD tecnologiasLaBD;
    private SolicitudAuditorBandeja tecnologiaPortal;
    private SolicitudAuditorBandeja tecnologiaBD;


    public LosResultadosDeLaTablaSolicitud() {
        tecnologiasEnElPortal = SolicitudAuditorBandejaTecnologias.traerSolicitudAuditorBandejaTecnologias();
        tecnologiasLaBD = SolicitudAuditorBandejaTecnologiasBD.traerSolicitudAuditorBandejaTecnologias();
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        Assert.assertEquals("Cantidad de tecnologias en pantalla no coincide con las de la bd", tecnologiasEnElPortal.cantidadSolicitudAuditorBandeja(), (tecnologiasLaBD.cantidadSolicitudAuditorBandeja()));

        for (int indice = 0; indice < tecnologiasEnElPortal.cantidadSolicitudAuditorBandeja(); indice++) {
            tecnologiaBD = tecnologiasLaBD.traerSolicitudAuditorBandeja(indice);
            tecnologiaPortal = tecnologiasEnElPortal.traerSolicitudAuditorBandeja(indice);

            Assert.assertThat("Descripcion no coincide, fila " + indice, tecnologiaPortal.getDescripcionTecnologia(), CoreMatchers.containsString(tecnologiaBD.getDescripcionTecnologia()));
            //Assert.assertEquals("Estado no coincide, fila " + indice, tecnologiaBD.getEstado().length(), tecnologiaPortal.getEstado().length());

            tecnologiaBD.setBandejaSolicitud(tecnologiaPortal.getBandejaSolicitud());
        }
        return true;
    }

    public static LosResultadosDeLaTablaSolicitud esIgualAlosDeLABD() {
        return new LosResultadosDeLaTablaSolicitud();
    }
}

