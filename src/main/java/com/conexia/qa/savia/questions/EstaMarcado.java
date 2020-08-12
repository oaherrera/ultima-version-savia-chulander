package com.conexia.qa.savia.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class EstaMarcado implements Question<Boolean> {

	private Target objetoAValidar;

	public EstaMarcado(Target objetoAValidar) {
		this.objetoAValidar = objetoAValidar;
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		return objetoAValidar.resolveFor(actor).getAttribute("class").contains("ui-state-active");
	}

	public static EstaMarcado elCheck(Target check) {
		return new EstaMarcado(check);
	}
}
