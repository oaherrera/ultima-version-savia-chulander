package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.user_interfaces.CommonPage.SIGUIENTE;
import static com.conexia.qa.savia.user_interfaces.CommonPage.TERMINAR;
import static com.conexia.qa.savia.user_interfaces.NegociacionPage.NEGOCIAR_TODAS_LAS_SEDES;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import com.conexia.qa.savia.interactions.EsperarCargando;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class SeleccionoTipoNegociacion implements Task {

	private String tipoNegociacion;

	public SeleccionoTipoNegociacion(String tipoNegociacion) {
		this.tipoNegociacion = tipoNegociacion;
	}

	@Step("{0} Selecciona tipo de negociación #tipoNegociacion ")
	@Override
	public <T extends Actor> void performAs(T actor) {
		takeScreenshot();
		actor.attemptsTo(Click.on(SIGUIENTE));
		actor.attemptsTo(Click.on(NEGOCIAR_TODAS_LAS_SEDES.of(tipoNegociacion)));
		takeScreenshot();
		actor.attemptsTo(Click.on(TERMINAR), EsperarCargando.pagina());
		takeScreenshot();
	}

	public static SeleccionoTipoNegociacion paraTerminarNegociacion(String tipoNegociacion) {
		return Tasks.instrumented(SeleccionoTipoNegociacion.class, tipoNegociacion);
	}

}
