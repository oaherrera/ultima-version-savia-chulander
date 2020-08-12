package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.user_interfaces.RipsValidacionCuentaPage.ES_FACTURACION_MULTIUSUARIO;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class EsMultiusuario implements Task {

	private String siNo;

	public EsMultiusuario(String siNo) {
		this.siNo = siNo;
	}

	@Step("{0} #siNo marca si es multiusuario")
	@Override
	public <T extends Actor> void performAs(T actor) {

		if (siNo.equals("Si")
				&& ES_FACTURACION_MULTIUSUARIO.resolveFor(actor).getAttribute("class").contains("ui-icon-blank")) {
			actor.attemptsTo(Click.on(ES_FACTURACION_MULTIUSUARIO));
		} else if (siNo.equals("No")
				&& ES_FACTURACION_MULTIUSUARIO.resolveFor(actor).getAttribute("class").contains("ui-icon-check")) {
			actor.attemptsTo(Click.on(ES_FACTURACION_MULTIUSUARIO));
		}
	}

	public static EsMultiusuario elCargue(String siNo) {
		return Tasks.instrumented(EsMultiusuario.class, siNo);
	}

}
