package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.user_interfaces.GeneraGlosaFacturaPage.ADICIONAR_MOTIVO;
import static com.conexia.qa.savia.user_interfaces.GeneraGlosaFacturaPage.JUSTIFICACION;
import static com.conexia.qa.savia.user_interfaces.GeneraGlosaFacturaPage.MOTIVO_CODIGO_GLOSA;
import static com.conexia.qa.savia.user_interfaces.GeneraGlosaFacturaPage.MOTIVO_CODIGO_GLOSA_SELECCION;
import static com.conexia.qa.savia.user_interfaces.GeneraGlosaFacturaPage.MOTIVO_GLOSA;
import static com.conexia.qa.savia.user_interfaces.GeneraGlosaFacturaPage.MOTIVO_GLOSA_SELECCION;
import static com.conexia.qa.savia.user_interfaces.GeneraGlosaFacturaPage.TIPO_GLOSA_PARCIAL;
import static com.conexia.qa.savia.user_interfaces.GeneraGlosaFacturaPage.TIPO_GLOSA_PARCIAL_ACTIVO;
import static com.conexia.qa.savia.user_interfaces.GeneraGlosaFacturaPage.TIPO_GLOSA_TOTAL;
import static com.conexia.qa.savia.user_interfaces.GeneraGlosaFacturaPage.TIPO_GLOSA_TOTAL_ACTIVO;
import static com.conexia.qa.savia.user_interfaces.GeneraGlosaFacturaPage.VALOR_GLOSA;
import static net.serenitybdd.core.Serenity.takeScreenshot;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

import com.conexia.qa.savia.interactions.Esperar;
import com.conexia.qa.savia.interactions.EsperarCargando;
import com.conexia.qa.savia.questions.MensajeTemporal;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class LlenoFomularioGeneracionGlosa implements Task {

	private String motivoGlosa;
	private String motivoCodigo;
	private String totalOParcial;
	private String justificacion;
	private String parcialValorGlosa;
	private String mensajeEsperado;

	public LlenoFomularioGeneracionGlosa(String motivoGlosa, String motivoCodigo, String totalOParcial,
			String justificacion, String parcialValorGlosa, String mensajeEsperado) {
		this.motivoGlosa = motivoGlosa;
		this.motivoCodigo = motivoCodigo;
		this.totalOParcial = totalOParcial;
		this.justificacion = justificacion;
		this.parcialValorGlosa = parcialValorGlosa;
		this.mensajeEsperado = mensajeEsperado;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		takeScreenshot();
		actor.attemptsTo(Click.on(MOTIVO_GLOSA));
		actor.attemptsTo(Click.on(MOTIVO_GLOSA_SELECCION.of(motivoGlosa)), Esperar.por(1000));
		actor.attemptsTo(Enter.theValue(motivoCodigo).into(MOTIVO_CODIGO_GLOSA), Esperar.por(1000));
		actor.attemptsTo(Click.on(MOTIVO_CODIGO_GLOSA_SELECCION.of(motivoCodigo)), Esperar.por(1000));
		if (totalOParcial.equalsIgnoreCase("Total")
				&& !TIPO_GLOSA_TOTAL_ACTIVO.resolveFor(actor).getAttribute("class").contains("ui-state-active")) {
			actor.attemptsTo(Click.on(TIPO_GLOSA_TOTAL));
		} else if (totalOParcial.equalsIgnoreCase("Parcial")) {
			if (!TIPO_GLOSA_PARCIAL_ACTIVO.resolveFor(actor).getAttribute("class").contains("ui-state-active")) {
				actor.attemptsTo(Click.on(TIPO_GLOSA_PARCIAL));
			}
			actor.attemptsTo(Enter.theValue(parcialValorGlosa).into(VALOR_GLOSA));
		}
		actor.attemptsTo(Enter.theValue(justificacion).into(JUSTIFICACION));
		takeScreenshot();
		actor.attemptsTo(Click.on(ADICIONAR_MOTIVO), EsperarCargando.pagina());

		if (!mensajeEsperado.equalsIgnoreCase("")) {
			actor.should(seeThat(MensajeTemporal.es(), equalToIgnoringCase(mensajeEsperado)));
		}

		takeScreenshot();

	}

	public static LlenoFomularioGeneracionGlosa conLosDatos(String motivoGlosa, String motivoCodigo,
			String totalOParcial, String justificacion, String parcialValorGlosa, String mensajeEsperado) {
		return Tasks.instrumented(LlenoFomularioGeneracionGlosa.class, motivoGlosa, motivoCodigo, totalOParcial,
				justificacion, parcialValorGlosa, mensajeEsperado);
	}

}
