package com.conexia.qa.savia.tasks;

import com.conexia.qa.savia.interactions.EsperarCargando;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static com.conexia.qa.savia.user_interfaces.CargueMasivoSolicitudPage.CONFIRMAR_SI;
import static com.conexia.qa.savia.user_interfaces.CargueMasivoSolicitudPage.PROCESAR;

public class ProcesoCargaAutorizacion implements Task {

    private String idCargueSolicitudes;

    public ProcesoCargaAutorizacion(String idCargueSolicitudes) {
        this.idCargueSolicitudes = idCargueSolicitudes;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(PROCESAR.of(idCargueSolicitudes)), EsperarCargando.pagina());
        actor.attemptsTo(Click.on(CONFIRMAR_SI), EsperarCargando.pagina());
    }

    public static ProcesoCargaAutorizacion validada(String idCargueSolicitudes) {
        return Tasks.instrumented(ProcesoCargaAutorizacion.class, idCargueSolicitudes);
    }


}
