package com.conexia.qa.savia.step_definitions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.conexia.qa.savia.interactions.Volver;
import com.conexia.qa.savia.questions.MensajeTemporal;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.serenitybdd.screenplay.GivenWhenThen;

import static org.hamcrest.Matchers.equalToIgnoringCase;

public class CommonSteps {

	@And("^Vuelvo al formulario anterior$")
	public void vuelvoAlFormularioAnterior() {
		theActorInTheSpotlight().attemptsTo(Volver.alFormularioAnterior());
	}

	@Then("^Se despliega el mensaje temporal:(.+)$")
	public void seDespliegaElMensajeTemporal(String mensaje) {
		theActorInTheSpotlight().should(GivenWhenThen.seeThat(MensajeTemporal.es(), equalToIgnoringCase(mensaje.trim())));
	}
}
