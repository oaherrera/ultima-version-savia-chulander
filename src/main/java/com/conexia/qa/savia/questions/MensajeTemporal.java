package com.conexia.qa.savia.questions;

import static com.conexia.qa.savia.modelos.MensajeTemporal.*;
import static com.conexia.qa.savia.user_interfaces.CommonPage.MENSAJE_TEMPORAL;
import static com.conexia.qa.savia.user_interfaces.CommonPage.MENSAJE_TEMPORAL_TEXTO;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class MensajeTemporal implements Question<String>{

	private String mensaje;
	private String mensajeTexto;
	@Override
	public String answeredBy(Actor actor) {
		mensaje = MENSAJE_TEMPORAL.resolveFor(actor).getText().trim();
		if(MENSAJE_TEMPORAL_TEXTO.resolveFor(actor).isVisible()){
			mensajeTexto = MENSAJE_TEMPORAL_TEXTO.resolveFor(actor).getText().trim();
		}
		guardarMensaje(mensaje);
		guardarMensajeTexto(mensajeTexto);
		System.out.println(traerMensaje());
		System.out.println(traerMensajeTexto());
		takeScreenshot();
		return mensaje;
	}

	public static MensajeTemporal es() {
		return new MensajeTemporal();
	}
	
}
