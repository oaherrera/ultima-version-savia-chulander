package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.user_interfaces.SoportesFisicosPage.ADJUNTAR_ARCHIVO;
import static com.conexia.qa.savia.user_interfaces.SoportesFisicosPage.AGREGAR;
import static com.conexia.qa.savia.user_interfaces.SoportesFisicosPage.OBSERVACIONES;
import static com.conexia.qa.savia.user_interfaces.SoportesFisicosPage.TIPO_DE_DOCUMENTO;
import static com.conexia.qa.savia.user_interfaces.SoportesFisicosPage.TIPO_DE_DOCUMENTO_SELECCION;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import com.conexia.qa.savia.interactions.AdjuntoArchivo;
import com.conexia.qa.savia.interactions.Esperar;
import com.conexia.qa.savia.interactions.EsperarCargando;
import com.conexia.qa.savia.interactions.MueveScroll;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class AdjuntoSoportesFisicos implements Task {

    private int numeroArchivo;
    private String ruta;
    private String deTipo;
    private String observaciones;

    public AdjuntoSoportesFisicos(int numeroArchivo, String ruta, String deTipo, String observaciones) {
        this.numeroArchivo = numeroArchivo;
        this.ruta = ruta;
        this.deTipo = deTipo;
        this.observaciones = observaciones;
    }


    @Override
    @Step("{0} adjunta archivo de la ruta #ruta")
    public <T extends Actor> void performAs(T actor) {
        if (numeroArchivo == 0) {
            actor.attemptsTo(MueveScroll.vertical(400), Esperar.por(300));
        }
        takeScreenshot();
        if (observaciones == null) {
            actor.attemptsTo(AdjuntoArchivo.con(ruta, ADJUNTAR_ARCHIVO), Esperar.por(300), EsperarCargando.pagina());
            actor.attemptsTo(Click.on(TIPO_DE_DOCUMENTO), Esperar.por(300), EsperarCargando.pagina());
            actor.attemptsTo(Click.on(TIPO_DE_DOCUMENTO_SELECCION.of(deTipo)), Esperar.por(300), EsperarCargando.pagina());
            takeScreenshot();
            actor.attemptsTo(Click.on(AGREGAR), Esperar.por(3000), EsperarCargando.pagina());
        } else {
            actor.attemptsTo();
            actor.attemptsTo(Enter.theValue("Observaciones Prueba").into(OBSERVACIONES), Esperar.por(300), EsperarCargando.pagina());
        }
        takeScreenshot();
    }

    public static AdjuntoSoportesFisicos enLaSolicitud(int numeroArchivo, String ruta, String deTipo) {
        return Tasks.instrumented(AdjuntoSoportesFisicos.class, numeroArchivo, ruta, deTipo, null);
    }

    public static AdjuntoSoportesFisicos diligencioObservaciones() {
        return Tasks.instrumented(AdjuntoSoportesFisicos.class, 1, null, null, "Observaciones Prueba");
    }

}
