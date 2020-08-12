package com.conexia.qa.savia.interactions;

import static com.conexia.qa.savia.drivers.OwnWebDriver.getDriver;
import static com.conexia.qa.savia.user_interfaces.CommonPage.CARGANDO;
import static com.conexia.qa.savia.user_interfaces.CommonPage.CARGANDO_PROCESANDO;
import static java.util.concurrent.TimeUnit.SECONDS;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class EsperarCargando implements Interaction {

    private String tipoEspera;

    public EsperarCargando(String tipoEspera) {
        this.tipoEspera = tipoEspera;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Esperar.por(500));
        getDriver().manage().timeouts().implicitlyWait(2, SECONDS);
        switch (tipoEspera) {
            case "Load":
                while (CARGANDO.resolveFor(actor).isVisible()) {
                    actor.attemptsTo(Esperar.por(2000));
                }
                break;
			case "Procesando":
				while (CARGANDO_PROCESANDO.resolveFor(actor).isVisible()) {
					actor.attemptsTo(Esperar.por(1500));
				}
				break;
        }
        getDriver().manage().timeouts().implicitlyWait(10, SECONDS);
    }

    public static EsperarCargando pagina() {
        return Tasks.instrumented(EsperarCargando.class, "Load");
    }

    public static EsperarCargando procesando() {
        return Tasks.instrumented(EsperarCargando.class, "Procesando");
    }

}
