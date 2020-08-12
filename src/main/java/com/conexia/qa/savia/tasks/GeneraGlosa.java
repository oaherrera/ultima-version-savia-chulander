package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.modelos.Tecnologias.traerTecnologias;
import static com.conexia.qa.savia.user_interfaces.CommonPage.CONFIRMAR_ACEPTAR;
import static com.conexia.qa.savia.user_interfaces.GeneraGlosaFacturaPage.GENERAR_GLOSA;
import static com.conexia.qa.savia.user_interfaces.GeneraGlosaFacturaPage.GENERAR_GLOSA_DEL_ITEM;
import static com.conexia.qa.savia.user_interfaces.GeneraGlosaFacturaPage.MOTIVO_GLOSA;
import static com.conexia.qa.savia.user_interfaces.RadicadoGestionRadicadoPage.CANTIDAD_FACTURAS_RADICADO;
import static net.serenitybdd.core.Serenity.takeScreenshot;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import java.util.List;

import com.conexia.qa.savia.interactions.EsperarCargando;
import com.conexia.qa.savia.interactions.MueveScroll;
import com.conexia.qa.savia.modelos.Glosas;
import com.conexia.qa.savia.questions.MensajeConfirmacionGlosa;
import com.conexia.qa.savia.questions.SeAgregoGlosaRadicado;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class GeneraGlosa implements Task {

	private String tipoDeGlosa;
	private List<Glosas> traerGlosa;
	private int indice;
	private int indiceExitoso;
	private String cantidadFacturas;

	public GeneraGlosa(String tipoDeGlosa, List<Glosas> traerGlosa) {
		this.tipoDeGlosa = tipoDeGlosa;
		this.traerGlosa = traerGlosa;
		this.indice = 0;
		this.indiceExitoso = 1;
		this.cantidadFacturas = "";
	}

	@Step("{0} genera glosa #tipoDeGlosa")
	@Override
	public <T extends Actor> void performAs(T actor) {

		if (tipoDeGlosa.equals("porFacturas")) {
			cantidadFacturas = CANTIDAD_FACTURAS_RADICADO.resolveFor(actor).getValue();
		}

		actor.attemptsTo(Scroll.to(MOTIVO_GLOSA), MueveScroll.vertical(-160));
		takeScreenshot();

		while (indice < traerGlosa.size()) {
			actor.attemptsTo(
					LlenoFomularioGeneracionGlosa.conLosDatos(
							traerGlosa.get(indice).getMotivoGlosa(),
							traerGlosa.get(indice).getMotivoCodigo(), 
							traerGlosa.get(indice).getTotalOParcial(),
							traerGlosa.get(indice).getJustificacion(), 
							traerGlosa.get(indice).getParcialValorGlosa(),
							traerGlosa.get(indice).getMensajeEsperado())
					);
			if (traerGlosa.get(indice).getExitoso().equalsIgnoreCase("S")) {
				actor.should(seeThat(
						SeAgregoGlosaRadicado.enLaPantalla(indiceExitoso, traerGlosa.get(indice).getMotivoCodigo())));
				indiceExitoso++;
			}
			indice++;

		}

		takeScreenshot();
		String parcialOTotal = traerGlosa.get(indice-1).getParcialValorGlosa();

		switch (tipoDeGlosa) {
		case "porFacturas":
			actor.attemptsTo(Click.on(GENERAR_GLOSA));
			actor.asksFor(MensajeConfirmacionGlosa.esCorrecto(tipoDeGlosa, parcialOTotal, cantidadFacturas));
			actor.attemptsTo(Click.on(CONFIRMAR_ACEPTAR), EsperarCargando.pagina());
			break;
		case "masivo":
			cantidadFacturas = "" + traerTecnologias().size();
			actor.attemptsTo(Click.on(GENERAR_GLOSA_DEL_ITEM));
			actor.asksFor(MensajeConfirmacionGlosa.esCorrecto(tipoDeGlosa, parcialOTotal, cantidadFacturas));
			actor.attemptsTo(Click.on(CONFIRMAR_ACEPTAR), EsperarCargando.pagina());
			break;
		case "porItem":
			actor.attemptsTo(Click.on(GENERAR_GLOSA_DEL_ITEM));
			actor.asksFor(MensajeConfirmacionGlosa.esCorrecto(tipoDeGlosa, parcialOTotal, cantidadFacturas));
			actor.attemptsTo(Click.on(CONFIRMAR_ACEPTAR), EsperarCargando.pagina());
			break;
		}
		takeScreenshot();
	}

	public static GeneraGlosa aFacturas(List<Glosas> traerGlosa) {
		return Tasks.instrumented(GeneraGlosa.class, "porFacturas", traerGlosa);
	}

	public static GeneraGlosa masiva(List<Glosas> traerGlosa) {
		return Tasks.instrumented(GeneraGlosa.class, "masivo", traerGlosa);
	}

	public static GeneraGlosa porItem(List<Glosas> traerGlosa) {
		return Tasks.instrumented(GeneraGlosa.class, "porItem", traerGlosa);
	}

}
