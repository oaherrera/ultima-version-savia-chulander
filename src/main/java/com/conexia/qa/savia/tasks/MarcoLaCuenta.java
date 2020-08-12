package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.user_interfaces.GestionCuentasEpsFacturasPage.ACEPTAR;
import static com.conexia.qa.savia.user_interfaces.GestionCuentasEpsFacturasPage.CUENTA_REVISADA;
import static com.conexia.qa.savia.user_interfaces.GestionCuentasEpsFacturasPage.MARCAR_REVISADO;
import static com.conexia.qa.savia.user_interfaces.GestionCuentasEpsFacturasPage.MARCAR_TAOAS;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import com.conexia.qa.savia.interactions.EsperarCargando;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class MarcoLaCuenta implements Task {

	public MarcoLaCuenta() {
	}

	@Step("{0} Marca las cuentas como revisadao")
	@Override
	public <T extends Actor> void performAs(T actor) {
		takeScreenshot();
		actor.attemptsTo(Click.on(MARCAR_TAOAS));
		takeScreenshot();
		actor.attemptsTo(Click.on(MARCAR_REVISADO));
		actor.attemptsTo(Click.on(ACEPTAR));
		takeScreenshot();
		actor.attemptsTo(Click.on(CUENTA_REVISADA));
		takeScreenshot();
		actor.attemptsTo(Click.on(ACEPTAR), EsperarCargando.pagina());
		takeScreenshot();
		
	}

	public static MarcoLaCuenta comoRevisada() {
		return Tasks.instrumented(MarcoLaCuenta.class);
	}
}
