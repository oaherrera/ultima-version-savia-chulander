package com.conexia.qa.savia.tasks;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;

import static com.conexia.qa.savia.user_interfaces.PortafolioProcedimientoPage.FILTRO_GRUPO_HABILITACION;
import static com.conexia.qa.savia.user_interfaces.PortafolioProcedimientoPage.FILTRO_SERVICIO_HABILITACION;

public class FiltroServicioProcedimiento implements Task {

    private String descripcionGrupoServicio;
    private String codigoServicio;
    private String descripcionServicio;

    public FiltroServicioProcedimiento(String descripcionGrupoServicio, String codigoServicio, String descripcionServicio) {
        this.descripcionGrupoServicio = descripcionGrupoServicio;
        this.codigoServicio = codigoServicio;
        this.descripcionServicio = descripcionServicio;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(descripcionGrupoServicio).into(FILTRO_GRUPO_HABILITACION));
        actor.attemptsTo(Enter.theValue(codigoServicio + " - " + descripcionServicio).into(FILTRO_SERVICIO_HABILITACION));
        Serenity.takeScreenshot();
    }

    public static FiltroServicioProcedimiento enPortafolio(String descripcionGrupoServicio, String codigoServicio, String descripcionServicio) {
        return Tasks.instrumented(FiltroServicioProcedimiento.class, descripcionGrupoServicio, codigoServicio, descripcionServicio);
    }

}
