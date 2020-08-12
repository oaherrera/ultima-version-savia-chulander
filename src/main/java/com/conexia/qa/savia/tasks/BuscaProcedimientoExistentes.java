package com.conexia.qa.savia.tasks;

import com.conexia.qa.savia.interactions.EsperarCargando;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.conexia.qa.savia.user_interfaces.PortafolioProcedimientoPage.*;

public class BuscaProcedimientoExistentes implements Task {

    private String descripcionProcedimiento;
    private String codigoProcedimiento;
    private String tarifario;
    private String valorProcedimiento;

    public BuscaProcedimientoExistentes(String descripcionProcedimiento, String codigoProcedimiento, String tarifario, String valorProcedimiento) {
        this.descripcionProcedimiento = descripcionProcedimiento;
        this.codigoProcedimiento = codigoProcedimiento;
        this.tarifario = tarifario;
        this.valorProcedimiento = valorProcedimiento;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Serenity.takeScreenshot();
        actor.attemptsTo(Click.on(BUSCAR_PROCEDIMIENTO), EsperarCargando.procesando());
        actor.attemptsTo(Enter.theValue(descripcionProcedimiento).into(DESCRIPCION_PROCEDIMIENTO));
        actor.attemptsTo(Enter.theValue(codigoProcedimiento).into(CUPS));
        actor.attemptsTo(Click.on(BUSCAR), EsperarCargando.procesando());
        Serenity.takeScreenshot();
        actor.attemptsTo(Click.on(TARIFARIO_DIFERENCIAL.of(codigoProcedimiento)), EsperarCargando.procesando());
        actor.attemptsTo(Click.on(TARIFARIO_PROCEDIMIENTO.of(codigoProcedimiento)));
        actor.attemptsTo(Click.on(TARIFARIO_PROCEDIMIENTO_SELECCION.of(codigoProcedimiento, tarifario)));
        actor.attemptsTo(Enter.theValue(valorProcedimiento).into(VALOR.of(codigoProcedimiento)));
        actor.attemptsTo(Click.on(SELLECCION_REGISTRO.of(codigoProcedimiento)), EsperarCargando.procesando());
        actor.attemptsTo(Click.on(AGREGAR_AL_PORTAFOLIO), EsperarCargando.procesando());
        Serenity.takeScreenshot();

    }

    public static BuscaProcedimientoExistentes paraAgregarlosAlPortafolio(String descripcionProcedimiento, String codigoProcedimiento, String tarifario, String valorProcedimiento) {
        return Tasks.instrumented(BuscaProcedimientoExistentes.class, descripcionProcedimiento, codigoProcedimiento, tarifario, valorProcedimiento);
    }

}
