package com.conexia.qa.savia.questions;

import com.conexia.qa.savia.user_interfaces.CargueMasivoSolicitudPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.junit.Assert;

import static com.conexia.qa.savia.user_interfaces.CargueMasivoSolicitudPage.ESTADO_CARGUE;

public class ElEstadoDeCargueSolicitud implements Question<Boolean> {

    private String idCargueSolicitudes;
    private String estadoEsperado;

    public ElEstadoDeCargueSolicitud(String idCargueSolicitudes, String estadoEsperado) {
        this.idCargueSolicitudes = idCargueSolicitudes;
        this.estadoEsperado = estadoEsperado;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String estadoActual = ESTADO_CARGUE.of(idCargueSolicitudes).resolveFor(actor).getText();
        Serenity.takeScreenshot();
        Assert.assertTrue("El estado del cargue es:" + estadoActual + ", estado esperado"+estadoEsperado+".", estadoActual.equalsIgnoreCase(estadoEsperado));
        return true;
    }

    public static ElEstadoDeCargueSolicitud es(String idCargueSolicitudes, String estadoEsperado) {
        return new ElEstadoDeCargueSolicitud(idCargueSolicitudes, estadoEsperado);

    }
}
