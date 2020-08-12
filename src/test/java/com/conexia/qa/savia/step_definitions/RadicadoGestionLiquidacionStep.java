package com.conexia.qa.savia.step_definitions;

import static com.conexia.qa.savia.modelos.FiltrosBusqueda.guardarInformacion;
import static com.conexia.qa.savia.modelos.FiltrosBusqueda.traerInformacion;
import static com.conexia.qa.savia.modelos.Glosas.guardarGlosa;
import static com.conexia.qa.savia.modelos.Glosas.limpiarGlosas;
import static com.conexia.qa.savia.modelos.Tecnologias.LimpiarTecnologias;
import static com.conexia.qa.savia.modelos.Tecnologias.guardarTecnologias;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import java.util.List;

import com.conexia.qa.savia.modelos.FiltrosBusqueda;
import com.conexia.qa.savia.modelos.Glosas;
import com.conexia.qa.savia.modelos.InformacionComplementariaFactura;
import com.conexia.qa.savia.modelos.Tecnologias;
import com.conexia.qa.savia.questions.ValidoEstadoRadicado;
import com.conexia.qa.savia.questions.VerEnAsignacionActual;
import com.conexia.qa.savia.tasks.AsignoEnBandejaRadicados;
import com.conexia.qa.savia.tasks.BuscarRadicado;
import com.conexia.qa.savia.tasks.CierreYConfirmarCierreCuenta;
import com.conexia.qa.savia.tasks.DiligenciaOpcionesDeFactura;
import com.conexia.qa.savia.tasks.FacturasRadicadasMarco;
import com.conexia.qa.savia.tasks.FiltroTecnologiasGlosa;
import com.conexia.qa.savia.tasks.GeneraGlosa;
import com.conexia.qa.savia.tasks.LevantoGlosa;
import com.conexia.qa.savia.tasks.ListasDeTrabajo;
import com.conexia.qa.savia.tasks.SeleccionoElPrimerServicio;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class RadicadoGestionLiquidacionStep {

	@And("^Consulto radicado en listas de trabajo$")
	public void consultoRadicadoEnListasDeTrabajo(List<FiltrosBusqueda> filtrarPor) {
		FiltrosBusqueda.limpiarInformacion();
		guardarInformacion(filtrarPor);
		int indice = 0;
		while (indice < filtrarPor.size()) {
			theActorInTheSpotlight().attemptsTo(BuscarRadicado.porFiltros(traerInformacion(indice).getFiltrarPor(),
					traerInformacion(indice).getValorBusqueda()));
			indice = indice + 1;
		}
	}

	@And("^Realizo la accion (.+) en listas de trabajo$")
	public void realizoLaAccionVerDetalleEnListasDeTrabajo(String accionEnListraTrabajo) {
		theActorInTheSpotlight().attemptsTo(ListasDeTrabajo.realizoAccion(accionEnListraTrabajo));
	}

	@And("^Marco todas las facturas como revisadas$")
	public void marcoTodasLasFacturasComoRevisadas() {
		theActorInTheSpotlight().attemptsTo(FacturasRadicadasMarco.todasLasFacturas(true));
	}

	@And("^Marco todas las facturas a glosar$")
	public void marcoTodasLasFacturasAGlosar() {
		theActorInTheSpotlight().attemptsTo(FacturasRadicadasMarco.todasLasFacturas(false));
	}

	@And("Selecciono uno de los servicios de la primera factura")
	public void SeleccionolaPrimeraFacturaRadicada() {
		theActorInTheSpotlight().attemptsTo(SeleccionoElPrimerServicio.paraLaPrimeraFacturaRadicado());
	}

	@And("^Diligenciar Opciones de Factura Informacion complementaria$")
	public void diliencioOpcionesDeFacturaInfoComplement(
			List<InformacionComplementariaFactura> InformacionValidarRipsData) {
		theActorInTheSpotlight().attemptsTo(DiligenciaOpcionesDeFactura.enInformacionComplementaria(
				InformacionValidarRipsData.get(0).getCodDiagnostico(), InformacionValidarRipsData.get(0).getAplicaPBS(),
				InformacionValidarRipsData.get(0).getCentroDeCosto(), InformacionValidarRipsData.get(0).getAltoCosto(),
				InformacionValidarRipsData.get(0).getAplicaNOPBS()));
	}

	@Then("^Radicado en estado (.+) en listas de trabajo radicado$")
	public void radicadoEnEstadoEnListasDeTrabajo(String estado) {
		theActorInTheSpotlight().should(seeThat(ValidoEstadoRadicado.enListaDeTrabajo(estado)));
	}

	@And("^Asigno a (.+), de la Regional: (.+), con el cargo:(.+)$")
	public void asignoA(String nombre, String regional, String cargo) {
		theActorInTheSpotlight().attemptsTo(AsignoEnBandejaRadicados.alUsuarioConLosDatos(regional, cargo, nombre));
	}

	@Then("^Puedo ver a (.+), en asignación actual$")
	public void puedoVerAUsuarioEnAsignaciónActual(String usuario) {
		theActorInTheSpotlight().should(seeThat(VerEnAsignacionActual.alUsuario(usuario)));
	}

	@And("^Cierro la cuenta y confirmo cierre de cuenta$")
	public void cierroLaCuentaYConfirmoCierreDeCuenta() {
		theActorInTheSpotlight().attemptsTo(CierreYConfirmarCierreCuenta.enBandejaRadicado());
	}

	@And("^Filtro las tecnologias aplicar glosa a la factura$")
	public void filtroLasTecnologiasAplicarGlosa(List<Tecnologias> dataTecnologias) {
		LimpiarTecnologias();
		guardarTecnologias(dataTecnologias);
		theActorInTheSpotlight().attemptsTo(FiltroTecnologiasGlosa.paraCrearGlosa());
	}
	
	@And("^Filtro las tecnologias para levantar glosa a la factura$")
	public void filtroLasTecnologiasLevantarGlosa(List<Tecnologias> dataTecnologias) {
		limpiarGlosas();
		guardarTecnologias(dataTecnologias);
		theActorInTheSpotlight().attemptsTo(FiltroTecnologiasGlosa.paraLevantarGlosa());
	}

	@And("^Genero glosa a todas las facuras con los siguientes datos$")
	public void generoGlosaATodasFacturasConLosSiguientesDatos(List<Glosas> dataGlosas) {
		limpiarGlosas();
		guardarGlosa(dataGlosas);
		theActorInTheSpotlight().attemptsTo(GeneraGlosa.aFacturas(Glosas.traerGlosa()));
	}

	@And("^Genero glosa masiva con los siguientes datos$")
	public void generoGlosaMasivaConLosSiguientesDatos(List<Glosas> dataGlosas) {
		limpiarGlosas();
		guardarGlosa(dataGlosas);
		theActorInTheSpotlight().attemptsTo(GeneraGlosa.masiva(Glosas.traerGlosa()));
	}
	
	@And("^Genero glosa por Item con los siguientes datos$")
	public void generoGlosaPorItemConLosSiguientesDatos(List<Glosas> dataGlosas) {
		limpiarGlosas();
		guardarGlosa(dataGlosas);
		theActorInTheSpotlight().attemptsTo(GeneraGlosa.porItem(Glosas.traerGlosa()));
	}
	
	@And("^Levanto la glosa (.+), con el motivo:(.+)$")
	public void levantoLaGlosaATodasLasFacturas(String modoLevantamiento, String motivoLevantamiento) {
		theActorInTheSpotlight().attemptsTo(LevantoGlosa.deModo(modoLevantamiento,motivoLevantamiento.trim()));
	}
}