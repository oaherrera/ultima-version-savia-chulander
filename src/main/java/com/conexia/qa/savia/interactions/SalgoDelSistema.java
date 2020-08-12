package com.conexia.qa.savia.interactions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static com.conexia.qa.savia.user_interfaces.CommonPage.SALIR_DEL_SISTEMA;

public class SalgoDelSistema implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(EsperarDesaparece.mensajeTemporal());
        actor.attemptsTo(Click.on(SALIR_DEL_SISTEMA),EsperarCargando.pagina());
        Serenity.takeScreenshot();
    }

    public static SalgoDelSistema correctamente(){
        return Tasks.instrumented(SalgoDelSistema.class);
    }

}
