package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.user_interfaces.ProcedimientoPage.PROCEDIMIENTO_CODIGO;
import static com.conexia.qa.savia.user_interfaces.ProcedimientoPage.PROCEDIMIENTO_CODIGO_SELECCION;
import static com.conexia.qa.savia.user_interfaces.ProcedimientoPage.SERVICIO;
import static com.conexia.qa.savia.user_interfaces.ProcedimientoPage.SERVICIO_SELECCION;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import com.conexia.qa.savia.interactions.Esperar;

import static com.conexia.qa.savia.user_interfaces.ProcedimientoPage.DIAGNOSTICO;
import static com.conexia.qa.savia.user_interfaces.ProcedimientoPage.DIAGNOSTICO_SELECCION;
import static com.conexia.qa.savia.user_interfaces.ProcedimientoPage.AGREGAR;
import static com.conexia.qa.savia.user_interfaces.ProcedimientoPage.ES_POSFECHADO;
import static com.conexia.qa.savia.user_interfaces.ProcedimientoPage.DURACION_DEL_TRATAMIENTO;
import static com.conexia.qa.savia.user_interfaces.ProcedimientoPage.INDICACIONES;
import static com.conexia.qa.savia.user_interfaces.ProcedimientoPage.GUARDAR;

import com.conexia.qa.savia.interactions.EsperarCargando;
import com.conexia.qa.savia.interactions.MueveScroll;
import com.conexia.qa.sql.tasks.ConsultoProcedimiento;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class AgregaProcedimiento implements Task {

    private String tipologia;
    private String codigoProcedimiento;
    private String descripcionProcedimiento;
    private String duracionTratamientoDias;
    private String indicaciones;

    public AgregaProcedimiento(String tipologia, String codigoProcedimiento, String descripcionProcedimiento, String duracionTratamientoDias, String indicaciones) {
        this.tipologia = tipologia;
        this.codigoProcedimiento = codigoProcedimiento;
        this.descripcionProcedimiento = descripcionProcedimiento;
        this.duracionTratamientoDias = duracionTratamientoDias;
        this.indicaciones = indicaciones;
    }

    @Step("{0} agrega un procedimiento a la autorizacion #codigoProcedimiento ")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(MueveScroll.vertical(60), EsperarCargando.pagina(), Esperar.por(300));
        actor.attemptsTo(Esperar.por(2000));
        takeScreenshot();
        actor.attemptsTo(Enter.theValue(codigoProcedimiento + " - " + descripcionProcedimiento).into(PROCEDIMIENTO_CODIGO));
        actor.attemptsTo(Click.on(PROCEDIMIENTO_CODIGO_SELECCION), EsperarCargando.pagina());
        takeScreenshot();
        actor.attemptsTo(Click.on(SERVICIO));
        actor.attemptsTo(Click.on(SERVICIO_SELECCION));
        actor.attemptsTo(Click.on(DIAGNOSTICO));
        actor.attemptsTo(Click.on(DIAGNOSTICO_SELECCION));
        takeScreenshot();
        if (tipologia.equalsIgnoreCase("PBS")||tipologia.equalsIgnoreCase("Condicionado")) {
            actor.attemptsTo(Click.on(AGREGAR), Esperar.por(3000), EsperarCargando.pagina());
            actor.attemptsTo(Click.on(ES_POSFECHADO));
            actor.attemptsTo(Enter.theValue(duracionTratamientoDias).into(DURACION_DEL_TRATAMIENTO));
            actor.attemptsTo(Enter.theValue(indicaciones).into(INDICACIONES));
            takeScreenshot();
            actor.attemptsTo(Click.on(GUARDAR));
            takeScreenshot();
        }
    }

    public static AgregaProcedimiento conLosDatos(String tipologia, String codigoProcedimiento, String descripcionProcedimiento, String duracionTratamientoDias,
                                                  String indicaciones) {
        return Tasks.instrumented(AgregaProcedimiento.class, tipologia, codigoProcedimiento, descripcionProcedimiento, duracionTratamientoDias,
                indicaciones);
    }

}
