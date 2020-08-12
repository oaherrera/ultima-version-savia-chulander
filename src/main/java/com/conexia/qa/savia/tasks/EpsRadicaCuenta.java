package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.user_interfaces.RadicacionCuentaEpsPage.OBSERVACION;
import static com.conexia.qa.savia.user_interfaces.RadicacionCuentaEpsPage.REGIONAL;
import static com.conexia.qa.savia.user_interfaces.RadicacionCuentaEpsPage.REGIONAL_SELECCION;
import static com.conexia.qa.savia.user_interfaces.RadicacionCuentaEpsPage.REGISTRAR;
import static com.conexia.qa.savia.user_interfaces.RadicacionCuentaEpsPage.RESPONSABLE_DE_PAGO;
import static com.conexia.qa.savia.user_interfaces.RadicacionCuentaEpsPage.RESPONSABLE_DE_PAGO_SELECCION;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class EpsRadicaCuenta implements Task{

	private String regional;
	private String responsableDePago;
	private String observaciones;
	
	
	public EpsRadicaCuenta(String regional, String responsableDePago, String observaciones) {
		this.regional = regional;
		this.responsableDePago = responsableDePago;
		this.observaciones = observaciones;
	}
	
	@Step("{0} Eps radica la cuenta ")
	@Override
	public <T extends Actor> void performAs(T actor) {
		takeScreenshot();
		actor.attemptsTo(Click.on(REGIONAL));
		actor.attemptsTo(Click.on(REGIONAL_SELECCION.of(regional)));
		actor.attemptsTo(Click.on(RESPONSABLE_DE_PAGO));
		actor.attemptsTo(Click.on(RESPONSABLE_DE_PAGO_SELECCION.of(responsableDePago)));
		actor.attemptsTo(Enter.theValue(observaciones).into(OBSERVACION));
		takeScreenshot();
		actor.attemptsTo(Click.on(REGISTRAR));
		takeScreenshot();
		
	}
	public static EpsRadicaCuenta conLosDatos(String regional, String responsableDePago, String observaciones) {
		
		return Tasks.instrumented(EpsRadicaCuenta.class, regional,responsableDePago,observaciones);
	}

}
