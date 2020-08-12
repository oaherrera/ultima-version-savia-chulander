package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.modelos.InformacionValidarRips.traerInformacion;
import static com.conexia.qa.savia.user_interfaces.RipsValidacionCuentaPage.ANHO_DE_PRESTACION;
import static com.conexia.qa.savia.user_interfaces.RipsValidacionCuentaPage.ANHO_DE_PRESTACION_SELECCION;
import static com.conexia.qa.savia.user_interfaces.RipsValidacionCuentaPage.BUSCAR_CONTRATO;
import static com.conexia.qa.savia.user_interfaces.RipsValidacionCuentaPage.CONTRATO_BUSCAR_CONTRATO;
import static com.conexia.qa.savia.user_interfaces.RipsValidacionCuentaPage.CONTRATO_MODALIDAD;
import static com.conexia.qa.savia.user_interfaces.RipsValidacionCuentaPage.CONTRATO_MODALIDAD_SELECCION;
import static com.conexia.qa.savia.user_interfaces.RipsValidacionCuentaPage.CONTRATO_REGIMEN;
import static com.conexia.qa.savia.user_interfaces.RipsValidacionCuentaPage.CONTRATO_REGIMEN_SELECCION;
import static com.conexia.qa.savia.user_interfaces.RipsValidacionCuentaPage.CONTRATO_SEDE_IPS;
import static com.conexia.qa.savia.user_interfaces.RipsValidacionCuentaPage.CONTRATO_SEDE_IPS_SELECCION;
import static com.conexia.qa.savia.user_interfaces.RipsValidacionCuentaPage.IPS;
import static com.conexia.qa.savia.user_interfaces.RipsValidacionCuentaPage.IPS_SELECCION;
import static com.conexia.qa.savia.user_interfaces.RipsValidacionCuentaPage.MES_DE_PRESTACION;
import static com.conexia.qa.savia.user_interfaces.RipsValidacionCuentaPage.MES_DE_PRESTACION_SELECCION;
import static com.conexia.qa.savia.user_interfaces.RipsValidacionCuentaPage.NUMERO_DE_CONTRATO;
import static com.conexia.qa.savia.user_interfaces.RipsValidacionCuentaPage.NUMERO_DE_CUENTA;
import static com.conexia.qa.savia.user_interfaces.RipsValidacionCuentaPage.REGIONAL;
import static com.conexia.qa.savia.user_interfaces.RipsValidacionCuentaPage.REGIONAL_SELECCION;
import static com.conexia.qa.savia.user_interfaces.RipsValidacionCuentaPage.RESPONSABE_DE_PAGO;
import static com.conexia.qa.savia.user_interfaces.RipsValidacionCuentaPage.RESPONSABE_DE_PAGO_SELECCION;
import static com.conexia.qa.savia.user_interfaces.RipsValidacionCuentaPage.SEDE;
import static com.conexia.qa.savia.user_interfaces.RipsValidacionCuentaPage.SEDE_SELECCION;
import static com.conexia.qa.savia.user_interfaces.RipsValidacionCuentaPage.SELECCIONAR_CONTRATO;
import static com.conexia.qa.savia.user_interfaces.RipsValidacionCuentaPage.VALOR_CUENTA;

import com.conexia.qa.savia.interactions.Esperar;
import com.conexia.qa.savia.interactions.EsperarCargando;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class DiligencioFormularioValidacionCuentaRips implements Task {

	private String ips;
	private String sede;
	private String mesPrestacion;
	private String anhoPrestacion;
	private String nroCuenta;
	private String valorCuenta;
	private String regimen;
	private String contrato;
	private String modalidad;
	private String responsableDePago;
	private String regional;

	public DiligencioFormularioValidacionCuentaRips() {
		this.ips = traerInformacion(0).getIps();
		this.sede = traerInformacion(0).getSede();
		this.mesPrestacion = traerInformacion(0).getMesPrestacion();
		this.anhoPrestacion = traerInformacion(0).getAnhoPrestacion();
		this.nroCuenta = traerInformacion(0).getNroCuenta();
		this.valorCuenta = traerInformacion(0).getValorCuenta();
		this.regimen = traerInformacion(0).getRegimen();
		this.contrato = traerInformacion(0).getControto();
		this.modalidad = traerInformacion(0).getModalidad();
		this.responsableDePago = traerInformacion(0).getResponsableDePago();
		this.regional = traerInformacion(0).getRegional();
	}

	@Step("{0} Llena Formulario de cargue de rips .")
	@Override
	public <T extends Actor> void performAs(T actor) {
		Serenity.takeScreenshot();
		actor.attemptsTo(Enter.theValue(ips).into(IPS));
		actor.attemptsTo(Click.on(IPS_SELECCION.of(ips)),Esperar.por(1000));
		actor.attemptsTo(Enter.theValue(sede).into(SEDE));
		actor.attemptsTo(Click.on(SEDE_SELECCION.of(sede)));
		actor.attemptsTo(Click.on(MES_DE_PRESTACION));
		actor.attemptsTo(Click.on(MES_DE_PRESTACION_SELECCION.of(mesPrestacion)));
		actor.attemptsTo(Click.on(ANHO_DE_PRESTACION));
		actor.attemptsTo(Click.on(ANHO_DE_PRESTACION_SELECCION.of(anhoPrestacion)));
		actor.attemptsTo(Enter.theValue(nroCuenta).into(NUMERO_DE_CUENTA));
		actor.attemptsTo(Enter.theValue(valorCuenta).into(VALOR_CUENTA),EsperarCargando.pagina());
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(BUSCAR_CONTRATO),EsperarCargando.pagina());
		actor.attemptsTo(Click.on(CONTRATO_SEDE_IPS));
		actor.attemptsTo(Click.on(CONTRATO_SEDE_IPS_SELECCION.of(sede)));
		actor.attemptsTo(Enter.theValue(contrato).into(NUMERO_DE_CONTRATO));
		actor.attemptsTo(Click.on(CONTRATO_REGIMEN));
		actor.attemptsTo(Click.on(CONTRATO_REGIMEN_SELECCION.of(regimen)));
		actor.attemptsTo(Click.on(CONTRATO_MODALIDAD));
		actor.attemptsTo(Click.on(CONTRATO_MODALIDAD_SELECCION.of(modalidad)));
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(CONTRATO_BUSCAR_CONTRATO),EsperarCargando.pagina());
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(SELECCIONAR_CONTRATO),EsperarCargando.pagina());
		actor.attemptsTo(Click.on(RESPONSABE_DE_PAGO));
		actor.attemptsTo(Click.on(RESPONSABE_DE_PAGO_SELECCION.of(responsableDePago)));
		actor.attemptsTo(Click.on(REGIONAL));
		actor.attemptsTo(Click.on(REGIONAL_SELECCION.of(regional)));
		Serenity.takeScreenshot();
	}

	public static DiligencioFormularioValidacionCuentaRips conTodosLosDatos() {
		return Tasks.instrumented(DiligencioFormularioValidacionCuentaRips.class);
	}

}
