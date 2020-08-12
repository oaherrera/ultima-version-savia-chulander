package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.user_interfaces.GestionCuentasPage.ACEPTAR;
import static com.conexia.qa.savia.user_interfaces.GestionCuentasPage.CONFIRMAR_SI;
import static com.conexia.qa.savia.user_interfaces.GestionCuentasPage.ENVIAR_A_HOMOLOGAR;
import static com.conexia.qa.savia.user_interfaces.GestionCuentasPage.ENVIAR_A_VERIFICACION_EPS;
import static com.conexia.qa.savia.user_interfaces.GestionCuentasPage.FINALIZAR_HOLOGACION;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class GestionoLaCuenta implements Task {

	private String accion;

	public GestionoLaCuenta(String accion) {
		this.accion = accion;
	}

	@Step("{0} gestiona la cuenta a #accion")
	@Override
	public <T extends Actor> void performAs(T actor) {
		takeScreenshot();
		switch (accion) {
		case "Enviar a homologar":
			actor.attemptsTo(Click.on(ENVIAR_A_HOMOLOGAR));
			actor.attemptsTo(Click.on(CONFIRMAR_SI));
			break;
		case "Finalizar homologación":
			actor.attemptsTo(Click.on(FINALIZAR_HOLOGACION));
			actor.attemptsTo(Click.on(ACEPTAR));
			break;
		case "Enviar a Verificación EPS":
			actor.attemptsTo(Click.on(ENVIAR_A_VERIFICACION_EPS));
			actor.attemptsTo(Click.on(CONFIRMAR_SI));
			break;
		}
		takeScreenshot();

	}

	public static GestionoLaCuenta realizandoLaAccion(String accion) {

		return Tasks.instrumented(GestionoLaCuenta.class, accion.trim());
	}

}
