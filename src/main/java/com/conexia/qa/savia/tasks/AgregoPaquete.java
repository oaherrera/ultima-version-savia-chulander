package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.user_interfaces.PaquetePage.TAB_PAQUETE;
import static com.conexia.qa.savia.user_interfaces.PaquetePage.CODIGO_DESCRIPCION;
import static com.conexia.qa.savia.user_interfaces.PaquetePage.CODIGO_DESCRIPCION_SELECCION;
import static com.conexia.qa.savia.user_interfaces.PaquetePage.DIAGNOSTICO;
import static com.conexia.qa.savia.user_interfaces.PaquetePage.DIAGNOSTICO_SELECCION;
import static com.conexia.qa.savia.user_interfaces.PaquetePage.AGREGAR_PAQUETE;
import static com.conexia.qa.savia.user_interfaces.PaquetePage.ES_POSFECHADO;
import static com.conexia.qa.savia.user_interfaces.PaquetePage.DURACION_DEL_TRATAMIENTO;
import static com.conexia.qa.savia.user_interfaces.PaquetePage.INDICACIONES;
import static com.conexia.qa.savia.user_interfaces.PaquetePage.GUARDAR;

import com.conexia.qa.savia.interactions.Esperar;
import com.conexia.qa.savia.interactions.EsperarCargando;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;


public class AgregoPaquete implements Task {
    private String tipologia;
    private String codigoPaquete;
    private String descripcionPaquete;
    private String codigoDiagnostico;
    private String duracionTratamientoDias;
    private String indicaciones;

    public AgregoPaquete(String tipologia, String codigoPaquete, String descripcionPaquete, String codigoDiagnostico, String duracionTratamientoDias, String indicaciones) {
        this.tipologia = tipologia;
        this.codigoPaquete = codigoPaquete;
        this.descripcionPaquete = descripcionPaquete;
        this.codigoDiagnostico = codigoDiagnostico;
        this.duracionTratamientoDias = duracionTratamientoDias;
        this.indicaciones = indicaciones;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(TAB_PAQUETE));
        Serenity.takeScreenshot();
        actor.attemptsTo(Enter.theValue(codigoPaquete + " - " + descripcionPaquete).into(CODIGO_DESCRIPCION));
        actor.attemptsTo(Click.on(CODIGO_DESCRIPCION_SELECCION.of(codigoPaquete + " - " + descripcionPaquete)));
        Serenity.takeScreenshot();
        actor.attemptsTo(Click.on(DIAGNOSTICO));
        actor.attemptsTo(Click.on(DIAGNOSTICO_SELECCION.of(codigoDiagnostico)));
        Serenity.takeScreenshot();
        if (tipologia.equalsIgnoreCase("PBS")||tipologia.equalsIgnoreCase("Condicionado")) {
            actor.attemptsTo(Click.on(AGREGAR_PAQUETE), EsperarCargando.pagina(), Esperar.por(1000));
            actor.attemptsTo(Click.on(ES_POSFECHADO), EsperarCargando.pagina());
            actor.attemptsTo(Enter.theValue(duracionTratamientoDias).into(DURACION_DEL_TRATAMIENTO));
            actor.attemptsTo(Enter.theValue(indicaciones).into(INDICACIONES));
            Serenity.takeScreenshot();
            actor.attemptsTo(Click.on(GUARDAR), EsperarCargando.pagina());
            Serenity.takeScreenshot();
        }


    }

    public static AgregoPaquete conLosDatos(String tipologia, String codigoPaquete, String descripcionPaquete, String codigoDiagnostico, String duracionTratamientoDias, String indicaciones) {
        return Tasks.instrumented(AgregoPaquete.class, tipologia, codigoPaquete, descripcionPaquete, codigoDiagnostico, duracionTratamientoDias, indicaciones);
    }

}
