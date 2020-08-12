package com.conexia.qa.savia.tasks;

import com.conexia.qa.savia.interactions.EsperarCargando;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static com.conexia.qa.savia.user_interfaces.PortafolioProcedimientoPage.EDITAR_SERVICIO;

public class EnServicioSede implements Task {

    private String codigoServicio;
    private String descripcionServicio;

    public EnServicioSede(String codigoServicio, String descripcionServicio) {
        this.codigoServicio = codigoServicio;
        this.descripcionServicio = descripcionServicio;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(EDITAR_SERVICIO.of(codigoServicio + " - " + descripcionServicio)), EsperarCargando.procesando());
    }

    public static EnServicioSede EditaServicio(String codigoServicio, String descripcionServicio) {
        return Tasks.instrumented(EnServicioSede.class, codigoServicio, descripcionServicio);
    }

}
