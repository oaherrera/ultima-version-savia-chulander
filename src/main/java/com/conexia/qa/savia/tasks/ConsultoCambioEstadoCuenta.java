package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.user_interfaces.FormularioGestionDeCuentasValidadasPage.BUSCAR;
import static com.conexia.qa.savia.user_interfaces.FormularioGestionDeCuentasValidadasPage.IPS;
import static com.conexia.qa.savia.user_interfaces.FormularioGestionDeCuentasValidadasPage.IPS_SELECCION;
import static com.conexia.qa.savia.user_interfaces.FormularioGestionDeCuentasValidadasPage.NUMERO_DE_CUENTA;
import static com.conexia.qa.savia.user_interfaces.ResultadoGestionDeCuentasValidadasPage.ESTADO_ACTUAL;
import static net.serenitybdd.core.Serenity.takeScreenshot;
import static org.hamcrest.Matchers.equalToIgnoringCase;

import org.junit.Assert;

import com.conexia.qa.savia.interactions.Esperar;
import com.conexia.qa.savia.interactions.EsperarCargando;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class ConsultoCambioEstadoCuenta implements Task {

	private String ips;
	private String numeroDeCuenta;
	private String estadoActual;
	private String estadoEsperado;
	private int cantidadIntento;
	private int tiempoEspera;

	public ConsultoCambioEstadoCuenta(String ips, String numeroDeCuenta, String estadoActual, String estadoEsperado) {
		this.ips = ips;
		this.numeroDeCuenta = numeroDeCuenta;
		this.estadoActual = estadoActual;
		this.estadoEsperado = estadoEsperado;
		
		this.cantidadIntento = 90;
		this.tiempoEspera = 30000;
	}

	@Step("{0} Consulta la cuenta #numeroDeCuenta de #estadoActual a #estadoEsperado")
	@Override
	public <T extends Actor> void performAs(T actor) {
		takeScreenshot();
		actor.attemptsTo(Enter.theValue(ips).into(IPS));
		actor.attemptsTo(Click.on(IPS_SELECCION.of(ips)));
		actor.attemptsTo(Enter.theValue(numeroDeCuenta).into(NUMERO_DE_CUENTA));
		actor.attemptsTo(Click.on(BUSCAR));
		takeScreenshot();
		int indice = 0;
		String estadoActualConsulta = "";
		while (indice < cantidadIntento) {
			estadoActualConsulta = ESTADO_ACTUAL.resolveFor(actor).getText();
			if (estadoActual.equals(estadoActualConsulta)) {
				actor.attemptsTo(Esperar.por(tiempoEspera));
				actor.attemptsTo(Click.on(BUSCAR),EsperarCargando.pagina());
				indice++;
			} else {
				Assert.assertThat("Estado esperado incorrecto", estadoActualConsulta,equalToIgnoringCase(estadoEsperado));
				indice = cantidadIntento+1;
			}
		}
		takeScreenshot();
	}

	public static ConsultoCambioEstadoCuenta conLaCuentaDeLaIps(String ips, String numeroDeCuenta, String estadoActual,
			String estadoEsperado) {
		return Tasks.instrumented(ConsultoCambioEstadoCuenta.class, ips, numeroDeCuenta,estadoActual, estadoEsperado);
	}

}
