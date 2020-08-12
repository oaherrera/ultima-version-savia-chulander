package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.user_interfaces.RadicadoFacturasRadicadasPage.VER_FACTURA;
import static com.conexia.qa.savia.user_interfaces.RadicadoItemDeServicioFacturadosPage.MARCAR_ITEM;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class SeleccionoElPrimerServicio implements Task{


	@Step("{0} Selecciona el primer servicio de la factura radicado")
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(VER_FACTURA.of("1")));
		actor.attemptsTo(Click.on(MARCAR_ITEM.of("1")));
	}
	
	public static Performable paraLaPrimeraFacturaRadicado() {
		return Tasks.instrumented(SeleccionoElPrimerServicio.class);
	}


}
