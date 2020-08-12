package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.modelos.Tecnologias.traerTecnologias;
import static com.conexia.qa.savia.user_interfaces.CommonPage.CONFIRMAR_ACEPTAR;
import static com.conexia.qa.savia.user_interfaces.LevantaGlosaPage.JUSTIFICACION;
import static com.conexia.qa.savia.user_interfaces.LevantaGlosaPage.JUSTIFICACION_MASIVO;
import static com.conexia.qa.savia.user_interfaces.LevantaGlosaPage.LEVANTAR_GLOSA;
import static com.conexia.qa.savia.user_interfaces.LevantaGlosaPage.MOTIVO_LEVANTAMIENTO;
import static com.conexia.qa.savia.user_interfaces.LevantaGlosaPage.MOTIVO_LEVANTAMIENTO_SELECCION;
import static com.conexia.qa.savia.user_interfaces.LevantaGlosaPage.PESTAÑA_LEVANTAR_GLOSA;
import static com.conexia.qa.savia.user_interfaces.RadicadoGestionRadicadoPage.CANTIDAD_FACTURAS_RADICADO;

import com.conexia.qa.savia.interactions.MueveScroll;
import com.conexia.qa.savia.questions.MensajeConfirmacionLevantarGlosa;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class LevantoGlosa implements Task {

	private String modoLevantamiento;
	private String motivoLevantamiento;
	private String cantidadFacturas;

	public LevantoGlosa(String modoLevantamiento, String motivoLevantamiento) {
		this.modoLevantamiento = modoLevantamiento;
		this.motivoLevantamiento = motivoLevantamiento;
		this.cantidadFacturas = "";
	}

	@Step("{0} Levanta glosa #modoLevantamiento")
	@Override
	public <T extends Actor> void performAs(T actor) {

		switch (modoLevantamiento) {

		case "a todas las facturas":
			cantidadFacturas = CANTIDAD_FACTURAS_RADICADO.resolveFor(actor).getValue();
			actor.attemptsTo(Scroll.to(PESTAÑA_LEVANTAR_GLOSA), MueveScroll.vertical(-160));
			actor.attemptsTo(Click.on(PESTAÑA_LEVANTAR_GLOSA));
			actor.attemptsTo(Click.on(MOTIVO_LEVANTAMIENTO));
			actor.attemptsTo(Click.on(MOTIVO_LEVANTAMIENTO_SELECCION.of(motivoLevantamiento)));
			actor.attemptsTo(Enter.theValue("Justificación pruebas").into(JUSTIFICACION));
			actor.attemptsTo(Click.on(LEVANTAR_GLOSA));
			actor.asksFor(MensajeConfirmacionLevantarGlosa.esCorrecto(modoLevantamiento, cantidadFacturas));
			actor.attemptsTo(Click.on(CONFIRMAR_ACEPTAR));
			break;
		case "masiva":
			cantidadFacturas ="" + traerTecnologias().size();
			actor.attemptsTo(MueveScroll.vertical(800));
			actor.attemptsTo(Click.on(MOTIVO_LEVANTAMIENTO));
			actor.attemptsTo(Click.on(MOTIVO_LEVANTAMIENTO_SELECCION.of(motivoLevantamiento)));
			actor.attemptsTo(Enter.theValue("Justificación pruebas").into(JUSTIFICACION_MASIVO));
			actor.attemptsTo(Click.on(LEVANTAR_GLOSA));
			actor.asksFor(MensajeConfirmacionLevantarGlosa.esCorrecto(modoLevantamiento, cantidadFacturas));
			actor.attemptsTo(Click.on(CONFIRMAR_ACEPTAR));
			break;
		case "por item":
			actor.attemptsTo(Scroll.to(PESTAÑA_LEVANTAR_GLOSA), MueveScroll.vertical(-160));
			actor.attemptsTo(Click.on(PESTAÑA_LEVANTAR_GLOSA));
			actor.attemptsTo(Click.on(MOTIVO_LEVANTAMIENTO));
			actor.attemptsTo(Click.on(MOTIVO_LEVANTAMIENTO_SELECCION.of(motivoLevantamiento)));
			actor.attemptsTo(Enter.theValue("Justificación pruebas").into(JUSTIFICACION));
			actor.attemptsTo(Click.on(LEVANTAR_GLOSA));
			actor.asksFor(MensajeConfirmacionLevantarGlosa.esCorrecto(modoLevantamiento, cantidadFacturas));
			actor.attemptsTo(Click.on(CONFIRMAR_ACEPTAR));
		}

	}

	public static LevantoGlosa deModo(String modoLevantamiento, String motivoLevantamiento) {
		return Tasks.instrumented(LevantoGlosa.class, modoLevantamiento, motivoLevantamiento);
	}

}
