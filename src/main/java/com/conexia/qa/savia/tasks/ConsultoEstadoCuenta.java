package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.user_interfaces.FormularioGestionDeCuentasValidadasPage.BUSCAR;
import static com.conexia.qa.savia.user_interfaces.FormularioGestionDeCuentasValidadasPage.IPS;
import static com.conexia.qa.savia.user_interfaces.FormularioGestionDeCuentasValidadasPage.IPS_SELECCION;
import static com.conexia.qa.savia.user_interfaces.FormularioGestionDeCuentasValidadasPage.NUMERO_DE_CUENTA;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class ConsultoEstadoCuenta implements Task{

	private String ips;
	private String numeroDeCuenta;
	
	public ConsultoEstadoCuenta(String ips, String numeroDeCuenta) {
		this.ips = ips;
		this.numeroDeCuenta = numeroDeCuenta;
	}

	@Step("{0} Consulta la estado de la cuenta #numeroDeCuenta de #ips")
	@Override
	public <T extends Actor> void performAs(T actor) {
		takeScreenshot();
		actor.attemptsTo(Enter.theValue(ips).into(IPS));
		actor.attemptsTo(Click.on(IPS_SELECCION.of(ips)));
		actor.attemptsTo(Enter.theValue(numeroDeCuenta).into(NUMERO_DE_CUENTA));
		takeScreenshot();
		actor.attemptsTo(Click.on(BUSCAR));
		takeScreenshot();
		
	}
	
	public static ConsultoEstadoCuenta conLaCuentaDeLaIps(String ips,String numeroDeCuenta ) {
		return Tasks.instrumented(ConsultoEstadoCuenta.class, ips,numeroDeCuenta );
	}

}
