package com.conexia.qa.savia.tasks;

import com.conexia.qa.savia.interactions.EsperarCargando;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;

import static com.conexia.qa.savia.user_interfaces.PortafolioProcedimientoPage.FILTRO_CUPS;
import static com.conexia.qa.savia.user_interfaces.PortafolioProcedimientoPage.FILTRO_DESCRIPCION_PROCEDIMIENTO;

public class FiltroProcedimiento implements Task {

    private String codigoProcedimiento;
    private String descripcionProcedimiento;

    public FiltroProcedimiento(String codigoProcedimiento, String descripcionProcedimiento) {
        this.codigoProcedimiento = codigoProcedimiento;
        this.descripcionProcedimiento = descripcionProcedimiento;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(descripcionProcedimiento).into(FILTRO_DESCRIPCION_PROCEDIMIENTO), EsperarCargando.procesando());
        actor.attemptsTo(Enter.theValue(codigoProcedimiento).into(FILTRO_CUPS), EsperarCargando.procesando());
        Serenity.takeScreenshot();
    }

    public static Performable enPortafolio(String codigoProcedimiento, String descripcionProcedimiento) {
        return Tasks.instrumented(FiltroProcedimiento.class, codigoProcedimiento, descripcionProcedimiento);
    }
}
