package com.conexia.qa.savia.questions;

import static com.conexia.qa.savia.user_interfaces.CommonPage.MENSAJE_CONFIRMACION;
import static net.serenitybdd.core.Serenity.takeScreenshot;
import static org.hamcrest.Matchers.equalToIgnoringCase;

import org.junit.Assert;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class MensajeConfirmacionGlosa implements Question<Boolean> {

	private String tipoDeGlosa;
	private String parcialOTotal;
	private String cantidades;

	public MensajeConfirmacionGlosa(String tipoDeGlosa, String parcialOTotal, String cantidades) {
		super();
		this.tipoDeGlosa = tipoDeGlosa;
		this.parcialOTotal = parcialOTotal;
		this.cantidades = cantidades;
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		takeScreenshot();
		switch (tipoDeGlosa) {
		case "porFacturas":
			Assert.assertThat(
					"Mensaje Confirmación incorrecto", 
					MENSAJE_CONFIRMACION.resolveFor(actor).getText(),
					equalToIgnoringCase("Ha seleccionado " + cantidades+ " elementos. Es probable que el procesamiento tome algunos minutos. Desea continuar?"));
			break;
		case "masivo":
			if (parcialOTotal.equals("Parcial")) {
				Assert.assertThat(
						"Mensaje Confirmación incorrecto", 
						MENSAJE_CONFIRMACION.resolveFor(actor).getText(),
						equalToIgnoringCase("Solo serán registradas las glosas a las facturas que no tienen una glosa parcial previa o si tienen glosa parcial previa sea del mismo tipo (Por Valor). Ha seleccionado "+ cantidades + " elementos. Desea continuar?"));
			}
			if (parcialOTotal.equals("Total")) {
				Assert.assertThat(
						"Mensaje Confirmación incorrecto", 
						MENSAJE_CONFIRMACION.resolveFor(actor).getText(),
						equalToIgnoringCase("Ha seleccionado " + cantidades + " elementos. Desea continuar?"));
			}
			break;
		case "porItem":
			if (parcialOTotal.equals("Parcial")) {
				Assert.assertThat(
						"Mensaje Confirmación incorrecto", 
						MENSAJE_CONFIRMACION.resolveFor(actor).getText(),
						equalToIgnoringCase("Solo serán registradas las glosas a las facturas que no tienen una glosa parcial previa o si tienen glosa parcial previa sea del mismo tipo (Por Valor). Ha seleccionado "+ cantidades + " elementos. Desea continuar?"));
			}
			if (parcialOTotal.equals("Total")) {
				Assert.assertThat(
						"Mensaje Confirmación incorrecto", 
						MENSAJE_CONFIRMACION.resolveFor(actor).getText(),
						equalToIgnoringCase("Ha seleccionado " + cantidades + " elementos. Desea continuar?"));
			}
			break;
		}
		return true;
	}

	public static MensajeConfirmacionGlosa esCorrecto(String tipoDeGlosa, String parcialOTotal, String cantidades) {
		return new MensajeConfirmacionGlosa(tipoDeGlosa, parcialOTotal, cantidades);
	}
}
