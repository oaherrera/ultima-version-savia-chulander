package com.conexia.qa.savia.questions;

import static com.conexia.qa.savia.user_interfaces.GeneraGlosaFacturaPage.DESCRIPCION;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class SeAgregoGlosaRadicado implements Question<Boolean>{

	private int posicionDelRegistro;
	private String descripcion;

	private SeAgregoGlosaRadicado(int posicionDelRegistro,String descripcion) {
		this.posicionDelRegistro = posicionDelRegistro;
		this.descripcion = descripcion;
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		String DescripcionObtenida = DESCRIPCION.of(""+posicionDelRegistro).resolveFor(actor).getText();
		return DescripcionObtenida.equalsIgnoreCase(descripcion);
	}

	public static SeAgregoGlosaRadicado enLaPantalla(int posicionDelRegistro, String descripcion) {
		return new SeAgregoGlosaRadicado(posicionDelRegistro,descripcion);
	}

}
