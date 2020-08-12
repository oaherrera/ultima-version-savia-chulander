package com.conexia.qa.savia.tasks;

import com.conexia.qa.savia.interactions.EsperarCargando;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static com.conexia.qa.savia.user_interfaces.PortafolioSedesDelPrestadorPage.EDITAR_SERVICIOS_SEDE;
import static com.conexia.qa.savia.user_interfaces.PortafolioSedesDelPrestadorPage.TAB_SEDES_DEL_PRESTADOR;

public class SeleccionaSedesDelPrestador implements Task {

    private String accion;
    private String sede;

    public SeleccionaSedesDelPrestador(String accion, String sede) {
        this.accion = accion;
        this.sede = sede;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Serenity.takeScreenshot();
        actor.attemptsTo(Click.on(TAB_SEDES_DEL_PRESTADOR), EsperarCargando.procesando());
        Serenity.takeScreenshot();
        switch (accion) {
            case "Editar Servicios Sede":
                actor.attemptsTo(Click.on(EDITAR_SERVICIOS_SEDE.of(sede)), EsperarCargando.procesando());
                break;
        }
        Serenity.takeScreenshot();
    }

    public static SeleccionaSedesDelPrestador para(String accion, String sede) {
        return Tasks.instrumented(SeleccionaSedesDelPrestador.class, accion, sede);
    }
}
