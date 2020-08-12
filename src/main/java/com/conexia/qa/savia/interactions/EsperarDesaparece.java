package com.conexia.qa.savia.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import static com.conexia.qa.savia.user_interfaces.CommonPage.MENSAJE_TEMPORAL;

public class EsperarDesaparece implements Interaction {

    private boolean desaparece;

    @Override
    public <T extends Actor> void performAs(T actor) {

        this.desaparece = false;
        while (!desaparece) {
			Esperar.por(1000);
            if (!MENSAJE_TEMPORAL.resolveFor(actor).isVisible()) {
                desaparece = true;
                break;
            }
        }
    }

    public static EsperarDesaparece mensajeTemporal() {
        return Tasks.instrumented(EsperarDesaparece.class);
    }


}
