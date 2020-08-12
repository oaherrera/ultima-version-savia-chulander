package com.conexia.qa.savia.questions;

import static com.conexia.qa.savia.user_interfaces.CommonPage.MENSAJE_CONFIRMACION;
import static org.hamcrest.Matchers.equalToIgnoringCase;

import org.junit.Assert;

import com.conexia.qa.savia.interactions.Esperar;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class MensajeConfirmacionLevantarGlosa implements Question<Boolean> {

	private String modoLenvatarGlosa;
	private String cantidades;

	public MensajeConfirmacionLevantarGlosa(String modoLenvatarGlosa, String cantidades) {
		this.modoLenvatarGlosa = modoLenvatarGlosa;
		this.cantidades = cantidades;
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		actor.attemptsTo(Esperar.por(1000));
		switch (modoLenvatarGlosa) {
		case "a todas las facturas":
			Assert.assertThat("Mensaje Confirmación incorrecto", MENSAJE_CONFIRMACION.resolveFor(actor).getText(),
					equalToIgnoringCase("Ha seleccionado " + cantidades + " elementos. Es probable que el procesamiento tome algunos minutos. Desea continuar?"));
			break;
		case "masivo":
			Assert.assertThat("Mensaje Confirmación incorrecto", MENSAJE_CONFIRMACION.resolveFor(actor).getText(),
					equalToIgnoringCase("Ha seleccionado " + cantidades + " elementos. Desea continuar?"));
		case "por item":
			Assert.assertThat("Mensaje Confirmación incorrecto", MENSAJE_CONFIRMACION.resolveFor(actor).getText(),
					equalToIgnoringCase("Ha seleccionado 1 elementos. Desea continuar?"));
			break;
		}
		return true;
	}

	public static MensajeConfirmacionLevantarGlosa esCorrecto(String modoLenvatarGlosa, String cantidades) {
		return new MensajeConfirmacionLevantarGlosa(modoLenvatarGlosa, cantidades);
	}

}
