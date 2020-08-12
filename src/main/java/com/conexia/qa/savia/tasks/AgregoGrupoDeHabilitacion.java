package com.conexia.qa.savia.tasks;

import com.conexia.qa.savia.interactions.EsperarCargando;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.conexia.qa.savia.user_interfaces.PortafolioProcedimientoPage.*;

public class AgregoGrupoDeHabilitacion implements Task {

    private String grupoHabilitacion;
    private String codigoServicio;
    private String descripcionServicio;
    private String tarifario;
    private String porcentajeNegociado;
    private String complejidad;

    public AgregoGrupoDeHabilitacion(String grupoHabilitacion, String codigoServicio, String descripcionServicio, String tarifario, String porcentajeNegociado, String complejidad) {
        this.grupoHabilitacion = grupoHabilitacion;
        this.codigoServicio = codigoServicio;
        this.descripcionServicio = descripcionServicio;
        this.tarifario = tarifario;
        this.porcentajeNegociado = porcentajeNegociado;
        this.complejidad = complejidad;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Serenity.takeScreenshot();
        actor.attemptsTo(Click.on(NUEVO_SERVICIO), EsperarCargando.procesando());
        actor.attemptsTo(Click.on(GRUPO_HABILITACION), EsperarCargando.procesando());
        actor.attemptsTo(Click.on(GRUPO_HABILITACION_SELECCION.of(grupoHabilitacion)), EsperarCargando.procesando());
        actor.attemptsTo(Click.on(SERVICIO_DE_HABILITACION), EsperarCargando.procesando());
        actor.attemptsTo(Click.on(SERVICIO_DE_HABILITACION_SELECCION.of(codigoServicio + " - " + descripcionServicio)), EsperarCargando.procesando());
        actor.attemptsTo(Click.on(TARIFARIO), EsperarCargando.procesando());
        actor.attemptsTo(Click.on(TARIFARIO_SELECCION.of(tarifario)), EsperarCargando.procesando());
        actor.attemptsTo(Click.on(COMPLEJIDAD), EsperarCargando.procesando());
        actor.attemptsTo(Click.on(COMPLEJIDAD_SELECCION.of(complejidad)), EsperarCargando.procesando());
        if (!tarifario.equalsIgnoreCase("TARIFA PROPIA")) {
            actor.attemptsTo(Enter.theValue(porcentajeNegociado).into(PORCENTAJE_NEGOCIACION), EsperarCargando.procesando());
        }
        Serenity.takeScreenshot();
        actor.attemptsTo(Click.on(AGREGAR), EsperarCargando.procesando());
        Serenity.takeScreenshot();


    }


    public static AgregoGrupoDeHabilitacion conLosDatos(String grupoHabilitacion, String codigoServicio, String descripcionServicio, String tarifario, String porcentajeNegociado, String complejidad) {
        return Tasks.instrumented(AgregoGrupoDeHabilitacion.class, grupoHabilitacion, codigoServicio, descripcionServicio, tarifario, porcentajeNegociado, complejidad);
    }

}
