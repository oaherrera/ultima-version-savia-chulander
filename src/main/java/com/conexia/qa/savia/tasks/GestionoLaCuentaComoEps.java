package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.user_interfaces.GestionCuentasEpsPage.ACCION;
import static com.conexia.qa.savia.user_interfaces.GestionCuentasPage.CONFIRMAR_SI;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import com.conexia.qa.savia.interactions.EsperarCargando;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class GestionoLaCuentaComoEps implements Task {

	private String accion;

	public GestionoLaCuentaComoEps(String accion) {
		this.accion = accion;
	}

	@Step("{0} gestiona la cuenta como EPS a #accion")
	@Override
	public <T extends Actor> void performAs(T actor) {

		takeScreenshot();
		switch (accion) {
		case "Legalizar Cuenta":
			actor.attemptsTo(EsperarCargando.pagina(), Click.on(ACCION.of(accion)), EsperarCargando.pagina());
			takeScreenshot();
			actor.attemptsTo(Click.on(CONFIRMAR_SI));
			break;
		default:
			actor.attemptsTo(EsperarCargando.pagina(), Click.on(ACCION.of(accion)), EsperarCargando.pagina());
			break;
		}

		takeScreenshot();
	}

	public static GestionoLaCuentaComoEps realizandoLaAccion(String accion) {
		return Tasks.instrumented(GestionoLaCuentaComoEps.class, accion);

	}

}
