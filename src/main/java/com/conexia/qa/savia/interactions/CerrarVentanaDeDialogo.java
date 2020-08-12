package com.conexia.qa.savia.interactions;

import static com.conexia.qa.savia.user_interfaces.CommonPage.CERRAR_VENTANA_DIALOGO;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class CerrarVentanaDeDialogo implements Interaction{

	@Override
	public <T extends Actor> void performAs(T actor) {
		takeScreenshot();
		actor.attemptsTo(Click.on(CERRAR_VENTANA_DIALOGO),EsperarCargando.pagina());
		takeScreenshot();
	}
	
	public static CerrarVentanaDeDialogo desplegado() {
		return Tasks.instrumented(CerrarVentanaDeDialogo.class);
	}

}
