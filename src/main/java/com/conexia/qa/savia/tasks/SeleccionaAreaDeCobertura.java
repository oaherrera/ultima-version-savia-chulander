package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.user_interfaces.CommonPage.CONFIRMAR_SI;
import static com.conexia.qa.savia.user_interfaces.CommonPage.GUARDAR;
import static com.conexia.qa.savia.user_interfaces.NegociacionAreaDeCoberturaPage.REPLICAR_AREA;
import static com.conexia.qa.savia.user_interfaces.NegociacionAreaDeCoberturaPage.SELECCIONAR_AREA_DE_COBSERTURA;
import static com.conexia.qa.savia.user_interfaces.NegociacionAreaDeCoberturaPage.TITULO_AREA_DE_COBERTURA;
import static com.conexia.qa.savia.user_interfaces.NegociacionPage.AREA_DE_COBERTURA;
import static com.conexia.qa.savia.user_interfaces.NegociacionPage.AREA_DE_COBERTURA_SELECCION;
import static com.conexia.qa.savia.user_interfaces.NegociacionPage.ASIGNAR_AREA_DE_COBERTURA;
import static com.conexia.qa.savia.user_interfaces.NegociacionPage.NOMBRE_SEDE;
import static com.conexia.qa.savia.user_interfaces.NegociacionPage.SEDE_PRINCIPAL;
import static com.conexia.qa.savia.user_interfaces.NegociacionPage.SEDE_PRINCIPAL_SELECCION;
import static com.conexia.qa.savia.user_interfaces.NegociacionPage.SELECCIONAR_SEDE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

import com.conexia.qa.savia.interactions.CerrarVentanaDeDialogo;
import com.conexia.qa.savia.interactions.EsperarCargando;
import com.conexia.qa.savia.interactions.HacerClic;
import com.conexia.qa.savia.interactions.MueveScroll;
import com.conexia.qa.savia.modelos.SedePrestador;
import com.conexia.qa.savia.questions.EstaMarcado;
import com.conexia.qa.savia.questions.MensajeTemporal;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class SeleccionaAreaDeCobertura implements Task {

	private SedePrestador sedePrestador;

	public SeleccionaAreaDeCobertura() {
		sedePrestador = SedePrestador.traerSedePrestador();
	}

	@Step("{0} Selecciona area de cobertura para la #sedePrestador en la negociación ")
	@Override
	public <T extends Actor> void performAs(T actor) {
		String AreaCobertura = sedePrestador.traerSedePrestador(0).getAreaCobertura();

		actor.attemptsTo(Click.on(AREA_DE_COBERTURA));
		actor.attemptsTo(Click.on(AREA_DE_COBERTURA_SELECCION.of(AreaCobertura)));
		actor.attemptsTo(EsperarCargando.pagina());
		actor.attemptsTo(Click.on(GUARDAR), EsperarCargando.pagina());

		int indice = 0;
		while (indice < sedePrestador.traerSedesPrestador().size()) {
			String nombreSede = sedePrestador.traerSedePrestador(indice).getNombreSede();
			String sedePrincipal = sedePrestador.traerSedePrestador(indice).getSedePrincipal();

			actor.attemptsTo(Enter.theValue(nombreSede).into(NOMBRE_SEDE), EsperarCargando.pagina());
			actor.attemptsTo(Click.on(SELECCIONAR_SEDE.of(nombreSede)), EsperarCargando.pagina());
			actor.should(seeThat(MensajeTemporal.es(), containsString("Sede negociación asignada correctamente")));
			actor.attemptsTo(HacerClic.En(ASIGNAR_AREA_DE_COBERTURA.of(nombreSede)), EsperarCargando.pagina());

			TITULO_AREA_DE_COBERTURA.resolveFor(actor).isVisible();
			if (!actor.asksFor(EstaMarcado.elCheck(SELECCIONAR_AREA_DE_COBSERTURA)).booleanValue()) {
				actor.attemptsTo(Click.on(SELECCIONAR_AREA_DE_COBSERTURA));
				actor.attemptsTo(Click.on(REPLICAR_AREA));
				actor.attemptsTo(Click.on(CONFIRMAR_SI));
			} else {
				actor.attemptsTo(CerrarVentanaDeDialogo.desplegado());
			}

			if (sedePrincipal.trim().equalsIgnoreCase("X")) {
				actor.attemptsTo(MueveScroll.vertical(400));
				actor.attemptsTo(Click.on(SEDE_PRINCIPAL));
				actor.attemptsTo(MueveScroll.vertical(400));
				actor.attemptsTo(Click.on(SEDE_PRINCIPAL_SELECCION.of(nombreSede)));
			}
			indice++;
		}

	}

	public static SeleccionaAreaDeCobertura asociandoSedes() {
		return Tasks.instrumented(SeleccionaAreaDeCobertura.class);
	}

}
